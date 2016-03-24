package controller;

import dao.UserDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.UserBean;

/**
 * @author ldacruz
 */
@ManagedBean
@SessionScoped
public class UsersController {

    private UserBean theModel;
    private String status;
    
    /**
     * Creates a new instance of UsersController
     */
    public UsersController() {
        theModel = new UserBean();
    }
    
    public String createUser() {
        UserDAO userDAO = new UserDAO();
        
        int rowCount = userDAO.createProfile(theModel);
        
        this.status = (rowCount == 1) ? "success" : "error";

        return "echo.xhtml";
    }
    
    public UserBean getTheModel() {
        return theModel;
    }

    public void setTheModel(UserBean theModel) {
        this.theModel = theModel;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
}
