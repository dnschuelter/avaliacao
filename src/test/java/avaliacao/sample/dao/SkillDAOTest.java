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
	private SkillDAO questionsDao;

	@Test
	public void verifyFindAll() {
		val questions = questionsDao.findAll();
		assertNotNull(questions);
		assertEquals(3, questions.size());
	}
}
