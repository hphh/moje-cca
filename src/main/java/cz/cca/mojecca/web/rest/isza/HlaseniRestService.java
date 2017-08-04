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

import cz.cca.mojecca.service.isza.HlaseniService;
import cz.cca.mojecca.service.isza.model.Hlaseni;
import cz.cca.mojecca.service.isza.model.HlaseniFilterParameters;

@Path("/services/isza/hlaseni")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HlaseniRestService {
	
	private static final Logger LOGGER = Logger.getLogger(HlaseniRestService.class.getName());
	
	@Inject
	private HlaseniService hlaseniService;

	@POST
	@Path("/hlasenis")
	public List<Hlaseni> getUkols(HlaseniFilterParameters params) {
		LOGGER.log(Level.FINE, "Požadavek na hlášení");
		
		return hlaseniService.getHlasenis(params);
	}	
}
