package servlets;

import models.MySQLConnector;
import models.PRIVILAGE_TYPE;
import models.USER_TYPE;
import models.UserBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet("/userPage")
public class UserPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserBean userBean = (UserBean)req.getSession().getAttribute("userBean");


        if (userBean.getUserType()== USER_TYPE.student) {
            if(req.getParameter("studentSubmit")!=null){
                LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("allCoursesForStudentID", ((UserBean) req.getSession().getAttribute("userBean")).getId());
                req.setAttribute("data", data);
                req.getRequestDispatcher("JSP/userPage.jsp").forward(req, resp);
            }else {
                LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("allCoursesForStudentID", ((UserBean) req.getSession().getAttribute("userBean")).getId());
                req.setAttribute("data", data);
                req.getRequestDispatcher("JSP/userPage.jsp").forward(req, resp);
            }
        }else if (userBean.getUserType()== USER_TYPE.teacher && userBean.getprivilageType()== PRIVILAGE_TYPE.user) {
            //TODO do stuff for this person
        }else if (userBean.getUserType()== USER_TYPE.teacher && userBean.getprivilageType()== PRIVILAGE_TYPE.admin) {
            //TODO do stuff for this person
        }else{
            //TODO send Person to login servlet
        }
    }
}
