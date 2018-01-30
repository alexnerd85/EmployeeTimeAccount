<%-- 
    Created on : 21.01.2018, 21:51:05
    Author     : Popov Aleksey
    Site       : alexnerd.com
    Email      : alexnerd85@gmail.com
    GitHub     : https://github.com/alexnerd85/EmployeeTimeAccount 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/lib/Semantic-UI-CSS-master/semantic.css"/>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/lib/font-awesome-4.7.0/css/font-awesome.min.css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/Semantic-UI-CSS-master/semantic.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/tablesort.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $('table').tablesort();
            });
        </script>
    </head>
    <body>
        <div class="ui bottom attached segment pushable">
            <div class="ui visible labeled icon inverted left vertical sidebar menu">
                <a class="item">
                    <%--<i class="dashboard icon"></i>--%>
                    <i class="fa fa-tachometer fa-3x" aria-hidden="true"></i>
                    <br/><br/>
                    Главная
                </a>
                <a class="item">
                    <%--<i class="home icon"></i> --%>
                    <i class="fa fa-user-o fa-3x" aria-hidden="true"></i>
                    <br/><br/>
                    Работники
                </a>
                <a class="item">
                    <i class="fa fa-print fa-3x"></i>
                    <br/><br/>
                    Отчеты
                </a>
                <a class="item">
                    <i class="fa fa-calendar fa-3x"></i>
                    <br/><br/>
                    Календарь
                </a>
                <a class="item">
                    <i class="fa fa-wrench fa-3x"></i>
                    <br/><br/>
                    Настройки
                </a>
                    
                <a class="item" href="<c:url value="/logout"/>">
                    <i class="fa fa-sign-out  fa-3x"></i>
                    <br/><br/>
                    Выход
                </a>
            </div>
            <div class="ui container">
                <div class="ui basic segment">
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
        </div>
    </body>
</html>
