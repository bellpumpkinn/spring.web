<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8'%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<script src='<c:url value="/res/alert.js"/>'/></script>
<link rel='stylesheet' href='<c:url value="/res/box.css"/>'/>

<img src='<c:url value="/res/duke.gif"/>'/>

<div></div>
<!-- 
res없으면 핸들러에보냄 근데 에러가 난다.
하지만 /res붙이면 우리가 등록했던 리소스 핸들러한테 간다.

절대주소 상대주소 판단하는기준
=> 컨텍스트패스가 포함되면 절대주소, 안포함되어있으면 상대주소.

리소스핸들러에 적어준 url을 기억해서 
view 에다가 잘 적어주면 된다.
 -->