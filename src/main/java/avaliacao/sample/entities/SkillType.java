package avaliacao.sample.entities;

import lombok.Getter;

public enum SkillType {
	FRONT_END("Front-End"), BACK_END("Back-End"), MOBILE("Mobile");

	@Getter
	private String description;

	private SkillType(String description) {
		this.description = description;
	}
}
