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
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserBean userBean = req.getSession().getAttribute("userBean") != null ? (UserBean)req.getSession().getAttribute("userBean") : null;

        if (userBean != null && userBean.getUserType() == USER_TYPE.student) {
            LinkedList<String[]> data = null;
            LinkedList<String[]> courses = MySQLConnector.getConnector().selectQuery("allCoursesForStudentID", ((UserBean) req.getSession().getAttribute("userBean")).getId());

            if(req.getParameter("studentSubmitButton")!=null){
                data = MySQLConnector.getConnector().selectQuery("allPeopleInCourse",  req.getParameter("courseId"));

            }else {
                data = courses;
            }
            req.setAttribute("data", data);
            req.setAttribute("courses", courses);
            req.getRequestDispatcher("JSP/userPage.jsp").forward(req, resp);

        }else if (userBean != null && userBean.getUserType()== USER_TYPE.teacher && userBean.getprivilageType()== PRIVILAGE_TYPE.user) {
            //TODO do stuff for this person
        }else if (userBean != null && userBean.getUserType()== USER_TYPE.teacher && userBean.getprivilageType()== PRIVILAGE_TYPE.admin) {
            //TODO do stuff for this person
        }else{
            req.getRequestDispatcher("JSP/login.jsp").forward(req, resp);
        }
    }
}
