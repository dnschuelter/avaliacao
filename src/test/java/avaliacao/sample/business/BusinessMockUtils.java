package avaliacao.sample.business;

import java.util.ArrayList;
import java.util.List;

import avaliacao.sample.entities.Skill;
import avaliacao.sample.entities.SkillType;

public class BusinessMockUtils {

	@SuppressWarnings("serial")
	public static List<Skill> mockListSkills() {
		return new ArrayList<Skill>() {
			{
				add(new Skill(1l, "teste 1", SkillType.FRONT_END));
				add(new Skill(2l, "teste 3", SkillType.BACK_END));
				add(new Skill(3l, "teste 2", SkillType.MOBILE));
			}
		};
	}

}
