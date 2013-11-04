<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="<c:url value='/www/css/stylesheet.css' />" />
  <title>ログイン</title>
</head>
<body>
  <h1>ログイン</h1>
  <c:url var="loginUrl" value="/auth/login" />
  <form:form action="${loginUrl}" modelAttribute="loginForm">
    <form:errors path="*" element="div" cssClass="message-area error" />
    <c:if test="${not empty loginForm.messages}">
      <div class="message-area information">
        <ul>
          <c:forEach items="${loginForm.messages}" var="message">
            <li><c:out value="${message}" /></li>
          </c:forEach>
        </ul>
      </div>
    </c:if>
    <div class="table-none">
      <table>
        <tr>
          <td class="right">ユーザID</td>
          <td><form:input path="username" /></td>
        </tr>
        <tr>
          <td class="right">パスワード</td>
          <td><form:password path="password" /></td>
        </tr>
      </table>
    </div>
    <p>
      <input type="submit" name="login" value="ログイン" />
      <input type="submit" name="register" value="テストユーザ登録" />
    </p>
  </form:form>
</body>
</html>
