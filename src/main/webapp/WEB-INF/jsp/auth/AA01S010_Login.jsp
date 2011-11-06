<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="Windows-31J" %>
<%@ page language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title><s:text name="A01.Title" /></title>
  <link rel="stylesheet" type="text/css" href="<c:url value='/www/css/stylesheet.css' />">
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
          <td><s:textfield key="j_username" value="%{AA01S010Form.userId}" /></td>
        </tr>
        <tr>
          <td class="right"><s:text name="A01.Password" /></td>
          <td><s:password key="j_password" /></td>
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
