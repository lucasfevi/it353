package model;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

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
    
    public String getUserInfo() {
        String userInfo;
        
        String passStars = "";
        for (int i = 0; i < this.getPassword().length(); i++) {
            passStars += "*";
        }
        
        userInfo = "<b>Name:</b> " + this.getFirstName() + " " + this.getLastName()
            + "<br><b>E-mail:</b> " + this.getEmail()
            + "<br><b>Password:</b> " + passStars
            + "<br><b>Security Question:</b> " + this.getSecQuestion()
            + "<br><b>Security Answer:</b> " + this.getSecAnswer();
        
        return userInfo;
    }
    
    public String getUserInfoAsHtml() {
        String userInfoAsHtml;
        
        userInfoAsHtml = "<p>Welcome to our application. Below you can see your"
            + "information.</p>"
            + "<p>" + this.getUserInfo() + "</p>"
            + "<img src=\"cid:image\">";
        
        return userInfoAsHtml;
    }
    
    public void sendConfirmationEmail() {
        String to = this.getEmail();
        String from = "itk353web@gmail.com";
        
        final String host = "smtp.gmail.com";
        final String user = "itk353web@gmail.com";
        final String pass = "isustudent";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", 587);

        Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
               protected PasswordAuthentication getPasswordAuthentication() {
                  return new PasswordAuthentication(user, pass);
               }
            });
        
        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
               InternetAddress.parse(to));

            // Set Subject: header field
            message.setSubject("Your account has been created!");

            // This mail has 2 part, the BODY and the embedded image
            MimeMultipart multipart = new MimeMultipart("related");

            // first part (the html)
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(this.getUserInfoAsHtml(), "text/html");
            
            // add it
            multipart.addBodyPart(messageBodyPart);

            // second part (the image)
            messageBodyPart = new MimeBodyPart();
            DataSource fds = new FileDataSource("/Users/lucasfevi/Projects/it353/NetBeansApps/Assign3WebApp/web/resources/images/jsf-logo.png");

            messageBodyPart.setDataHandler(new DataHandler(fds));
            messageBodyPart.setHeader("Content-ID", "<image>");

            // add image to the multipart
            multipart.addBodyPart(messageBodyPart);

            // put everything together
            message.setContent(multipart);
            // Send message
            Transport.send(message);

            System.out.println("Sent message successfully....");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
