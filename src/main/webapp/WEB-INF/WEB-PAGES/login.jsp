<%-- 
    Document   : login
    Created on : 31.01.2018, 9:48:24
    Author     : Aleksey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Вход на сайт</title>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/lib/Semantic-UI-CSS-master/semantic.css"/>
        <link type="text/css" rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/resources/lib/jquery-ui-1.12.1.custom/jquery-ui.css"/>
        <style>
            label, input { display:block; }
            input.text { margin-bottom:12px; width:95%; padding: .4em; }
            fieldset { padding:0; border:0; margin-top:25px; }
            h1 { font-size: 1.2em; margin: .6em 0; }
            div#users-contain { width: 350px; margin: 20px 0; }
            div#users-contain table { margin: 1em 0; border-collapse: collapse; width: 100%; }
            div#users-contain table td, div#users-contain table th { border: 1px solid #eee; padding: .6em 10px; text-align: left; }
            .ui-dialog .ui-state-error { padding: .3em; }
            .validateTips { border: 1px solid transparent; padding: 0.3em; }
        </style>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/Semantic-UI-CSS-master/semantic.js"></script>
        <script type="text/javascript">
            $(function () {
                $('.message .close')
                        .on('click', function () {
                            $(this)
                                    .closest('.message')
                                    .transition('fade')
                                    ;
                        });
            });
        </script>
    </head>
    <body style="background-color: #ECF0F1;">
        <div class="page-login" style="margin-top: 25px;">
            <div class="ui centered grid container">
                <div class="nine wide column">
                    <c:if test="${param.error != null}">
                        <div class="ui icon warning message">
                            <i class="lock icon"></i>
                            <div class="content">
                                <div class="header">
                                    Неудачная попытка входа!
                                </div>
                                <p>Вы наверное ошиблись с логином или паролем. Попробуйте еще раз.</p>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${param.logout != null}">
                        <div class="ui success message">
                            <i class="close icon"></i>
                            <div class="header">
                                Вы успешно вышли из программы.
                            </div>
                            <p>Для того, чтобы вновь вернуться в программу введите логин и пароль в форме ниже</p>
                        </div>

                    </c:if>

                    <div class="ui fluid card">
                        <div class="content">
                            <c:url var="loginUrl" value="/login" />
                            <form class="ui form" action="${loginUrl}" method="POST">
                                <div class="field">
                                    <label>Логин</label>
                                    <input type="text" id="username" name="username" placeholder="Введите Логин" required>
                                </div>
                                <div class="field">
                                    <label>Пароль</label>
                                    <input type="password" id="password" name="password" placeholder="Введите пароль" required>
                                </div>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                <div class="aligned right aligned grid">
                                    <button class="ui primary labeled icon button" type="submit">
                                        <i class="unlock alternate icon"></i>
                                        Вход
                                    </button>
                                    <br/>
                                    <br/>
                                    <div class="aligned right aligned grid">
                                        Debug: user: user  password: password
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

