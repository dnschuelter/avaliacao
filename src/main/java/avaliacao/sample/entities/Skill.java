package avaliacao.sample.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Skill {

	public static final String FILE = "/skill.json";

	private String description;
	private SkillType type;
}
