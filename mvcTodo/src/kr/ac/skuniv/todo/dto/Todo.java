package kr.ac.skuniv.todo.dto;

public class Todo {
	private Integer id;
	private String todo;
	private boolean done;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTodo() {
		return todo;
	}
	public void setTodo(String todo) {
		this.todo = todo;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	@Override
	public String toString() {
		return "TodoList [id=" + id + ", todo=" + todo + ", done=" + done + "]";
	}
	

}
