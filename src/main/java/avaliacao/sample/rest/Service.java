package avaliacao.sample.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import avaliacao.sample.business.Business;
import avaliacao.sample.entities.Level;
import avaliacao.sample.entities.User;

@Path("/service")
public class Service {

	@Inject
	private Business business;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getLevels")
	public List<Level> getLevels() {
		return business.allLevels();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/finish")
	public void finish(User user) {
		business.finish(user);
	}
}
