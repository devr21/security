<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<h2>${message}</h2>
<c:if test="${user !='anonymousUser'}">
<h3>Hello ${user}</h3>
<br>
<form action="/secure-mvc/perform_logout">
	<input type="submit" name="logout" value="logout">
</form>

</c:if>

</body>
</html>
