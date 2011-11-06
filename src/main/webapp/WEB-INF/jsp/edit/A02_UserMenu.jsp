<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="Windows-31J" %>
<%@ page language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title><s:text name="A02.Title" /></title>
  <link rel="stylesheet" type="text/css" href="<c:url value='/www/lib/css/jquery-ui-1.8.16.custom.css' />">
  <link rel="stylesheet" type="text/css" href="<c:url value='/www/css/stylesheet.css' />">
  <script type="text/javascript" src="<c:url value='/www/lib/js/jquery-1.6.2.min.js' />"></script>
  <script type="text/javascript" src="<c:url value='/www/lib/js/jquery-ui-1.8.16.custom.min.js' />"></script>
  <script type="text/javascript">
    $(function() {
      $("#tab-container").tabs();
    });
  </script>
</head>
<body>
<s:fielderror />
<s:actionerror />
<s:form>
  <div id="tab-container">
    <ul>
      <li><a href="#tab-content-1">tab1</a>
      <li><a href="#tab-content-2">tab2</a>
      <li><a href="#tab-content-3"><c:out value="abc<;;" /></a>
    </ul>
    <div id="tab-content-1">
      <s:text name="A02.Message" /><br>
      Login User : <s:property value="a02Form.userId" />
      <table>
        <thead>
          <tr>
            <th>userId</th>
            <th>username</th>
          </tr>
        </thead>
        <tbody>
          <s:iterator value="a02Form.userInfoList" status="st">
            <tr>
              <td><s:textfield name="a02Form.userInfoList[%{#st.index}].userId" value="%{userId}" /></td>
              <td><s:textfield name="a02Form.userInfoList[%{#st.index}].username" value="%{username}" /></td>
            </tr>
          </s:iterator>
        </tbody>
      </table>
    </div>
    <div id="tab-content-2">
      tab2
    </div>
    <div id="tab-content-3">
      tab3
    </div>
  </div>
  <s:submit action="A02RedrawAction" value="Ä•\Ž¦" />
</s:form>
</body>
</html>
