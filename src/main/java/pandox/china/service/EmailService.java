package pandox.china.service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;
import com.amazonaws.services.simpleemail.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pandox.china.dto.AccountDTO;


@Service
public class EmailService {

    private static final String MESSAGE_SIGNATURE = "<br /><br />Atenciosamente,<br />Equipe World of MU<br /><a href=\"http://www.worldofmu.com.br\">www.worldofmu.com.br</a>";

    @Autowired
    private AWSCredentials awsCredentials;

    public void sendCreationEmail(AccountDTO accountDTO, String token) {

        String to = accountDTO.getEmail();
        String name = accountDTO.getName();
        String message = getCreationAccountEmailBody(name, token);


        sendEmail(to, "Verificação de Email", message);
    }

    private String getCreationAccountEmailBody(String name, String token) {
        String URL = "http://www.worldofmu.com.br/conta/email/confirmacao?token=" + token;
        StringBuilder sb = new StringBuilder();
        sb.append("Olá ");
        sb.append(name);
        sb.append(",<br /><br />Clique no link a seguir para verificar sua conta em World of MU.<br />");
        sb.append("<a href=\"");
        sb.append(URL);
        sb.append("\">");
        sb.append(URL);
        sb.append("</a><br /><br />");

        sb.append("Com a verificação de e-mail, você poderá usar todas a funções de sua conta em World of MU e receber nosso contato de forma mais rápida, garantindo o suporte e acesso a todas as nossas novidades!<br />Essa verificação garante um nível maior de segurança.<br />");
        sb.append(MESSAGE_SIGNATURE);

        return sb.toString();
    }


    private void sendEmail(String to, String title, String message) {
        try {
            // Construct an object to contain the recipient address.
            Destination destination = new Destination().withToAddresses(to);

            // Create the subject and body of the message.
            Content subject = new Content().withData(title);
            Content textBody = new Content().withData(message);
            Body body = new Body().withHtml(textBody);

            // Create a message with the specified subject and body.
            Message emailMessage = new Message(subject, body);

            // Assemble the email.
            SendEmailRequest request = new SendEmailRequest()
                    .withSource("World of MU <suporte@worldofmu.com.br>")
                    .withDestination(destination)
                    .withMessage(emailMessage);

            AmazonSimpleEmailServiceClient client = new AmazonSimpleEmailServiceClient(awsCredentials);

            Region REGION = Region.getRegion(Regions.US_EAST_1);
            client.setRegion(REGION);


            SetIdentityDkimEnabledRequest dkimEnabledRequest = new SetIdentityDkimEnabledRequest();
            dkimEnabledRequest.setIdentity("worldofmu.com.br");
            dkimEnabledRequest.setDkimEnabled(true);
            client.setIdentityDkimEnabled(dkimEnabledRequest);

            // Send the email.
            client.sendEmail(request);
        } catch (Exception ex) {
            System.out.println("The email was not sent.");
            System.out.println("Error message: " + ex.getMessage());
        }
    }

}
