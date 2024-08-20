

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlet
 */


@WebServlet("/servlet")

public class servlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public servlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		  String username = request.getParameter("username");
	        String password = request.getParameter("password");

	        // Simple validation (replace with real validation logic)
	        if ("admin".equals(username) && "password".equals(password)) {
	            response.sendRedirect("welcome.html");
	        } else {
	            response.setContentType("text/html");
	            response.getWriter().println("<html><body>");
	            response.getWriter().println("<h3>Invalid credentials. Please try again.</h3>");
	            response.getWriter().println("<a href='login.html'>Go back to login</a>");
	            //response.sendRedirect("login.html");
	            response.getWriter().println("</body></html>");
	        }
	}

}
