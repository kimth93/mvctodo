package kr.ac.skuniv.fw;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class ActionFactory {
	
	private static ActionFactory instance;
	private Properties prop;
	private HashMap<String, Action> actionMap;
	
	private ActionFactory() {
		InputStream in = null;
		try {
			in = getClass().getClassLoader().getResourceAsStream("mvc.properties");
			prop = new Properties();
			prop.load(in);
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	public static ActionFactory getInstance() {			//내부에서 리턴
		if(instance == null) {
			instance = new ActionFactory();
			
		}
		return instance;
	}
	
	public Action getAction(String path) {
		String className = prop.getProperty(path);
		Action action = null;
		try {
			Class c=  Class.forName(className);	//클래스이름을 메모리에 올려줌
			Object obj = c.newInstance();
			if(obj instanceof Action) {
				action = (Action)obj;
				actionMap.put(path, action);
			}else {
				throw new ClassCastException();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return action;
		
	}
	
	

}
