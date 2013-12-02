package view;

import controller.DataAccessObject;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;

import java.io.Serializable;

import javax.faces.event.ActionEvent;

@ManagedBean(name = "navigationController")
@RequestScoped
public class NavigationController implements Serializable {
    private String username;
        private String password;
     
         
        public String getPassword() {
            return password;
        }
     
        public void setPassword(String password) {
            this.password = password;
        }
     
        public String getUsername() {
            return username;
        }
     
        public void setUsername(String username) {
            this.username = username;
        }
    
    public String goToMainPage(){
        //System.out.println("mainpage");
        
        boolean result = DataAccessObject.login(username, password);
                if (result) {
                    return "mainpage";
                } else {
                    FacesContext.getCurrentInstance().addMessage(
                            null,
                            new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Invalid Login!",
                            "Please Try Again!"));
                    return "index";
                }
        
        //return "mainpage";
    }
}
