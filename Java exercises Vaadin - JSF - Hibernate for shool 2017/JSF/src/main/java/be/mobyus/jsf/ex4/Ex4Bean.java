package be.mobyus.jsf.ex4;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by java on 31.10.16.
 */
@ManagedBean
@SessionScoped
public class Ex4Bean {

    private int counter;

    public void increment() { counter ++;}

    public int getCounter() { return counter;}

    public void setCounter(int counter) {this.counter = counter;}
}
