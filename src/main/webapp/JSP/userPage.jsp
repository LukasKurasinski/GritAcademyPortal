<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<%@ include file="fragments/head.jsp" %>
<body>
<%@ include file="fragments/navbar.jsp" %>

<c:choose>
 <c:when test="${userBean.userType == 'student'}">
    <%@ include file="fragments/student/studentUserPage.jsp" %>
 </c:when>
 <c:when test="${userBean.userType == 'teacher' && userBean.privilagetype == 'user'}">
    <%@ include file="fragments/teacher/teacherUserPage.jsp" %>
 </c:when>
 <c:when test="${userBean.userType == 'teacher' && userBean.privilagetype == 'admin'}">
    <%@ include file="fragments/teacher/teacherAdminUserPage.jsp" %>
 </c:when>
 <c:when test="${userBean.userType == 'teacher' && userBean.privilagetype == 'superadmin'}">
    <%@ include file="fragments/teacher/teacherSuperadminUserPage.jsp" %>
 </c:when>
</c:choose>

<%@ include file="fragments/footer.jsp" %>
</body>
</html>