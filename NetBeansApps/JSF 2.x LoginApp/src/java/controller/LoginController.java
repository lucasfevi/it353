/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.LoginBean;

/**
 *
 * @author bllim
 */
@ManagedBean
@SessionScoped
public class LoginController {

    private LoginBean theModel;
    
    private HashMap map;
    
    private String response;

    /**
     * Creates a new instance of ProfileController
     */
    public LoginController() {
        theModel = new LoginBean();
                
        map = new HashMap();
        map.put("Billy123", "aaaaaaaa");
        map.put("Mary1234", "bbbbbbbb");
        map.put("Joe12345", "cccccccc");
    }

    public String login() {
        boolean validLogin = false;
        
        Set keys = map.keySet();
        Iterator<String> iterator = keys.iterator();
        
        while(iterator.hasNext()) {
            String username = iterator.next();
            if (theModel.getUsername().equals(username) &&
                    theModel.getPassword().equals(map.get(username))) {
                validLogin = true;
                break;
            }
        }

        if (validLogin) {
            return "success.xhtml";
        }

        return "error.xhtml";
    }

    /**
     * @return the theModel
     */
    public LoginBean getTheModel() {
        return theModel;
    }

    /**
     * @param theModel the theModel to set
     */
    public void setTheModel(LoginBean theModel) {
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
