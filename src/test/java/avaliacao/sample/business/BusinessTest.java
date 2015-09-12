package avaliacao.sample.business;

import static org.junit.Assert.assertEquals;
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
		when(skillsDao.findAll()).thenReturn(BusinessUtils.mockListSkills());
	}

	@Test
	public void verifyNotModifyReturn() {
		val skills = business.allSkills();
		assertEquals(BusinessUtils.mockListSkills().toString(), skills.toString());
	}
}
