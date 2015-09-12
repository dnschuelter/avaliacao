package avaliacao.sample.business;

import java.util.List;

import javax.ejb.Stateless;

import avaliacao.sample.entities.SkillType;

@Stateless
public class MailSender {

	public void sendToSkills(List<SkillType> keySet, String email) {
		System.out.println(email + ": " + keySet);
	}

}
