package pl.agh.aghgrid.view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import oracle.adf.view.rich.component.rich.input.RichInputText;

import pl.agh.aghgrid.controller.TaskDao;

@ManagedBean(name = "taskInsert")
@RequestScoped
public class TaskInsert implements Serializable {
    
    private Integer user_id;
    private String username;
    private String request;
    
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getRequest() {
        return request;
    }
    
    public void insertTask() {
        //System.out.println("mainpage");
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
            UIViewRoot root = facesContext.getViewRoot();
            RichInputText inputText = (RichInputText)root.findComponent("it1");
            username = inputText.getValue().toString();
        
        /* //
        FacesContext fc = FacesContext.getCurrentInstance();
        ELContext elctx = fc.getELContext();
        ExpressionFactory elFactory = fc.getApplication().getExpressionFactory();
        MethodExpression methodExpr = elFactory.createMethodExpression(elctx,
        "#{bindings.createWorkAreaGroup.execute}",
        null, new Class[]{});
        Object returnValue = methodExpr.invoke(elctx,new Object[]{});
        DCBindingContainer cont = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingFactory();
        DCIteratorBinding iteratorBinding = (DCIteratorBinding)cont.get("allWorkAreaGroupsIterator");
        iteratorBinding.invalidateCache();
        iteratorBinding.executeQuery();  
        //
        EntityManager em;
        em.refresh();
        // */
        
        System.out.println(request);        
        System.out.println(username);
        boolean result;
        result = TaskDao.createRequest(username, request);
        if (result) {
            // get Http Session and store username
            //HttpSession session = Util.getSession();
            //session.setAttribute("username", username);
            //return "newmain";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_WARN, "Action was not added!",
                                                                          "Action was not added! Please Try Again!"));
            //return "index";
        }
    }
}
