<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
  <title>ログイン</title>
</head>
<body>
  <h1>ログイン</h1>
  <form:form action="login" modelAttribute="loginForm">
    <form:errors path="*" />
    <br><br>
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
      <input type="submit" value="ログイン" />
    </p>
  </form:form>
</body>
</html>
