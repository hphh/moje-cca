package cz.cca.mojecca.web.rest;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import cz.cca.mojecca.service.imis.VykazPraceService;
import cz.cca.mojecca.service.imis.model.VykazPrace;

@Path("/services/imis/vykazPrace")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VykazPraceRestService {
	
	private static final Logger LOGGER = Logger.getLogger(VykazPraceRestService.class.getName());
	
	
	@Inject
	private VykazPraceService vykazPraceService;

	@GET
	@Path("/employeeVykazPraces")
	public List<VykazPrace> getOverview(@QueryParam("kodUzivatele") String kodUzivatele, @QueryParam("fromDate") Date fromDate, @QueryParam("toDate") Date toDate) {
		LOGGER.log(Level.FINE, "Požadavek na výkaz práce uživatele {0} od: {1} do: {2}", new Object[] {kodUzivatele, fromDate, toDate});
		
		return vykazPraceService.getEmployeeVykazPraces(kodUzivatele, fromDate, toDate);
	}	
}
