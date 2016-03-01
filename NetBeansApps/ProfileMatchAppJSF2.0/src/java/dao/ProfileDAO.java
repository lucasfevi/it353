/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.ProfileBean;

/**
 *
 * @author admin
 */
public interface ProfileDAO {
    
    public int createProfile(ProfileBean aProfile);
    public ProfileBean[] findAll();
    public ProfileBean findByName(String aName);   
    
}
