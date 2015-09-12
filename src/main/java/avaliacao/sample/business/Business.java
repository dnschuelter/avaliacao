package avaliacao.sample.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import lombok.val;
import avaliacao.sample.dao.SkillDAO;
import avaliacao.sample.entities.Level;
import avaliacao.sample.entities.Skill;
import avaliacao.sample.entities.SkillType;
import avaliacao.sample.entities.User;

@Stateless
public class Business {

	private Integer MINIMUN_LEVEL_VALUE = 7;

	@Inject
	private SkillDAO skillsDao;

	@Inject
	private MailSender mailSender;

	public List<Level> allLevels() {
		val skills = skillsDao.findAll();
		return skillsToLevel(skills);
	}

	public List<Level> skillsToLevel(List<Skill> skills) {
		val result = new ArrayList<Level>();
		for (Skill skill : skills) {
			result.add(new Level(skill, 0));
		}
		return result;
	}

	public void finish(User user) {
		val qualified = skillsQualified(user.getAbilites());
		mailSender.sendToSkills(qualified, user.getEmail());
	}

	public List<SkillType> skillsQualified(List<Level> abilities) {
		val result = new ArrayList<SkillType>(Arrays.asList(SkillType.values()));
		if (abilities != null) {
			for (Level level : abilities) {
				val skillType = level.getSkill().getType();
				if (level.getValue() < MINIMUN_LEVEL_VALUE && result.contains(skillType))
					result.remove(skillType);
			}
		}
		return result;
	}
}
