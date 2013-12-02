package view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


import java.io.Serializable;

import javax.faces.event.ActionEvent;

@ManagedBean(name = "navigationController")
@RequestScoped
public class NavigationController implements Serializable {
        
    public String goToMainPage(){
        //System.out.println("mainpage");
        return "mainpage";
    }
}
