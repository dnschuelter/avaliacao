package avaliacao.sample.entities;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

	private String name;
	private String email;
	private List<Level> abilites;
}
