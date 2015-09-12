package avaliacao.sample.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import avaliacao.sample.entities.Skill;

@Path("/service")
public class Service {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getSkill")
	public List<Skill> getSkill() {
		return new ArrayList<Skill>();
	}

}
