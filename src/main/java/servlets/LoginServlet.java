package servlets;

import models.MySQLConnector;
import models.STATE_TYPE;
import models.USER_TYPE;
import models.UserBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println();
        req.getSession().setAttribute("errorMessage","");
        req.getRequestDispatcher("JSP/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        //retrieving data from loginForm
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String userType = req.getParameter("user_type");


        //comparing data with DB student or teacher
        if (userType.equals("student")) {
            List data = MySQLConnector.getConnector().selectQuery("studentLogin", username, password);
            //data object always returns row with column names
            if (data.size() > 1) {
                req.getSession().setMaxInactiveInterval(360);
                resp.getWriter().print("LOGGED IN - ");

                UserBean userBean = new UserBean();
                userBean.setStateType(STATE_TYPE.confirmed);
                userBean.setUserType(USER_TYPE.student);
                req.getSession().setAttribute("userBean", userBean);
                req.getRequestDispatcher("/userPage").forward(req,resp);
            }else{
                req.getSession().setAttribute("errorMessage","Student not found");
                req.getRequestDispatcher("JSP/login.jsp").forward(req, resp);
            }
        }else if (userType.equals("teacher")) {
                List data = MySQLConnector.getConnector().selectQuery("teacherLogin", username, password);
            //data object always returns row with column names
                if (data.size() > 1) {
                    resp.getWriter().print("LOGGED IN - ");
                    //TODO similar to the student code
                }else{
                    req.getRequestDispatcher("JSP/login.jsp").forward(req,resp);
                }
        }
    }
}
