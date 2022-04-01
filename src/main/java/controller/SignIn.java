package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import model.User;

@WebServlet(urlPatterns = "/sign-in")
public class SignIn extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		User user = new User();
		user.setEmail("admin@email.com");
		request.setAttribute("userModel", user);
		RequestDispatcher rd = request.getRequestDispatcher("/views/signin.jsp");
		rd.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println(email);
		System.out.println(password);
		
		Dao dao = new Dao();
		boolean check = dao.checkUser(email, password);
		PrintWriter printWriter = response.getWriter();
		if (check) {
			printWriter.print("<html>");
	        printWriter.print("<body>");
	        printWriter.print("<h1>WELCOME TO MY WEBSITE!!</h1>");
	        printWriter.print("</body>");
	        printWriter.print("</html>");
		}
		else {
			printWriter.print("<html>");
	        printWriter.print("<body>");
	        printWriter.print("<h1>WRONG ANSWER OR PASSWORD!!</h1>");
	        printWriter.print("</body>");
	        printWriter.print("</html>");
		}
		printWriter.close();
	}
}
