package cz.cca.mojecca.web.rest;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cz.cca.mojecca.service.KalendarService;
import cz.cca.mojecca.service.model.Den;
import cz.cca.mojecca.service.model.DensFilterParameters;

@Path("/services/kalendar")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class KalendarRestService {

	private static final Logger LOGGER = Logger.getLogger(KalendarRestService.class.getName());
	
	@Inject
	private KalendarService kalendarService;
	
	@POST
	@Path("/dens")
	public List<Den> getDens(DensFilterParameters params) {
		LOGGER.log(Level.FINE, "Požadavek na dny v kalendáři");
		return kalendarService.getDens(params);
	}
}
	
