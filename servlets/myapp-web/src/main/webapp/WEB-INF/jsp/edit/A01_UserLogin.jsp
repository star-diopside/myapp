<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
  <jsp:include page="/WEB-INF/jsp/head.jsp" />
  <title><s:text name="A01.Title" /></title>
</head>
<body>
<p><s:a namespace="admin" action="BA01S010">管理者メニュー</s:a></p>
<s:fielderror />
<s:actionerror />
<s:debug />
<s:form action="A01LocaleAction" method="post">
  <s:select name="localeForm.language" list="localeForm.languageList" listKey="key" listValue="value" />
  <s:submit />
</s:form>
<s:form method="post">
<div class="table-none">
  <table>
    <tr>
      <td class="right"><s:text name="A01.UserId" /></td>
      <td><s:textfield key="a01Form.userId" /></td>
    </tr>
    <tr>
      <td class="right"><s:text name="A01.Password" /></td>
      <td><s:password key="a01Form.password" /></td>
    </tr>
  </table>
</div>
<p>
  <s:submit key="A01.Login" action="A01LoginAction" />
</p>
<p>
  <s:a action="A01RegisterAction"><s:text name="A01.Register" /></s:a><br>
  <s:a action="A04OpenAction">FileUpload</s:a>
</p>
</s:form>
</body>
</html>
