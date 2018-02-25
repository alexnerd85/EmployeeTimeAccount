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
            //alert($(this).closest('tr').attr('id'));
            $('.ui.modal')
                    .modal('setting', 'transition', "fade up")
                    .modal('show');
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
            <th>Оклад</th>
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
<div class="ui right floated small primary labeled icon button">
    <i class="add user icon"></i> 
    Добавить
</div>
<div class="ui modal">
    <i class="close icon"></i>
    <div class="header">
        <i class="address book outline icon"></i>
        Сведения о работнике
    </div>
    <div class="image content">
        <div class="image">
            An image can appear on left or an icon
        </div>
        <div class="description">
            A description can appear on the right
        </div>
    </div>
    <div class="actions">
        <div class="ui negative button">Отмена</div>
        <div class="ui positive right labeled icon button">
            Сохранить
            <i class="checkmark icon"></i>
        </div>
    </div>
</div>