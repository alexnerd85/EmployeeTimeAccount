<%-- 
    Document   : employers
    Created on : 18.02.2018, 16:38:54
    Author     : Aleksey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="ui basic segment">
    <div class="ui grid">
        <div class="fourteen wide column">
            <table class="ui sortable celled table">
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
                <c:forEach var="employee" items="${employees}">
                    <tr>
                        <td>${employee.sirname}</td>
                        <td>${employee.name}</td>
                        <td>${employee.patronymic}</td>
                        <td>${employee.profession}</td>
                        <td>${employee.wage_rate}</td>
                        <td>${employee.birthDate}</td>
                    </tr>
                </c:forEach>
                <tfoot>
                    <tr>
                        <th colspan="6">Количество сотрудников: ${employees.size()}</th>
                    </tr>
                </tfoot>
            </table>
            <div class="ui right floated small primary labeled icon button">
                <i class="add user icon"></i> 
                Добавить
            </div>    
        </div>
    </div>
    <p></p>
    <p></p>
    <p></p>
    <p></p>
</div>
