package pack;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionListener;
public class L2 implements HttpSessionAttributeListener {
    public void attributeAdded(HttpSessionBindingEvent e) {
        System.out.println("L2:attributeAdded:AtributeName= "
                +e.getName());
    }
    public void attributeRemoved(HttpSessionBindingEvent e) {
        System.out.println("L2:attributeRemoved:AtributeName= "
                +e.getName());
    }
    public void attributeReplaced(HttpSessionBindingEvent e) {
        System.out.println("L2:attributeReplaced:AtributeName="
                +e.getName());
    }
} 