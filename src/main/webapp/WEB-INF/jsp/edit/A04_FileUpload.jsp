<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="Windows-31J" %>
<%@ page language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
  <jsp:include page="/WEB-INF/jsp/head.jsp" />
  <title>�t�@�C���A�b�v���[�h</title>
</head>
<body>
<s:fielderror />
<s:actionerror />
<s:form method="post" enctype="multipart/form-data">
  <s:file name="uploadFile" /><br>
  <br>
  <s:property value="uploadFile" /><br>
  <s:property value="uploadFileContentType" /><br>
  <s:property value="uploadFileFileName" /><br>
  <p>
    <s:submit action="A04OpenAction" />
  </p>
</s:form>
</body>
</html>
