package be.mobyus.jsf.ex3;

import org.hibernate.validator.constraints.NotBlank;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * Created by java on 31.10.16.
 */
@ManagedBean
@SessionScoped
public class Ex3Bean {

    @NotBlank(message = "{name.not.blank}")
    private String name;

    @Digits(integer = 3, fraction = 0)
    private String serial;

    @Future
    private Date date;

    @Pattern(regexp = "[1-9]\\d*")
    private String nullOrNumber;

    public void submit(ActionEvent event) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Date getdate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNullOrNumber() {
        return nullOrNumber;
    }

    public void setNullOrNumber(String nullOrNumber) {
        this.nullOrNumber = nullOrNumber;
    }
}
