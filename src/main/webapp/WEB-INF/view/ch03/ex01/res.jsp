<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8'%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<script src='<c:url value="/res/alert.js"/>'/></script>
<link rel='stylesheet' href='<c:url value="/res/box.css"/>'/>

<img src='<c:url value="/res/duke.gif"/>'/>

<div></div>
<!-- 
res없으면 핸들러에보냄 근데 에러가 난다.
하지만 /res붙이면 우리가 등록했던 리소스 핸들러한테 간다.

 -->