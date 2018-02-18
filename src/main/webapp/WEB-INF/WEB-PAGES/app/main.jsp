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
            });
        </script>
    </head>
    <body>
            <div class="ui thin visible left vertical inverted sidebar labeled icon menu">
                <a class="item" href="<c:url value="/dashboard"/>">
                    <i class="fa fa-tachometer fa-3x" aria-hidden="true"></i>
                    <br/><br/>
                    Главная
                </a>
                <a class="item" href="<c:url value="/employers"/>">
                    <i class="fa fa-user-o fa-3x" aria-hidden="true"></i>
                    <br/><br/>
                    Работники
                </a>
                <a class="item" href="<c:url value="/reports"/>">
                    <i class="fa fa-print fa-3x" aria-hidden="true"></i>
                    <br/><br/>
                    Отчеты
                </a>
                <a class="item" href="<c:url value="/calendar"/>">
                    <i class="fa fa-calendar fa-3x" aria-hidden="true"></i>
                    <br/><br/>
                    Календарь
                </a>
                <a class="item" href="<c:url value="/settings"/>">
                    <i class="fa fa-wrench fa-3x" aria-hidden="true"></i>
                    <br/><br/>
                    Настройки
                </a>

                <a class="item" id="exit" href="<c:url value="/logout"/>">
                    <i class="fa fa-sign-out  fa-3x" aria-hidden="true"></i>
                    <br/><br/>
                    Выход
                </a>
            </div>
            <div class="pusher" style="margin: 10px;">
                
            </div>
        </div>
        
    </body>
</html>
