/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import model.ProfileBean;

/**
 *
 * @author lucasfevi
 */
@Named(value = "profileController")
@SessionScoped
public class ProfileController implements Serializable {

    // This is the model that captures the user profile info
    private ProfileBean theModel;

    // This corresponds to the response to be sent back to the client
    private String response;

    /**
     * Creates a new instance of ProfileController
     */
    public ProfileController() {
        theModel = new ProfileBean(); // There is a better way to handle this; Later ...
    }

    /**
     * @return the theModel
     */
    public ProfileBean getTheModel() {
        return theModel;
    }

    /**
     * @param theModel the theModel to set
     */
    public void setTheModel(ProfileBean theModel) {
        this.theModel = theModel;
    }

    /**
     * @return the response
     */
    public String getResponse() {
        String resultStr = "";
        resultStr += "Hello " + theModel.getClientName() + "<br/>";
        resultStr += "I see that you are a " + theModel.getGender() + " " + theModel.getPosition() + "<br/>";
        
        String temp = "";
        for (int i = 0; i < theModel.getIndustries().length; i++) {
            temp += theModel.getIndustries()[i] + "; ";
        }
        
        resultStr += "We have expertise in the industries you are in, namely " + temp + "<br/>";
        temp = "";
        for (int i = 0; i < theModel.getInterests().length; i++) {
            temp += theModel.getInterests()[i] + "; ";
        }
        
        resultStr += "We also note your interests of " + temp + "<br/><br/>";
        resultStr += "Our people will contact your people ASAP. Thanks for contacting us!<br/><br/>";
        resultStr += "Also, here is your comments: " + theModel.getComments();
        response = resultStr;
        
        return response;
    }

    /**
     * @param response the response to set
     */
    public void setResponse(String response) {
        this.response = response;
    }
}
