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
        
    private String response;
    
    /**
     * Creates a new instance of UsersController
     */
    public UsersController() {
        theModel = new UserBean();
    }
    
    public String createUser() {
        UserDAO userDAO = new UserDAO();
        
        boolean saved = userDAO.createUser(theModel);
                
        if (saved) {
            theModel.sendConfirmationEmail();
            this.response = theModel.getUserInfo();
        } else {
            this.response = "Couldn't create your account!";
        }

        return "echo.xhtml";
    }
    
    public UserBean getTheModel() {
        return theModel;
    }

    public void setTheModel(UserBean theModel) {
        this.theModel = theModel;
    }

    /**
     * @return the response
     */
    public String getResponse() {
        return response;
    }

    /**
     * @param response the response to set
     */
    public void setResponse(String response) {
        this.response = response;
    }
    
}
