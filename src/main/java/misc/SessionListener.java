package misc;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Enumeration;

@WebListener
public class SessionListener implements HttpSessionListener  {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("SESSION CREATED");
        Enumeration<String> attributeNames = se.getSession().getAttributeNames();
        System.out.println("SESSION ID: " + se.getSession().getId());
        System.out.println("SESSION INIT ATTRIBUTES: ");
        while(attributeNames.hasMoreElements()) {
            System.out.println(se.getSession().getAttribute(attributeNames.nextElement()));
        }
    }

    public void sessionDestroyed(final HttpSessionEvent event) {

        System.out.println("SESSION "+ event.getSession().getId() +" DESTROYED");
        HttpSessionListener.super.sessionDestroyed(event);
    }
}
