package kr.ac.skuniv.todo.service;

import java.util.List;

import kr.ac.skuniv.todo.dao.TodoDAO;
import kr.ac.skuniv.todo.dto.Todo;



public class TodoService {
	TodoDAO dao = new TodoDAO();
	
	public boolean todoAdd(Todo todo) {
		//Todo 데이터를 얻어와서 회원가입 하기 위해
		//필요한 로직이 존재한다면 여기에서 수행함
		
		
		//DB에 저장할 정보가 있다면 저장
		boolean resultFlag = dao.addTodo(todo);
		
		
		return resultFlag;
	}
	
	public List<Todo> getTodoList() {
		
		return dao.getTodoList();
	}
	
	public void deleteTodo(Integer id) {
		
		dao.deleteTodo(id);
		
	}
	
	public Todo getTodo(Integer id) {
		return dao.getTodo(id);
	}
	
	public void upDateTodo(int id) {
		
		dao.upTodo(id);
	}
	
	
}
