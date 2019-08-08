package kr.ac.skuniv.fw;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.todo")
public class todoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getRequestURI().substring(req.getContextPath().length());
		
		try {
			
			ActionFactory factory = ActionFactory.getInstance();
			Action action = factory.getAction(path);
			
			action.execute(req, resp);
		}catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}
