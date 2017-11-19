<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page trimDirectiveWhitespaces="true" %>

<html>
    <head>
        <title>Enter</title>
        <link href="/css/style.css" type="text/css" rel="stylesheet">
        <link href="/css/bootstrap.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <c:if test="${sessionScope.role != null}">
            <jsp:forward page="${pageContext.request.contextPath}/controller">
                <jsp:param name="command" value="show_student_list"/>
            </jsp:forward>
        </c:if>

        <c:if test="${sessionScope.role == null}">
            <div class="container">
                <div class="jumbotron">
                    <div class="page-header">
                        <h1>Log in</h1>
                    </div>

                    <form name="LoginForm" action="${pageContext.request.contextPath}/controller" method="POST">
                        <input type="hidden" name="command" value="login">
                        <div class="row">
                            <div class="col-lg-4">
                                <div class="form-group">
                                    <label for="username">Login:</label>
                                    <input id="username" class="username form-control" type="text" placeholder="Login"
                                           required name="username"/>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-4">
                                <div class="form-group">
                                    <label for="password">Password:</label>
                                    <input id="password" type="password" class="password form-control"
                                           placeholder="Password" required name="password"/>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-4">
                                <input type="submit" name="login" value="Enter" class="btn btn-success"/>
                            </div>
                        </div>
                        <div id="errorMessage">
                            <c:if test="${errorLogin == true}">Such login doesn't exist in database!</c:if>
                            <c:if test="${errorPassword == true}">You are enter incorrect password!</c:if>
                        </div>
                    </form>
                    <div>
                        <p id="reg">
                            <a href="${pageContext.request.contextPath}/jsp/register.jsp" class="btn btn-success">Registration</a>
                        </p>
                    </div>
                </div>
            </div>
        </c:if>
    </body>
</html>
