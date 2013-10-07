package touch;

import java.util.Properties;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.Context;

public class TouchServer {

	public static void main(String[] args) throws Exception {
		Properties prop = new Properties();
		prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
		Object c_port = prop.get("port");
		int port = c_port == null ? 5230 : Integer.valueOf(c_port.toString());
		Server server = new Server(port);
		Context context = new Context(); 
		server.addHandler(context);;
		context.addServlet(TouchServlet.class, "/");
		context.addServlet(CloseServlet.class, "/close");
		server.start();
	}

}


