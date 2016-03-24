package model;

/**
 *
 * @author lucasfevi
 */
public class UserBean {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;
    private String secQuestion;
    private String secAnswer;
    
    public UserBean() {}
    
    public UserBean(String firstName, String lastName, String email,
                    String password, String secQuestion, String secAnswer) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.secQuestion = secQuestion;
        this.secAnswer = secAnswer;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the secQuestion
     */
    public String getSecQuestion() {
        return secQuestion;
    }

    /**
     * @param secQuestion the secQuestion to set
     */
    public void setSecQuestion(String secQuestion) {
        this.secQuestion = secQuestion;
    }

    /**
     * @return the secAnswer
     */
    public String getSecAnswer() {
        return secAnswer;
    }

    /**
     * @param secAnswer the secAnswer to set
     */
    public void setSecAnswer(String secAnswer) {
        this.secAnswer = secAnswer;
    }

    /**
     * @return the confirmPassword
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * @param confirmPassword the confirmPassword to set
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
