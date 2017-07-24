package jwd.Modul3.Test12.app.webController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jwd.Modul3.Test12.app.service.VrstaPivaService;
import jwd.Modul3.Test12.app.support.VrstaPivaToVrstaPivoDTO;
import jwd.Modul3.Test12.app.webDTO.VrstaPivaDTO;

@RestController
@RequestMapping(value = "/api/vrste_piva")
public class ApiVrstePivaController {
	@Autowired
	private VrstaPivaService vrstaService;
	@Autowired
	private VrstaPivaToVrstaPivoDTO toDTO;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<VrstaPivaDTO>> get() {
		return new ResponseEntity<>(toDTO.convert(vrstaService.findAll()), HttpStatus.OK);
	}

}
