package avaliacao.sample.business;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import lombok.val;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.modules.junit4.PowerMockRunner;

import avaliacao.sample.entities.SkillType;

@RunWith(PowerMockRunner.class)
public class MailSenderTest {

	private static final String END_MAIL = "entraremos em contato.";
	private static final String INIT_MAIL = "Obrigado por se candidatar, assim que tivermos uma vaga disponível ";
	@InjectMocks
	private MailSender mailSender;

	@Test
	@Ignore
	public void sendMail() {

	}

	@Test
	public void testeMail3Skills() {
		val expected = INIT_MAIL + "para programador Mobile, Back-End ou Front-End " + END_MAIL;
		val mail = mailSender.mountMailBySkills(new ArrayList<SkillType>() {
			private static final long serialVersionUID = 1L;
			{
				add(SkillType.FRONT_END);
				add(SkillType.BACK_END);
				add(SkillType.MOBILE);
			}
		});
		assertEquals(expected, mail);
	}

	@Test
	public void testeMail2Skills() {
		val expected = INIT_MAIL + "para programador Back-End ou Front-End " + END_MAIL;
		val mail = mailSender.mountMailBySkills(new ArrayList<SkillType>() {
			private static final long serialVersionUID = 1L;
			{
				add(SkillType.FRONT_END);
				add(SkillType.BACK_END);
			}
		});
		assertEquals(expected, mail);
	}

	@Test
	public void testeMail1Skills() {
		val expected = INIT_MAIL + "para programador Front-End " + END_MAIL;
		val mail = mailSender.mountMailBySkills(new ArrayList<SkillType>() {
			private static final long serialVersionUID = 1L;
			{
				add(SkillType.FRONT_END);
			}
		});
		assertEquals(expected, mail);
	}

	@Test
	public void testeMail0Skills() {
		val expected = INIT_MAIL + END_MAIL;
		val mail = mailSender.mountMailBySkills(new ArrayList<SkillType>());
		assertEquals(expected, mail);

	}
}
