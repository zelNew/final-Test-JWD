package jwd.Modul3.Test12.app.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.Modul3.Test12.app.model.VrstaPiva;
import jwd.Modul3.Test12.app.webDTO.VrstaPivaDTO;

@Component
public class VrstaPivaToVrstaPivoDTO implements Converter<VrstaPiva, VrstaPivaDTO> {

	@Override
	public VrstaPivaDTO convert(VrstaPiva vrsta) {
		VrstaPivaDTO vDTO = new VrstaPivaDTO();
		vDTO.setId(vrsta.getId());
		vDTO.setNaziv(vrsta.getNaziv());

		return vDTO;
	}

	public List<VrstaPivaDTO> convert(List<VrstaPiva> vrste) {
		List<VrstaPivaDTO> ret = new ArrayList<>();

		for (VrstaPiva vp : vrste) {
			ret.add(convert(vp));
		}

		return ret;
	}

}
