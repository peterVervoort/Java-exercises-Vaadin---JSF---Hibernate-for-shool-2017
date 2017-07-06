package be.mobyus.jsf.ex1;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by java on 31.10.16.
 */
@ManagedBean
@SessionScoped
public class Ex1Bean {

    private boolean showText;

    public void toggleText(){ showText = ! showText; }

    public boolean isShowText(){return  showText; }

}
