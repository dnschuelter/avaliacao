package avaliacao.sample.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import lombok.val;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class SkillDAOTest {

	@InjectMocks
	private SkillDAO skillsDao;

	@Test
	public void verifyLoadSkills() {
		val questions = skillsDao.findAll();
		assertNotNull(questions);
		assertEquals(7, questions.size());
	}
}
