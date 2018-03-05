<%-- 
    Document   : employers
    Created on : 18.02.2018, 16:38:54
    Author     : Aleksey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<script>
    $(document).ready(function () {
        $('table').tablesort();

        $(document).on("dblclick", "table tbody tr", function () {
            var employee = getEmployeeByID('<core:url value="/employee/getbyid"/>', $(this).closest('tr').attr('id'));
            populateEmployeeForm('#employeeinfo', $.parseJSON(employee));

            $('.ui.modal.employeeinfo')
                    .modal('setting', 'transition', "fade up")
                    .modal('show');
        });

        $(document).on("click", "table tbody tr", function () {
            $('tr.active').removeClass('active');
            $(this).closest('tr').addClass('active');
        });

        /*
         $('body').not('p').click(function(){
         $('tr.active').removeClass('active');
         });
         */

        $('#addemployee').click(function () {
            $('.ui.modal.newemployee')
                    .modal('setting', 'transition', "fade up")
                    .modal('show');
        });

        $('#deleteemployee').click(function () {
            //var employee = deleteEmployeeByID('<core:url value="/employee/getbyid"/>', $('table tbody tr').closest('tr.active').attr('id'));
            //alert(employee);
            if ($('table tbody tr').closest('tr.active').length) {
                $('.ui.modal.deleteemployee')
                        .modal({
                            closable: false,
                            onDeny: function () {
                                //window.alert('Wait not yet!');
                                //return false;
                            },
                            onApprove: function () {
                                //window.alert($('table tbody tr').closest('tr.active').attr('id'));
                                let id = $('table tbody tr').closest('tr.active').attr('id');
                                let res = deleteEmployeeByID('<core:url value="/employee/deletebyid"/>', id);
                                if (res === 'true')
                                    $('table tbody tr').closest('tr.active').remove();
                            }
                        })
                        .modal('show');
            } else {
                $('.tiny.modal')
                        .modal('show');
            }

        });

        $("#search_input").keyup(function () {
            var value = this.value.toLowerCase().trim();

            $("table tr").each(function (index) {
                if (!index)
                    return;
                $(this).find("td").each(function () {
                    var id = $(this).text().toLowerCase().trim();
                    var not_found = (id.indexOf(value) === -1);
                    $(this).closest('tr').toggle(!not_found);
                    return not_found;
                });
            });
        });

        $.ajax({
            url: '<core:url value="/employee/getall"/>',
            data: "{}",
            type: "GET",

            contentType: "application/json; charset=utf-8",

            dataType: "json",
            cache: false,

            success: function (response) {
                console.log('Response received for employers table', response);
                $('.table').append(
                        $.map(response, function (item, index) {
                            return '<tr id="' + response[index].id + '">' + '<td>' + response[index].sirname + '</td><td>' + response[index].name + '</td><td>'
                                    + response[index].patronymic + '</td><td>' + response[index].profession + '</td><td>'
                                    + response[index].wage_rate + '</td><td>' + response[index].birthDate + '</td></tr>';
                        }).join());
            },
            error: function (response) {
                console.log('Error while receiving response for employers table', response);
            }
        });
    });

</script>

<div class="ui input">
    <input id="search_input" type="text" placeholder="Найти...">
</div>
<table class="ui sortable selectable celled table">
    <thead>
        <tr>
            <th>Фамилия</th>
            <th>Имя</th>
            <th>Отчество</th>
            <th>Специальность</th>
            <th>Количество ставок</th>
            <th>Дата рождения</th>
        </tr>
    </thead>
    <tbody>
    </tbody>
    <%-- 
        <tfoot>
            <tr><th colspan="6">
                    <div class="ui right floated pagination menu">
                        <a class="icon item">
                            <i class="left chevron icon"></i>
                        </a>
                        <a class="item">1</a>
                        <a class="item">2</a>
                        <a class="item">3</a>
                        <a class="item">4</a>
                        <a class="icon item">
                            <i class="right chevron icon"></i>
                        </a>
                    </div>
                </th>
            </tr>
        </tfoot>
    --%>
</table>
<div class="ui right floated buttons">
    <div id="addemployee" class="ui small primary labeled icon button">
        <i class="add user icon"></i> 
        Добавить
    </div>

    <div class="or" data-text="и"></div>

    <div id="deleteemployee" class="ui small negative right labeled icon button">
        <i class="trash alternate outline icon"></i> 
        Удалить
    </div>

</div>


<!-- Подтверждение удаления информации о работнике -->

<div class="ui small basic modal deleteemployee">
    <div class="ui icon header">
        <i class="archive icon"></i>
        Удаление записи
    </div>
    <div class="content">
        <p>Вы действительно хотите удалить информацию о работнике? 
            Удаленные данные восстановить будет невозможно!</p>
    </div>
    <div class="actions">
        <div class="ui red basic cancel inverted button">
            <i class="remove icon"></i>
            Нет
        </div>
        <div class="ui green ok inverted button">
            <i class="checkmark icon"></i>
            Да
        </div>
    </div>
</div>


<!-- Не выбран работник для удаления -->

<div class="ui tiny modal">
    <div class="header">
        Не выбрана запись
    </div>
    <div class="content">
        Для удаления информации о работнике, 
        щелкните мышкой в таблице на нужном работнике и нажмите кнопку "Удалить"
    </div>
    <div class="actions">
        <div class="ui positive icon button">
            <i class="checkmark icon"></i>
            Хорошо
        </div>
    </div>
</div>


<!-- Добавить работника -->

<div class="ui modal newemployee">
    <i class="close icon"></i>
    <div class="header">
        <i class="add user icon"></i>
        Добавить работника
    </div>
    <div class="content">
        <div id="EmployeeForm" class="ui form" method="POST" action="<core:url value="/employee/add"/>">
            <div class="field">
                <div class="three fields">
                    <div class="required field">
                        <label>Фамилия</label>
                        <input type="text" name="sirname" placeholder="Фамилия">
                    </div>
                    <div class="required field">
                        <label>Имя</label>
                        <input type="text" name="name" placeholder="Имя">
                    </div>
                    <div class="field">
                        <label>Отчество</label>
                        <input type="text" name="patronymic" placeholder="Отчество">
                    </div>
                </div>
            </div>
            <div class="field">
                <div class="three fields">
                    <div class="field">
                        <label>Дата рождения</label>
                        <input type="text" name="birthDate" placeholder="Дата рождения">
                    </div>
                    <div class="required field">
                        <label>Специальность</label>
                        <input type="text" name="profession" placeholder="Специальность">
                    </div>
                    <div class="required field">
                        <label>Количество ставок</label>
                        <input type="text" name="wage_rate" placeholder="Количество ставок">
                    </div>
                    <div class="required field">
                        <label>Пол</label>
                        <select>
                            <option value="">Пол</option>
                            <option value="MAN">Мужчина</option>
                            <option value="WOMAN">Женщина</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="required inline field">
                <label>Поля обязательные для заполнения</label>
            </div>
        </div>
    </div>
    <div class="actions">
        <div class="ui black deny button">Отмена</div>
        <div class="ui positive right labeled icon button">
            Добавить
            <i class="checkmark icon"></i>
        </div>
    </div>
</div>