package be.mobyus.jsf.ex2;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by java on 31.10.16.
 */
@ManagedBean
@SessionScoped
public class Ex2Bean {

    private String text;

    public String showText() {return "";}

    public String getText() {return text;}

    public void setText(String text) {this.text = text;}
}
