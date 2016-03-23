/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;
import java.util.Iterator;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author BillyLim
 */
@ManagedBean
@ApplicationScoped
public class TallyMachine {

    private HashMap langHashMap;

    /** Creates a new instance of VotingBean */
    public TallyMachine() {
        langHashMap = new HashMap();
        langHashMap.put("Java", new Integer(0));
        langHashMap.put("COBOL", new Integer(0));
        langHashMap.put("JavaScript", new Integer(0));
        langHashMap.put("CSharp", new Integer(0));

    }

    public void registerVote(String langVoted) {
        Integer votedCount = (Integer) langHashMap.get(langVoted);
        langHashMap.put(langVoted, new Integer(votedCount.intValue() + 1));
        System.out.println("new count:" + langHashMap.get(langVoted));
    }

    public String getAllVotes() {
        String result = "";
        Iterator iterator = langHashMap.keySet().iterator();
        while (iterator.hasNext()) {
            String lang = (String) iterator.next();
            Integer votedCount = (Integer) langHashMap.get(lang);
            result += lang + ":" + votedCount + "<br/>";
        }
        return result;
    }
}
