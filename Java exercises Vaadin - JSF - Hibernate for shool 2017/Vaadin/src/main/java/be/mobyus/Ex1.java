package be.mobyus;

import com.vaadin.ui.*;

import javax.faces.component.html.HtmlOutputText;

/**
 * Created by java on 09.11.16.
 */
public class Ex1 extends VerticalLayout {
    Button button = new Button("Click me please");
    Label label = new Label("Hello World");

    public Ex1 () {

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.addComponent(button);
        horizontalLayout.addComponent(label);
        addComponent(horizontalLayout);

        label.setVisible(false);

        button.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event){
                if (label.isVisible()){
                    label.setVisible(false);
                }
                else
                {
                    label.setVisible(true);
                }
            }
        });

        }

    }
