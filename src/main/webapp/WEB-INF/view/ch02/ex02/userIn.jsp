<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8'%>
<form action='userOut' method='post'> <!-- 핸들러의 request타입: post -->
	<label>이름: <input type='text' name='userName'/></label>
	<label>나이: <input type='number' name='age'/></label>
	<label>등록일: <input type='date' name='regDate'/></label>
	<input type='submit'/>
</form>



<!-- 
	action으로 지정된 url은 디스패처가 먼저받음.
	
	서블릿에다가 기술하는 url은 핸들러의 url
 -->