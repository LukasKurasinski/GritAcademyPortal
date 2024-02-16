package servlets;

import models.MySQLConnector;
import models.STATE_TYPE;
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
        if(userType.equals("student")){
            List data = MySQLConnector.getConnector().selectQuery("studentLogin",username,password);

            if(!data.isEmpty()){
                resp.getWriter().print("LOGGED IN");
                UserBean userBean = new UserBean();
                userBean.setStateType(STATE_TYPE.confirmed);
                req.getSession().setAttribute("userBean",userBean);
                resp.getWriter().print(req.getSession().getAttribute("userBean"));
            }
        } else if (userType.equals("teacher")) {
            List data = MySQLConnector.getConnector().selectQuery("teacherLogin",username,password);
            if(!data.isEmpty()) resp.getWriter().print("LOGGED IN");
            //TODO similar to the student code
        }

        //resp.getWriter().print(username+" "+password+" "+userType);
    }
}
