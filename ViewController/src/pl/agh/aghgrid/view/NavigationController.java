package pl.agh.aghgrid.view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import pl.agh.aghgrid.controller.UserDao;
import pl.agh.aghgrid.controller.Util;

@ManagedBean(name = "navigationController")
@RequestScoped
public class NavigationController implements Serializable {
    //@SuppressWarnings("compatibility:2876399477655125890")
    //private static final long serialVersionUID = 1L;

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

    public String loginProject() {
        //System.out.println("mainpage");

        boolean result;
        result = UserDao.login(username, password);
        if (result) {
            // get Http Session and store username
            HttpSession session = Util.getSession();
            session.setAttribute("username", username);
            return "testpage";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_WARN, "Invalid Login!",
                                                                          "Please Try Again!"));
            return "index";
        }
    }
    
    public String logout() {
          HttpSession session = Util.getSession();
          session.invalidate();
          return "index";
       }
}
