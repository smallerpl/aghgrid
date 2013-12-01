package view.backing;

import javax.annotation.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


import java.io.Serializable;

import javax.faces.event.ActionEvent;

@ManagedBean(name = "backing_loginBean")
@RequestScoped
public class LoginBean {// implements Serializable {
    //private static final String serialVersionUID = "loginBean";

    //public LoginBean() {
        //super();
    //}
    
    public String loginMainPage(){
        System.out.println("test");
        return "mainpage";
    }

    public void loginMainPage(ActionEvent actionEvent) {
        // Add event code here...
    }
}
