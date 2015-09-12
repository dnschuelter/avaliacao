package avaliacao.sample.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import lombok.val;
import avaliacao.sample.dao.SkillDAO;
import avaliacao.sample.entities.Level;
import avaliacao.sample.entities.Skill;

@Stateless
public class Business {

	@Inject
	private SkillDAO skillsDao;

	public List<Level> allLevels() {
		val skills = skillsDao.findAll();
		return skillsToLevel(skills);
	}

	private List<Level> skillsToLevel(List<Skill> skills) {
		val result = new ArrayList<Level>();
		for (Skill skill : skills) {
			result.add(new Level(skill, null));
		}
		return result;
	}
}
