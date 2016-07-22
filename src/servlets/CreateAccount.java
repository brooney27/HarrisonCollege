package servlets;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Hcstudent;
import model.Hcuser;
import tools.DBFunctions;
import tools.PasswordUtil;

/**
 * Servlet implementation class CreateAccount
 */
@WebServlet("/CreateAccount")
public class CreateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String major = request.getParameter("major");
		String email = request.getParameter("email");
		String entryyear = request.getParameter("entryyear");
		String password = request.getParameter("password");
		String salt = PasswordUtil.getSalt();
		
		Hcuser user = new Hcuser();
		user.setEmail(email);
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setSalt(salt);
		user.setUsertype(new BigDecimal(0));
		try{
			user.setHashedpass(PasswordUtil.hashPassword(password, salt));
		}catch(Exception e){}
		
		DBFunctions.insert(user);
		System.out.println("insert user done");
		user = DBFunctions.getUserByEmail(email);
		System.out.println("User found: "+(user!=null));
		
		Hcstudent student = new Hcstudent();
		student.setEntryyear(new BigDecimal(entryyear));
		student.setHcuser(user);
		student.setMajor(major);
		student.setHcuser(user);
		user.setHcstudent(student);
		
		DBFunctions.insert(student);
		DBFunctions.update(user);
		
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
		request.getRequestDispatcher("/Home").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
