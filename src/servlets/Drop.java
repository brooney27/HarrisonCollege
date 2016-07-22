package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Hcsection;
import model.Hcstudent;
import model.Hcuser;
import tools.DBFunctions;

/**
 * Servlet implementation class Drop
 */
@WebServlet("/Drop")
public class Drop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Drop() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Hcuser user = (Hcuser)session.getAttribute("user");
		String crn = request.getParameter("crn");
		
		Hcsection section = DBFunctions.getSectionById(crn);
		Hcstudent student = user.getHcstudent();
		List<Hcstudent> roster = section.getHcstudents();
		
		for(Hcstudent s:roster){
			if(s.getStudentid()==student.getStudentid()){
				roster.remove(s);
				break;
			}
		}
		
		List<Hcsection> schedule = student.getHcsections();
		for(Hcsection s : schedule){
			if(s.getCrn()==section.getCrn())schedule.remove(s);
			break;
		}
		
		section.setHcstudents(roster);
		DBFunctions.update(section);
		student.setHcsections(schedule);
		DBFunctions.update(student);
		
		user = DBFunctions.getUserByEmail(user.getEmail());
		session.setAttribute("user", user);
		
		request.getRequestDispatcher("/Home").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
