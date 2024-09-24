<%@ page import="java.util.ArrayList"%>

<c:forEach items="${musics}" var="music">
    <p><c:out value="${music.name}"/></p>
    <p><c:out value="${music.duration}"/></p>
</c:forEach>

<html>
<body>
<h2>Hello World!</h2>
</body>
</html>
