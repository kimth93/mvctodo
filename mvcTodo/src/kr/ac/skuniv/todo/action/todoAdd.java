package kr.ac.skuniv.todo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.skuniv.fw.Action;
import kr.ac.skuniv.todo.dao.TodoDAO;
import kr.ac.skuniv.todo.dto.Todo;
import kr.ac.skuniv.todo.service.TodoService;

public class todoAdd extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		TodoDAO dao = new TodoDAO();
		
		req.setCharacterEncoding("utf-8");
		TodoService service = new TodoService();
		
		Todo todo = new Todo();
		req.setAttribute("todoInfo", todo);
		todo.setTodo(req.getParameter("todo"));
		
		boolean resultFlag = dao.addTodo(todo);
		resp.sendRedirect("todoList");
		
	}
	

}
