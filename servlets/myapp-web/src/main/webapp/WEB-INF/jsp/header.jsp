<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<p><a href="<s:url value='/j_spring_security_logout' />">ログアウト</a></p>
<p>
ユーザID：<security:authentication property="principal.userId"/>
&nbsp;&nbsp;
ユーザ名：<security:authentication property="principal.displayName"/>
</p>
<hr>
