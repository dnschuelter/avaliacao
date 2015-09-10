package avaliacao.meuspedidos.sample.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import avaliacao.meuspedidos.sample.entities.Question;

@Path("/rest/service")
public class Service {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getQuestions")
	public List<Question> getQuestions() {
		return new ArrayList<Question>();
	}

}
