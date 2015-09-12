package avaliacao.sample.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import lombok.val;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import avaliacao.sample.dao.SkillDAO;

@RunWith(PowerMockRunner.class)
public class BusinessTest {

	@Mock
	private SkillDAO skillsDao;

	@InjectMocks
	private Business business;

	@Before
	public void setup() {
		when(skillsDao.findAll()).thenReturn(BusinessMockUtils.mockListSkills());
	}

	@Test
	public void verifySize() {
		val levels = business.allLevels();
		assertEquals(BusinessMockUtils.mockListSkills().size(), levels.size());
	}

	@Test
	public void verifySkillsQualified() {
		val levels = business.allLevels();
		val qualified = business.skillsQualified(levels);
		assertNotNull(qualified);
		assertEquals(0, qualified.size());
	}
}
