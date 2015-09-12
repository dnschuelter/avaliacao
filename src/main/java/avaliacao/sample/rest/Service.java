package avaliacao.sample.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import avaliacao.sample.business.Business;
import avaliacao.sample.entities.Level;

@Path("/service")
public class Service {

	@Inject
	private Business busienss;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getLevels")
	public List<Level> getLevels() {
		return busienss.allLevels();
	}

}
