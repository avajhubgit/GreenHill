<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
        <c:if test="${not empty login}"><p> Current user: ${login}</c:if>
        <p>Current time: <%= new java.util.Date()%>
    </body>
</html>