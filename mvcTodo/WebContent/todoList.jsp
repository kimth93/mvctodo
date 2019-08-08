<%@page import="kr.ac.skuniv.todo.service.TodoService"%>
<%@page import="kr.ac.skuniv.todo.dto.Todo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%List<Todo> todoList = (List<Todo>)request.getAttribute("todoList"); %>
<%
	TodoService service = new TodoService();
	Todo todo1 = (Todo)request.getAttribute("todoInfo");
%>

<center>
<h1>할일 추가하기</h1>
<form action="todoAdd" method="post">
	할일 : <input name="todo" type="text"/>
	<input type="submit" value="추가"/>
</form>

<h1>할일목록</h1>

<table>
	<tr>
		<th>할일</th>
		<th>수행여부</th>


	</tr>
	<%if(todoList != null){
		for(Todo todo:todoList){
	%>
		<tr>
			<td><%=todo.getTodo() %></td>
			<td><%if(todo.isDone() == true){%>완료<%}else{ %>진행중<%}%></td>
			<td><a href="todoUpdate?id=<%=todo.getId() %>">갱신</a></td>
			<td><a href="todoDelete?id=<%=todo.getId() %>">삭제</a></td>
			
		</tr>
	<% }//for end
	}//if end%>
</table>
</center>
	

</body>
</html>