package cz.cca.mojecca.web.rest.imis;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cz.cca.mojecca.service.imis.DochazkaService;
import cz.cca.mojecca.service.imis.model.EmployeeDayPrichodOdchods;
import cz.cca.mojecca.service.imis.model.EmployeeDayPrichodOdchodsFilterParameters;
import cz.cca.mojecca.service.imis.model.EmployeeNahradniVolno;
import cz.cca.mojecca.service.imis.model.EmployeeNahradniVolnoFilterParameters;

@Path("/services/imis/dochazka")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DochazkaRestService {
	
	@Inject
	private DochazkaService dochazkaService;
	
	
	@POST
	@Path("/employeeDayPrichodOdchods")
	public EmployeeDayPrichodOdchods getEmployeeDayPrichodOdchods(EmployeeDayPrichodOdchodsFilterParameters params) {
		return dochazkaService.getEmployeeDayPrichodOdchods(params);
	}
		
	@POST
	@Path("/employeeNahradniVolno")
	public EmployeeNahradniVolno getEmployeeNahradniVolno(EmployeeNahradniVolnoFilterParameters params) {
		return dochazkaService.getEmployeeNahradniVolno(params);
	}

}
