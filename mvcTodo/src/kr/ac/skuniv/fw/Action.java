package kr.ac.skuniv.fw;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract public class Action {
	public abstract void execute(HttpServletRequest req, HttpServletResponse resp)throws Exception;
}
