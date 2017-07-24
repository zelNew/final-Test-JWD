package jwd.Modul3.Test12.app.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.Modul3.Test12.app.model.Pivo;
import jwd.Modul3.Test12.app.service.PivaraService;
import jwd.Modul3.Test12.app.service.PivoService;
import jwd.Modul3.Test12.app.service.VrstaPivaService;
import jwd.Modul3.Test12.app.webDTO.PivoDTO;

@Component
public class PivoDtoTOPivo implements Converter<PivoDTO, Pivo> {
	@Autowired
	private PivoService pivoService;
	@Autowired
	private PivaraService pivaraService;
	@Autowired
	private VrstaPivaService vrstaService;

	@Override
	public Pivo convert(PivoDTO pivoDTO) {
		Pivo pivo;
		if (pivoDTO.getId() == null) {
			pivo = new Pivo();
			pivo.setPvara(pivaraService.findOne(pivoDTO.getPivaraId()));
			pivo.setVrstaPiva(vrstaService.findOne(pivoDTO.getVrstaId()));
		} else {
			pivo = pivoService.findOne(pivoDTO.getId());
		}
		pivo.setPvara(pivaraService.findOne(pivoDTO.getPivaraId()));
		pivo.setVrstaPiva(vrstaService.findOne(pivoDTO.getVrstaId()));
		pivo.setIbu(pivoDTO.getIbu());
		pivo.setNaStanju(pivoDTO.getNaStanju());
		pivo.setNaziv(pivoDTO.getNaziv());
		pivo.setProcenatAlkohola(pivoDTO.getProcenatAlkohola());

		return pivo;
	}

}
