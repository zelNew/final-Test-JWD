package jwd.Modul3.Test12.app.webController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwd.Modul3.Test12.app.model.Pivara;
import jwd.Modul3.Test12.app.model.Pivo;
import jwd.Modul3.Test12.app.service.PivaraService;
import jwd.Modul3.Test12.app.service.PivoService;
import jwd.Modul3.Test12.app.support.PivaraToPivaraDTO;
import jwd.Modul3.Test12.app.support.PivoToPivoDTO;
import jwd.Modul3.Test12.app.webDTO.PivaraDTO;
import jwd.Modul3.Test12.app.webDTO.PivoDTO;

@RestController
@RequestMapping(value = "/api/pivare")
public class ApiPivaraController {
	@Autowired
	private PivaraService pivaraService;
	@Autowired
	private PivoService pivoService;
	@Autowired
	private PivaraToPivaraDTO toDTO;
	@Autowired
	private PivoToPivoDTO pivoToDTO;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PivaraDTO>> get() {
		return new ResponseEntity<>(toDTO.convert(pivaraService.findAll()), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<PivaraDTO> get(@PathVariable Long id) {
		Pivara pivara = pivaraService.findOne(id);
		if (pivara == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(toDTO.convert(pivara), HttpStatus.OK);
	}

	@RequestMapping(value = "/{pivaraId}/piva")
	public ResponseEntity<List<PivoDTO>> getPivaPivare(@PathVariable Long pivaraId,
			@RequestParam(defaultValue = "0") int pageNum) {
		Page<Pivo> piva = pivoService.findByPivaraId(pageNum, pivaraId);

		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(piva.getTotalPages()));

		return new ResponseEntity<>(pivoToDTO.convert(piva.getContent()), headers, HttpStatus.OK);

	}

}
