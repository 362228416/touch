package touch;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TouchServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String action = req.getParameter("action");
		String x = req.getParameter("x");
		String y = req.getParameter("y");
		if (action != null) {
			x = x == null ? "0" : x;
			y = y == null ? "0" : y;
			WindowsProcessor.process(new WindowsMessage(action, Float.valueOf(x), Float.valueOf(y)));
			out.write("execute success!");
		} else {
			out.write("not found!");
		}
	}
	
}
