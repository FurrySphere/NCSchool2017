<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <link href="/css/style.css" type="text/css" rel="stylesheet">
        <link href="/css/bootstrap.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>

    <body>
        <nav role="navigation" class="navigationBar navbar-default navbar-fixed-top" >
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-target="#navbarCollapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>

                    <form id="home_form" action="${pageContext.request.contextPath}/controller" method="POST">
                        <input type="hidden" name="command" value="show_student_list"/>
                        <a class="navbar-brand" onclick="document.getElementById('home_form').submit(); return false;"
                           href="#">Work with students</a>
                    </form>

                    <ul class="nav navbar-nav">
                        <c:if test="${sessionScope.role != null}">
                            <c:if test="${sessionScope.role eq 'PROFESSOR'}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/jsp/addStudent.jsp">Add student</a>
                                </li>
                                <li>
                                    <a href="#" onclick="document.getElementById('users_form').submit();">Users</a>
                                </li>
                            </c:if>
                        </c:if>
                        <li>
                            <a href="${pageContext.request.contextPath}/jsp/account.jsp">Account</a>
                        </li>
                        <li>
                            <a onclick="document.getElementById('logout_form').submit(); return false;"
                               href="#" class="btn-danger">Exit</a>
                        </li>
                    </ul>

                 </div>
            </div>
        </nav>

        <form id="logout_form" action="${pageContext.request.contextPath}/controller" method="POST">
            <input type="hidden" name="command" value="logout"/>
        </form>
        <form id="users_form" action="${pageContext.request.contextPath}/controller" method="POST">
            <input type="hidden" name="command" value="users"/>
        </form>
        <br>
    </body>
</html>