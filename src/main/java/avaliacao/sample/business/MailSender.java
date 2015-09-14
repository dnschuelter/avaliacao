package avaliacao.sample.business;

import java.util.List;

import javax.ejb.Stateless;

import lombok.val;
import avaliacao.sample.entities.SkillType;

import com.sendgrid.SendGrid;
import com.sendgrid.SendGridException;

@Stateless
public class MailSender {

	private final String MAIL_TOKEN = "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";
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
		SendGrid sendgrid = new SendGrid("avaliacao", MAIL_TOKEN);

		SendGrid.Email email = new SendGrid.Email();

		email.addTo(to);
		email.setFrom("you@youremail.com");
		email.setSubject(SUBJECT);
		email.setHtml(mail);

		try {
			SendGrid.Response response = sendgrid.send(email);
			System.out.println(response.getMessage());
		} catch (SendGridException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
