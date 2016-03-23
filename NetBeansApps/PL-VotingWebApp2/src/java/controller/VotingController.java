/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.TallyMachine;

/**
 *
 * @author billylim
 */
@ManagedBean
@SessionScoped
public class VotingController {

    private String lang;
    private boolean voted;
    private String response = "";
    
    // Can also inject the TallyMachine managedBean like this:
    //@ManagedProperty("#{tallyMachine}")
    //private TallyMachine tallyMC; 
    

    /**
     * Creates a new instance of VotingController
     */
    public VotingController() {
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public boolean isVoted() {
        return voted;
    }

    public void setVoted(boolean voted) {
        this.voted = voted;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    // 1. Check to see if the user has already vote.
    // 2. If so, display appropriate message. Otherwise, register the vote.
    // 3. To register the vote, you need to access the TallyMachine. If one doesn't exist, create one and put it in the applicationMap.
    //    Otherwise, just use the existing one.
    // 4. Once you have the TallyMachine, pass it the language vote and have it included in the total tally.
    // 5. Get the tallies back from the TallyMachine and display them.
    
    public String registerMyVote() {
        if (voted) {
            System.out.println("voted already!");
            response = "Sorry ... you have voted already. No stuffing of ballots please!";
        } else {
            setVoted(true);
            System.out.println(lang + " vote registered!");
            TallyMachine tallyMC = (TallyMachine) FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("TallyMachine");
                // if there is no VotingBean created before, create one and register it with the application map
            // Otherwise, just use the existing one.
            if (tallyMC == null) {
                tallyMC = new TallyMachine();
                FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().put("TallyMachine", tallyMC);
            }
            tallyMC.registerVote(lang); // register the vote
            response = "Thank you for your vote!";
            String allVotes = tallyMC.getAllVotes();
            response += "Below is a tally of all votes so far: <br/><br/>" + allVotes;
        }

        return "response.xhtml";
    }

    /**
     * @param tallyMC the tallyMC to set
     */
/*    public void setTallyMC(TallyMachine tallyMC) {
        this.tallyMC = tallyMC;
    }
*/
    /**
     * @return the tallyMC
     */
/*    public TallyMachine getTallyMC() {
        return tallyMC;
    }
*/
}
