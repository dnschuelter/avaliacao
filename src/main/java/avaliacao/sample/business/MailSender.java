package avaliacao.sample.business;

import java.util.List;

import javax.ejb.Stateless;

import avaliacao.sample.entities.SkillType;

@Stateless
public class MailSender {

	private final String MAIL_TOKEN = "f72d17b52905a2b4296a473e856f49224408d2e8";

	public void sendToSkills(List<SkillType> keySet, String email) {
		System.out.println(email + ": " + keySet);
		sendMail("dn.schuelter@gmail.com");
	}

	public void sendMail(String to) {
		// String from = "sandbox@sparkpostbox.com";
		// String host = "smtp.sparkpostmail.com";
		// Properties properties = System.getProperties();
		// properties.setProperty("mail.user", "SMTP_Injection");
		// properties.setProperty("mail.password", MAIL_TOKEN);
		// properties.setProperty("mail.smtp.host", host);
		// Session session = Session.getDefaultInstance(properties);
		//
		// try {
		// MimeMessage message = new MimeMessage(session);
		// message.setFrom(new InternetAddress(from));
		// message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		// message.setSubject("This is the Subject Line!");
		// message.setText("This is actual message");
		//
		// Transport.send(message);
		// System.out.println("Sent message successfully....");
		// } catch (MessagingException mex) {
		// mex.printStackTrace();
		// }
	}
}
