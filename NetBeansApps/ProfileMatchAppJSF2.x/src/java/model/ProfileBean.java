/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author lucasfevi
 */
public class ProfileBean {

    private String clientName;
    private String gender;
    private String position;
    private String[] industries;
    private String[] interests;
    private String comments;

    /**
     * @return the clientName
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * @param clientName the clientName to set
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * @return the industries
     */
    public String[] getIndustries() {
        return industries;
    }

    /**
     * @param industries the industries to set
     */
    public void setIndustries(String[] industries) {
        this.industries = industries;
    }

    /**
     * @return the interests
     */
    public String[] getInterests() {
        return interests;
    }

    /**
     * @param interests the interests to set
     */
    public void setInterests(String[] interests) {
        this.interests = interests;
    }

    /**
     * @return the comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(String comments) {
        this.comments = comments;
    }
}
