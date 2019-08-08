package kr.ac.skuniv.todo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.skuniv.common.DButil;
import kr.ac.skuniv.todo.dto.Todo;

public class TodoDAO {
	
	public boolean addTodo(Todo todo) {
		boolean resultFlag = false;
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DButil.getConnection();
			String sql = "insert into todo(todo) values(?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, todo.getTodo());
			
			int resultCount = ps.executeUpdate();
			
			if(resultCount == 1)
				resultFlag = true;
			
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			DButil.close(conn, ps);
		}
		
		return resultFlag;
		
		
	}
	
	public int upTodo(int id) {
		int resultCount = 0;
		
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DButil.getConnection();
			String sql = "update todo set done = true where id = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

				
			resultCount = ps.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			DButil.close(conn, ps);
		}
		
		return resultCount;
	}
	
	
	public int deleteTodo(Integer id) {
		int resultCount=0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DButil.getConnection();
			String sql = "delete from todo where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			
			ps.executeUpdate();
			resultCount = ps.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			DButil.close(conn, ps);
		}
		return resultCount;
	}
	
	
	public Todo getTodo (Integer id) {
		Todo todo = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DButil.getConnection();
			String sql = "select id,todo,done from todo where id =? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				todo = new Todo();
				todo.setId(rs.getInt(1));
				todo.setTodo(rs.getString(2));
				todo.setDone(rs.getBoolean(3));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DButil.close(conn,ps,rs);
		}
		
		return todo;
		
	}
	
	
	public List<Todo> getTodoList() {
		List<Todo> TodoList = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DButil.getConnection();
			String sql = "select id,todo,done from todo";
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			
			while(rs.next()) {
				Todo todo = new Todo();
				todo.setId(rs.getInt(1));
				todo.setTodo(rs.getString(2));
				todo.setDone(rs.getBoolean(3));
				
				TodoList.add(todo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DButil.close(conn,ps,rs);
		}
		
		return TodoList;
	}
	


}
