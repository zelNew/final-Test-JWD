package jwd.Modul3.Test12.app.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.Modul3.Test12.app.model.Pivo;
import jwd.Modul3.Test12.app.webDTO.PivoDTO;

@Component
public class PivoToPivoDTO implements Converter<Pivo, PivoDTO> {

	@Override
	public PivoDTO convert(Pivo pivo) {
		PivoDTO pivoDTO = new PivoDTO();
		pivoDTO.setId(pivo.getId());
		pivoDTO.setIbu(pivo.getIbu());
		pivoDTO.setNaStanju(pivo.getNaStanju());
		pivoDTO.setNaziv(pivo.getNaziv());
		pivoDTO.setPivaraId(pivo.getPvara().getId());
		pivoDTO.setPivaraNaziv(pivo.getPvara().getNaziv());
		pivoDTO.setProcenatAlkohola(pivo.getProcenatAlkohola());
		pivoDTO.setVrstaId(pivo.getVrstaPiva().getId());
		pivoDTO.setVrstaNaziv(pivo.getVrstaPiva().getNaziv());

		return pivoDTO;
	}

	public List<PivoDTO> convert(List<Pivo> piva) {
		List<PivoDTO> ret = new ArrayList<>();

		for (Pivo p : piva) {
			ret.add(convert(p));
		}

		return ret;
	}

}
