/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.ProfileBean;

/**
 *
 * @author admin
 */
public interface ProfileDAO {
    
    public int createProfile(ProfileBean aProfile);
    public ArrayList findAll();
    public ArrayList findByName(String aName); // either get one back or several if multiple same name allowed  
    
}
