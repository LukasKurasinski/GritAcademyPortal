<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<%@ include file="fragments/head.jsp" %>
<body>
<%@ include file="fragments/navbar.jsp" %>


<c:if test="${userBean.userType == 'student'}">
    <%@ include file="fragments/studentUserPage.jsp" %>
</c:if>


<%@ include file="fragments/footer.jsp" %>

</body>
</html>