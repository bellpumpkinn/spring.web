<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8'%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<img src='<c:url value="/attach/${user.faceFilename}"/>'/><br>
${user.userName} / ${user.age}





<!-- 
url이  file로 시작되면 server machine의 파일을 요청하는거다.
 -->