package cz.cca.mojecca.web.rest.isza;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cz.cca.mojecca.service.isza.UkolService;
import cz.cca.mojecca.service.isza.model.Ukol;
import cz.cca.mojecca.service.isza.model.UkolFilterParameters;

@Path("/services/isza/ukol")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UkolRestService {
	
	private static final Logger LOGGER = Logger.getLogger(UkolRestService.class.getName());
	
	@Inject
	private UkolService ukolService;

	@POST
	@Path("/ukols")
	public List<Ukol> getUkols(UkolFilterParameters params) {
		LOGGER.log(Level.FINE, "Požadavek na úkoly");
		
		return ukolService.getUkols(params);
	}	
}
