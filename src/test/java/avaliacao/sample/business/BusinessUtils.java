package avaliacao.sample.business;

import java.util.ArrayList;
import java.util.List;

import avaliacao.sample.entities.Skill;
import avaliacao.sample.entities.SkillType;

public class BusinessUtils {

	@SuppressWarnings("serial")
	public static List<Skill> mockListSkills() {
		return new ArrayList<Skill>() {
			{
				add(new Skill("teste 1", SkillType.FRONT_END));
				add(new Skill("teste 3", SkillType.BACK_END));
				add(new Skill("teste 2", SkillType.MOBILE));
			}
		};
	}

}
