package jwd.Modul3.Test12.app.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.Modul3.Test12.app.model.Pivara;
import jwd.Modul3.Test12.app.webDTO.PivaraDTO;

@Component

public class PivaraToPivaraDTO implements Converter<Pivara, PivaraDTO> {

	@Override
	public PivaraDTO convert(Pivara pivara) {
		PivaraDTO pivaraDTO = new PivaraDTO();

		pivaraDTO.setId(pivara.getId());
		pivaraDTO.setNaziv(pivara.getNaziv());
		pivaraDTO.setDrzava(pivara.getDrzava());
		pivaraDTO.setPib(pivara.getPib());
		return pivaraDTO;
	}

	public List<PivaraDTO> convert(List<Pivara> pivare) {
		List<PivaraDTO> ret = new ArrayList<>();

		for (Pivara p : pivare) {
			ret.add(convert(p));
		}

		return ret;
	}

}
