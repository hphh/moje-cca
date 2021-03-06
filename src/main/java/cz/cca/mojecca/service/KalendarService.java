package cz.cca.mojecca.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.joda.time.LocalDate;

import cz.cca.mojecca.db.isza.CcagDenniKapacitaDAO;
import cz.cca.mojecca.db.isza.model.CcagDenniKapacitaEntity;
import cz.cca.mojecca.db.isza.model.CcagDenniKapacitaFilterParameters;
import cz.cca.mojecca.service.data.KalendarDataAdapter;
import cz.cca.mojecca.service.imis.ImisKalendarService;
import cz.cca.mojecca.service.imis.model.ImisDen;
import cz.cca.mojecca.service.imis.model.ImisDensFilterParameters;
import cz.cca.mojecca.service.model.Den;
import cz.cca.mojecca.service.model.DensFilterParameters;
import cz.cca.mojecca.service.model.NextPracovniDenFilterParameters;

@RequestScoped
public class KalendarService {

	@Inject
	private ImisKalendarService imisKalendarService;

	@EJB
	private CcagDenniKapacitaDAO ccagDenniKapacitaDAO;

	public List<Den> getDens(DensFilterParameters params) {
		if (params.getKodUzivatele() == null) {
			throw new RuntimeException("Musí být uvedena osoba");
		}
		
		ImisDensFilterParameters idfParams = KalendarDataAdapter.toImisDensFilterParameters(params);
		List<ImisDen> imisDens = imisKalendarService.getImisDens(idfParams);

		CcagDenniKapacitaFilterParameters cdkfParams = KalendarDataAdapter.toCcagDenniKapacitaFilterParameters(params);
		List<CcagDenniKapacitaEntity> denniKapacitas = ccagDenniKapacitaDAO.getDenniKapacitas(cdkfParams);

		List<Den> result = imisDens.stream().map(imisDen -> {
			
			CcagDenniKapacitaEntity denniKapacitaEntity =
					denniKapacitas.stream().filter(d -> d.getDatum().equals(new Date(imisDen.getDatum()))).findFirst().get();

			return KalendarDataAdapter.toDen(imisDen, denniKapacitaEntity, params.getKodUzivatele());

		}).collect(Collectors.toList());

		return result;

	}

	public Den getNextPracovniDen(NextPracovniDenFilterParameters params) {
		if (params.getKodUzivatele() == null) {
			throw new RuntimeException("Musí být uvedena osoba");
		}
		
		DensFilterParameters ps = new DensFilterParameters();
		ps.setKodUzivatele(params.getKodUzivatele());
		LocalDate day = new LocalDate(params.getDay());
		ps.setFromDate(day.plusDays(1).toDate().getTime());
		ps.setToDate(day.plusDays(30).toDate().getTime());
		List<Den> dens = getDens(ps);
		
		for (Den d : dens) {
			if ("P".equals(d.getIszaDen().getDruhDne())) {
				return d;
			}
		}

		return null;
	}

}
