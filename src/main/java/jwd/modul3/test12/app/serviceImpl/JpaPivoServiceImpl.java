package jwd.Modul3.Test12.app.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jwd.Modul3.Test12.app.model.Pivo;
import jwd.Modul3.Test12.app.repository.PivoRepository;
import jwd.Modul3.Test12.app.service.PivoService;

@Service
@Transactional
public class JpaPivoServiceImpl implements PivoService {
	@Autowired
	private PivoRepository pivoRepository;

	@Override
	public Page<Pivo> findAll(int pageNum) {
		return pivoRepository.findAll(new PageRequest(pageNum, 2));
	}

	@Override
	public Pivo findOne(Long id) {
		return pivoRepository.findOne(id);
	}

	@Override
	public void save(Pivo pivo) {
		pivoRepository.save(pivo);

	}

	@Override
	public void remove(Long id) {
		pivoRepository.delete(id);

	}

	@Override
	public Page<Pivo> findByPivaraId(int pageNum, Long pivoId) {

		return pivoRepository.findByPivaraId(pivoId, new PageRequest(pageNum, 2));
	}

	@Override
	public Page<Pivo> pretraga(String naziv, Double minIBU, Double maxIBU, String nazivPivare, Integer nemaNaStanju, int page) {
		if (naziv != null && nazivPivare != null) {
			naziv = "%" + naziv + "%";
			nazivPivare = "%" + nazivPivare + "%";
		}
		return pivoRepository.pretraga(naziv, minIBU, maxIBU, nazivPivare, nemaNaStanju, new PageRequest(page, 2));
	}

}
