package be.mobyus.jsf.ex8;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

/**
 * Created by java on 31.10.16.
 */
@ManagedBean (name = "navigationControler", eager = true)
@RequestScoped
public class Ex8NavigationBean implements Serializable{
    public String moveToPage1(){ return"ex8Page1";}
    public String moveToPage2(){ return"ex8Page2";}
}
