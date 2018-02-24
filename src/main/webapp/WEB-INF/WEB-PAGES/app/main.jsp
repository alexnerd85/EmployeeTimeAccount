<%-- 
    Created on : 21.01.2018, 21:51:05
    Author     : Popov Aleksey
    Site       : alexnerd.com
    Email      : alexnerd85@gmail.com
    GitHub     : https://github.com/alexnerd85/EmployeeTimeAccount 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EmployeeTimeAccount</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/lib/Semantic-UI-CSS-master/semantic.css"/>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/Semantic-UI-CSS-master/semantic.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/tablesort.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/loadpage.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/Chart.bundle.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $('table').tablesort();

                $('.pusher').load("<c:url value="/dashboard"/>");

                $('a').on('click', function (e) {
                    if ($(this).attr('id') !== 'exit') {
                        e.preventDefault();
                        var pageRef = $(this).attr('href');
                        callPage(pageRef);
                    }
                });

                $('.ui.search')
                        .search({
                            type: 'category',
                            minCharacters: 3,
                            apiSettings: {
                                url: '<c:url value="/employee/search?q={query}"/>',
                                onResponse: function (serverResponse) {
                                    var
                                            response = {
                                                results: {}
                                            }
                                    ;
                                    if (!serverResponse) {
                                        return;
                                    }
                                    // translate GitHub API response to work with search
                                    $.each(serverResponse, function (index, item) {
                                        var
                                                profession = item.profession || 'Unknown',
                                                maxResults = 8
                                                ;
                                        if (index >= maxResults) {
                                            return false;
                                        }
                                        // create new category
                                        if (response.results[profession] === undefined) {
                                            response.results[profession] = {
                                                name: profession,
                                                results: []
                                            };
                                        }
                                        // add result to category
                                        response.results[profession].results.push({
                                            title: item.sirname + ' ' + item.name,
                                            description: item.profession,
                                            url: item.html_url
                                        });
                                    });
                                    return response;
                                }
                            }
                        })


            });

        </script>
    </head>
    <body style="margin-left: 120px; margin-top: 50px; margin-right: 20px; margin-bottom: 10px;">
        <sec:authentication var="principal" property="principal" />
        <div class="ui fixed inverted menu" style="margin-left: 50px;">
            <div class="ui container">
                <div class="item">
                    <H4>
                        EmployeeTimeAccount
                    </h4>
                </div>
                <div class="item align right">
                    <div class="ui search">
                        <div class="ui inverted transparent icon input">
                            <input class="prompt" type="text" placeholder="Найти...">
                            <i class="search icon"></i>
                        </div>
                        <div class="results"></div>
                    </div>
                </div>
                <div class="item">
                    Пользователь: 
                    &nbsp;&nbsp;&nbsp;
                    ${principal.username}
                    &nbsp;&nbsp;
                    <i class="user icon"></i>
                </div>
            </div>

        </div>

        <div class="ui overlay visible left vertical inverted sidebar labeled icon menu">
            <a class="item" href="<c:url value="/dashboard"/>">
                <i class="tachometer alternate icon"></i>
                Главная
            </a>
            <a class="item" href="<c:url value="/employers"/>">
                <i class="users icon"></i>
                Работники
            </a>
            <a class="item" href="<c:url value="/reports"/>">
                <i class="print icon"></i>
                Отчеты
            </a>
            <a class="item" href="<c:url value="/calendar"/>">
                <i class="calendar alternate outline icon"></i>
                Календарь
            </a>
            <sec:authorize access="hasAuthority('ADMIN')">
                <a class="item" href="<c:url value="/settings"/>">
                    <i class="wrench outline icon"></i>
                    Настройки
                </a>
            </sec:authorize>

            <a class="item" id="exit" href="<c:url value="/logout"/>">
                <i class="sign out alternate icon"></i>
                Выход
            </a>
        </div>


        <div class="pusher">

        </div>

    </body>
</html>
