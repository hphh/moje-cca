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

import cz.cca.mojecca.service.imis.KalendarService;
import cz.cca.mojecca.service.imis.model.ImisDay;
import cz.cca.mojecca.service.imis.model.ImisDaysFilterParameters;

@Path("/services/imis/kalendar")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class KalendarRestService {
	
	private static final Logger LOGGER = Logger.getLogger(KalendarRestService.class.getName());
	

	@Inject
	private KalendarService kalendarService;
	
	@POST
	@Path("/imisDays")
	public List<ImisDay> getImisDays(ImisDaysFilterParameters params) {
		LOGGER.log(Level.FINE, "Požadavek na dny v kalendáři");
		return kalendarService.getImisDays(params);
	}
}
