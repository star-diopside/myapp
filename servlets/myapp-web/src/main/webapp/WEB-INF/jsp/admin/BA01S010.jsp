<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="myapp" uri="/myapp-tags" %>
<!DOCTYPE html>
<html>
<head>
  <jsp:include page="/WEB-INF/jsp/head.jsp" />
  <myapp:timeout />
  <title>管理者メニュー</title>
</head>
<body>
  <s:include value="../header.jsp" />
  <s:fielderror />
  <s:actionerror />
  <s:form>
    管理者メニュー
  </s:form>
  <s:include value="../footer.jsp" />
</body>
</html>
