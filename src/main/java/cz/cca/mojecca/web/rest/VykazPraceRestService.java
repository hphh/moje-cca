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

import cz.cca.mojecca.service.imis.VykazPraceService;
import cz.cca.mojecca.service.imis.model.ConfirmVykazPracesParameters;
import cz.cca.mojecca.service.imis.model.SplittingVykazPrace;
import cz.cca.mojecca.service.imis.model.VykazPrace;
import cz.cca.mojecca.service.imis.model.VykazPracesFilterParameters;

@Path("/services/imis/vykazPrace")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VykazPraceRestService {
	
	private static final Logger LOGGER = Logger.getLogger(VykazPraceRestService.class.getName());
	
	
	@Inject
	private VykazPraceService vykazPraceService;

	@POST
	@Path("/vykazPraces")
	public List<VykazPrace> getOverview(VykazPracesFilterParameters vykazPracesFilterParameters) {
		LOGGER.log(Level.FINE, "Požadavek na výkazy práce uživatele {0}", 
				new Object[] {vykazPracesFilterParameters.getKodUzivatele()});
		
		return vykazPraceService.getEmployeeVykazPraces(vykazPracesFilterParameters);
	}	
	
	@POST
	@Path("/updateVykazPraces")
	public void updateVykazPraces(List<VykazPrace> vykazPraces) {
		LOGGER.log(Level.FINE, "Požadavek na změnu výkazů práce {0} ", vykazPraces.size());
		
		vykazPraceService.updateVykazPraces(vykazPraces);
	}
	
	@POST
	@Path("/splitVykazPrace")
	public void splitVykazPrace(SplittingVykazPrace splittingVykazPrace) {
		LOGGER.log(Level.FINE, "Požadavek na rozdělení výkazu práce {0} ", splittingVykazPrace.getOldVykazPrace().getId());
		
		vykazPraceService.splitVykazPrace(splittingVykazPrace);
	}
	
	@POST
	@Path("confirmVykazPraces")
	public void confirmVykazPraces(ConfirmVykazPracesParameters params) {
		LOGGER.log(Level.FINE, "Požadavek na potvrzení výkazů práce");
		
		vykazPraceService.confirmVykazPraces(params);
	}
	
}
