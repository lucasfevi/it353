/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProfileDAO;
import dao.ProfileDAOImpl;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.ProfileBean;

/**
 *
 * @author bllim
 */
@ManagedBean
@SessionScoped
public class ProfileController {

    // This is the model that captures the user profile info
    private ProfileBean theModel;
    // This corresponds to the response to be sent back to the client
    private String response;

    /**
     * Creates a new instance of ProfileController
     */
    public ProfileController() {
        theModel = new ProfileBean();
    }

    public ProfileBean getTheModel() {
        return theModel;
    }

    public void setTheModel(ProfileBean theModel) {
        this.theModel = theModel;
    }

    public String getResponse() {
        String resultStr = "";
        resultStr += "Hello " + theModel.getClientName() + "<br/>";
        resultStr += "I see that you are a " + theModel.getGender() + " " + theModel.getPosition() + "<br/>";
        
        if (theModel.getIndustries().length != 0) {
            String temp = "";
            for (String industry : theModel.getIndustries()) {
                temp += industry + "; ";
            }
            
            resultStr += "We have expertise in the industries you are in, namely " + temp + "<br/>";
        }
        
        if (theModel.getIndustries().length != 0) {
            String temp = "";
            for (String interest : theModel.getInterests()) {
                temp += interest + "; ";
            }
            
            resultStr += "We also note your interests of " + temp + "<br/><br/>";
        }
        resultStr += "Our people will contact your people ASAP. Thanks for contacting us!";
        response = resultStr;
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String createProfile() {
        ProfileDAO aProfileDAO = new ProfileDAOImpl();    // Creating a new object each time.
        int rowCount = aProfileDAO.createProfile(theModel);  // Doing anything with the object after this?

        if (rowCount == 1) {
            return "response.xhtml"; // navigate to "response.xhtml"
        } else {
            return "error.xhtml";
        }

    }

}
