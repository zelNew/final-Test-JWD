package jwd.Modul3.Test12.app.webController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwd.Modul3.Test12.app.model.Pivo;
import jwd.Modul3.Test12.app.service.PivoService;
import jwd.Modul3.Test12.app.support.PivoDtoTOPivo;
import jwd.Modul3.Test12.app.support.PivoToPivoDTO;
import jwd.Modul3.Test12.app.webDTO.PivoDTO;

@RestController
@RequestMapping("/api/piva")
public class ApiPivoController {
	@Autowired
	private PivoService pivoService;
	@Autowired
	private PivoToPivoDTO toDTO;
	@Autowired
	private PivoDtoTOPivo toPivo;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PivoDTO>> get(@RequestParam(required = false) String naziv,
			@RequestParam(required = false) Double minIBU, @RequestParam(required = false) Double maxIBU,
			@RequestParam(required = false) String nazivPivare,@RequestParam(required = false) Integer nemaNaStanju, @RequestParam(defaultValue = "0") int pageNum) {

		Page<Pivo> piva;

		if (naziv != null || minIBU != null || maxIBU != null || nazivPivare != null || nemaNaStanju != null) {
			piva = pivoService.pretraga(naziv, minIBU, maxIBU, nazivPivare, nemaNaStanju, pageNum);
		} else {
			piva = pivoService.findAll(pageNum);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(piva.getTotalPages()));

		return new ResponseEntity<>(toDTO.convert(piva.getContent()), headers, HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<PivoDTO> get(@PathVariable Long id) {
		Pivo pivo = pivoService.findOne(id);
		if (pivo == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(toDTO.convert(pivo), HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<PivoDTO> add(@RequestBody PivoDTO novoPivo) {
		Pivo pivo = toPivo.convert(novoPivo);
		pivoService.save(pivo);

		return new ResponseEntity<>(toDTO.convert(pivo), HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes="application/json")
	public ResponseEntity<PivoDTO> edit(@PathVariable Long id, @RequestBody PivoDTO pdto) {

		if (!id.equals(pdto.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Pivo pivo = toPivo.convert(pdto);
		pivoService.save(pivo);

		return new ResponseEntity<>(toDTO.convert(pivo), HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<PivoDTO> delete(@PathVariable Long id) {
		pivoService.remove(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
