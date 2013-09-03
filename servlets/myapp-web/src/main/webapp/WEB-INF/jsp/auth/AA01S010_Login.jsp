<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="myapp" uri="/myapp-tags" %>
<!DOCTYPE html>
<html>
<head>
  <jsp:include page="/WEB-INF/jsp/head.jsp" />
  <myapp:timeout />
  <title><s:text name="A01.Title" /></title>
</head>
<body>
  <s:fielderror />
  <s:actionerror />
  <s:debug />
  <s:form action="AA01S010LoginAction" method="post">
    <div class="table-none">
      <table>
        <tr>
          <td class="right"><s:text name="A01.UserId" /></td>
          <td><s:textfield key="userId" /></td>
        </tr>
        <tr>
          <td class="right"><s:text name="A01.Password" /></td>
          <td><s:password key="password" /></td>
        </tr>
      </table>
    </div>
    <p>
      <s:submit key="A01.Login" />
    </p>
    <p>
      <s:a action="AA02S010Action"><s:text name="A01.Register" /></s:a>
    </p>
  </s:form>
</body>
</html>
