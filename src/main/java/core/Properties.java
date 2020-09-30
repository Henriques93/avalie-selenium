package core;

public class Properties {
	
	public static String CONF_DIR = "C:\\home\\avalie\\repos\\Avalie\\conf\\grid\\";
	
	public static String BASE_URL = "http://127.0.0.1:8000";
	
	public static String COORDENADOR_EMAIL = "henriques@gmail.com";
	public static String COORDENADOR_PASSWORD = "123321";
	public static String PROFESSOR_EMAIL = "henriques@gmail.com";
	public static String PROFESSOR_PASSWORD = "123321";
	public static String GRID_URL = "http://localhost:4444/wd/hub";
			
	public static int WAIT_TIME = 10;
	public static boolean CLOSE_BROWSER = false;
	
//public static Browsers BROWSER = Browsers.FIREFOX;
	public static Browsers BROWSER = Browsers.FIREFOX;
	public static ExecutionTypes EXECUTION_TYPE = ExecutionTypes.LOCAL;
	public static Platforms PLATFORM = Platforms.WINDOWS;
	
	static {
		String _baseUrl = System.getProperty("baseUrl");
		if (_baseUrl != null && !_baseUrl.isEmpty()) {
			BASE_URL = _baseUrl;
		}
		String _userName = System.getProperty("userName");
		if (_userName != null && !_userName.isEmpty()) {
			COORDENADOR_EMAIL = _userName;
		}
		String _userPassword = System.getProperty("userPassword");
		if (_userPassword != null && !_userPassword.isEmpty()) {
			COORDENADOR_PASSWORD = _userPassword;
		}
	}
	
	public enum Browsers {
		CHROME,
		FIREFOX
	}
	
	public enum ExecutionTypes {
		LOCAL,
		GRID
	}

	public enum Platforms {
		WINDOWS,
		MAC,
		LINUX
	}

}
