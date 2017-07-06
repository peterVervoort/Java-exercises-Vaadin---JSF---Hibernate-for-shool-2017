package be.mobyus;

import com.vaadin.data.util.converter.Converter;
import com.vaadin.ui.*;

/**
 * Created by java on 09.11.16.
 */
public class Ex2 extends VerticalLayout {
    Button button = new Button("Click me please");
    TextField textField = new TextField();
    Label label = new Label("");

    public Ex2 (){

        HorizontalLayout horizontalLayout = new HorizontalLayout();

        horizontalLayout.addComponent(button);
        horizontalLayout.addComponent(textField);
        horizontalLayout.addComponent(label);
        addComponent(horizontalLayout);

        label.setVisible(false);



        button.addClickListener(new Button.ClickListener() {
                public void buttonClick(Button.ClickEvent event) {
                    if (!textField.isEmpty()) {
                        try{
                            Integer convertedValue = (Integer) textField.getConvertedValue();
                            label.setValue(convertedValue.toString());
                            label.setVisible(true);
                        }
                        catch (Converter.ConversionException e){

                        }
                        label.setValue(textField.getValue());
                        if (label.isVisible()) {
                            label.setVisible(false);
                        } else {
                            label.setVisible(true);
                        }
                    }
                }
            });
/*
        button.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event){
                if (!textField.getValue().isEmpty()){
                    try{
                        Integer convertedValue = (Integer) textField.getConvertedValue();
                        label.setValue(textField.getValue());
                        label.setVisible(true);
                    }
                    catch (Converter.ConversionException e){
                        Notification.show("Could not convert value: " + textField.getValue());
                        label.setVisible(true);
                        label.setValue(textField.getValue());
                    }

                }
                else
                {
                    label.setVisible(false);
                }
            }
        });*/


    }
}
