<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <body>
        <h1>Features</h1>
        <div>
            <c:if test="${login_enabled}">
                <h3>Login</h3>
                <div>User logged in as ${login}</div>
                <form action="/app/login" method="post">
                    <label>
                        Login:
                        <input name="login" type="text">
                    </label>
                    <br/>
                    <label>
                        Password:
                        <input name="password" type="password">
                    </label>
                    <br/>
                    <button type="submit">Login</button>
                </form>
            </c:if>
            <c:if test="${random_enabled}">
                <h3>Random number</h3>
                <div>The number is: ${random}</div>
            </c:if>
            <c:if test="${disabled_enabled}">
                <div>never happened</div>
            </c:if>
        </div>
        <div>
            <h3>Management</h3>
            <a href="/togglz/" target="_blank">Feature toggles</a>
        </div>
    </body>
</html>