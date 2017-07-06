package be.mobyus.jsf.ex7;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by java on 31.10.16.
 */
@ManagedBean
@SessionScoped
public class EX7Bean {

    private int counter = 0;

    public int getCounter(){return counter;}

    public void resetCounter() {this.counter = 0;}

    public void incrementCounter() {this.counter++;}

    public void setCounter(int counter){this.counter = counter;}
}
