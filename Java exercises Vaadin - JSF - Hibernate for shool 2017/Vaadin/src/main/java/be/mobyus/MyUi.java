package be.mobyus;


import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.Position;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;

import javax.servlet.annotation.WebServlet;

/**
 * Created by java on 09.11.16.
 */
//@Theme("reindeer")
@Theme("valo")
public class MyUi extends  UI {
    @Override
    protected void init (VaadinRequest request){
        /*
        Button button = new Button("Click me please");
        button.addClickListener(clickEvent -> {
            Notification.show("My notification", Type.ERROR_MESSAGE);
        });
        setContent(button);
        */


        //Ex1 ex1 = new Ex1();
        Ex2 ex2 = new Ex2();

        setContent(ex2);

    }

    @WebServlet(value ="/*", asyncSupported = true)
    @VaadinServletConfiguration (productionMode = false, ui = MyUi.class)
    public static class Servlet extends VaadinServlet{

    }
}
