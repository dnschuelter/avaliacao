package avaliacao.sample.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Skill {

	public static final String FILE = "/skill.json";

	private Long id;
	private String description;
	private SkillType type;
}
