package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Hcuser;
import tools.DBFunctions;
import tools.PasswordUtil;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public Login() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String nextURL = "/login.jsp";       
		HttpSession session = request.getSession();          
		Hcuser user = DBFunctions.getUserByEmail(email);
		try{
			if(PasswordUtil.validateUser(user.getSalt(), password, user.getHashedpass())){
				session.setAttribute("user", user);
				nextURL = "/Home";
			}
			else user = null;
		}catch (Exception e){
			user = null;
		}
		
		request.getRequestDispatcher(nextURL).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
