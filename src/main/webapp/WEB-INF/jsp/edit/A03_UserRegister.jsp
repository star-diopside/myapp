<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="Windows-31J" %>
<%@ page language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title><s:text name="A03.Title" /></title>
  <link rel="stylesheet" type="text/css" href="<c:url value='/www/css/stylesheet.css' />">
</head>
<body>
<s:fielderror />
<s:actionerror />
<s:form method="post">
<div class="table-none">
  <table>
    <tr>
      <td class="right"><s:text name="A03.UserId" /></td>
      <td><s:textfield key="a03Form.userId" /></td>
    </tr>
    <tr>
      <td class="right"><s:text name="A03.UserName" /></td>
      <td><s:textfield key="a03Form.userName" /></td>
    </tr>
    <tr>
      <td class="right"><s:text name="A03.Password" /></td>
      <td><s:password key="a03Form.password" /></td>
    </tr>
    <tr>
      <td class="right"><s:text name="A03.Captcha" /></td>
      <td>
        <span><s:text name="A03.CaptchaDescription" /></span>
        <div><img src="captcha.jpg" /></div>
        <s:password key="a03Form.captcha" />
      </td>
    </tr>
  </table>
</div>
<p>
  <s:submit key="A03.Register" action="A03RegisterAction" />
  <s:submit key="A03.Back" action="A03BackAction" />
</p>
</s:form>
</body>
</html>
