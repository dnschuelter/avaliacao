package avaliacao.sample.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import avaliacao.sample.dao.SkillDAO;
import avaliacao.sample.entities.Skill;

@Stateless
public class Business {

	@Inject
	private SkillDAO skillsDao;

	public List<Skill> allSkills() {
		return skillsDao.findAll();
	}
}
