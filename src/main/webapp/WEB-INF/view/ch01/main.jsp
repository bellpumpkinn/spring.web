<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8'%>
MAIN


<!-- 
1. Client ▶ request (url:"/") ▶ 
2. (Server)Dispatcher Servlet ("ch01/main"으로 파악) ▶ 
	request 해석의뢰 ▶ 
3. View Resolver ▶ response (prefix, suffix 붙여서) ▶ 
4. Dispatcher ▶ viewName을 파악 후, request ▶ 
5. ch01/main.jsp이름을 갖는 Servlet(View) ▶ response ▶ 
6. Dispatcher Servlet ▶ response ▶ View - (WEB-INF/view/ch01/main.jsp) 
	▶ Client
 -->