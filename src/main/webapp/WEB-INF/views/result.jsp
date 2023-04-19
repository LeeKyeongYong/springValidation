<%--
  Created by IntelliJ IDEA.
  User: sleek
  Date: 2022-09-22
  Time: 오후 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
  <title>폼 검증 결과</title>
  <link rel="stylesheet" type="text/css" href="resources/css/style.css" />
</head>
<body>
<div id="content">
  <h3>가입 결과</h3>
  ${user.name}님이 가입되었습니다. <br /><br />
  <a href="new">회원 가입 화면으로...</a>
</div>

</body>
</html>
