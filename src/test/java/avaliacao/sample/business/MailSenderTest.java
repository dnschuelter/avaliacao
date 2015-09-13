package avaliacao.sample.business;

import org.junit.Test;

import com.sendgrid.SendGrid;
import com.sendgrid.SendGridException;

//@RunWith(PowerMockRunner.class)
public class MailSenderTest {

	// @InjectMocks
	private MailSender mailSender;

	@Test
	public void sendMail() {
		SendGrid sendgrid = new SendGrid("avaliacao", "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");

		SendGrid.Email email = new SendGrid.Email();

		email.addTo("dn.schuelter@gmail.com");
		email.setFrom("you@youremail.com");
		email.setSubject("Sending with SendGrid is Fun");
		email.setHtml("and easy to do anywhere, even with Java");

		try {
			SendGrid.Response response = sendgrid.send(email);
			System.out.println(response.getMessage());
		} catch (SendGridException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
