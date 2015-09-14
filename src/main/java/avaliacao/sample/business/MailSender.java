package avaliacao.sample.business;

import java.util.List;
import java.util.Properties;

import javax.ejb.Stateless;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import lombok.val;
import avaliacao.sample.entities.SkillType;

@Stateless
public class MailSender {

	private static final String MAIL_GMAIL_USER = "teste.auto.avaliacao@gmail.com";
	// private static final String MAIL_GMAIL_PASS = "teste.auto.avaliacao@123";
	private static final String MAIL_GMAIL_PASS = "anscbqlktelejini";
	// private static final String MAIL_GMAIL_PASS = "xhzdrteaxxuzxdgy";
	private final String SUBJECT = "Obrigado por se candidatar";

	public void sendToSkills(List<SkillType> skills, String email) {
		val mail = mountMailBySkills(skills);
		sendMail(email, mail);
	}

	public String mountMailBySkills(List<SkillType> skills) {
		String mailStr = "";
		for (int i = skills.size() - 1; i >= 0; i--) {
			if (i == 0)
				mailStr = "para programador " + mailStr + skills.get(i).getDescription() + " ";
			if (i == 1)
				mailStr = mailStr + skills.get(i).getDescription() + " ou ";
			if (i > 1)
				mailStr = mailStr + skills.get(i).getDescription() + ", ";
		}
		mailStr = "Obrigado por se candidatar, assim que tivermos uma vaga disponível " + mailStr + "entraremos em contato.";
		return mailStr;
	}

	public void sendMail(String to, String mail) {
		Properties props = new Properties();
		/** Parâmetros de conexão com servidor Gmail */
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(MAIL_GMAIL_USER, MAIL_GMAIL_PASS);
			}
		});

		/** Ativa Debug para sessão */
		session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(MAIL_GMAIL_USER));

			Address[] toUser = InternetAddress.parse(to);

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject(SUBJECT);
			message.setText(mail);
			/** Método para enviar a mensagem criada */
			session.getTransport("smtps").send(message);

			System.out.println("Feito!!!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
