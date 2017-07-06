package be.mobyus.jsf.ex6;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by java on 31.10.16.
 */
@ManagedBean
@SessionScoped
public class Ex6Bean {

    private String text1, text2, text3;

    public void reset (){
        text1 = null;
        text2 = null;
        text3 = null;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }
}
