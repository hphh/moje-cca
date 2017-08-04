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

import cz.cca.mojecca.service.isza.KrokService;
import cz.cca.mojecca.service.isza.model.Krok;
import cz.cca.mojecca.service.isza.model.KrokFilterParameters;

@Path("/services/isza/krok")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class KrokRestService {
	
	private static final Logger LOGGER = Logger.getLogger(KrokRestService.class.getName());
	
	@Inject
	private KrokService krokService;

	@POST
	@Path("/kroks")
	public List<Krok> getUkols(KrokFilterParameters params) {
		LOGGER.log(Level.FINE, "Požadavek na kroky");
		
		return krokService.getKroks(params);
	}	
}
