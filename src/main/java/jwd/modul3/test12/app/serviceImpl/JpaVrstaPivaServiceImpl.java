package jwd.Modul3.Test12.app.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwd.Modul3.Test12.app.model.VrstaPiva;
import jwd.Modul3.Test12.app.repository.VrstaPivaRepository;
import jwd.Modul3.Test12.app.service.VrstaPivaService;

@Service
@Transactional
public class JpaVrstaPivaServiceImpl implements VrstaPivaService {
	@Autowired
	private VrstaPivaRepository vrstaRepository;

	@Override
	public List<VrstaPiva> findAll() {
		return vrstaRepository.findAll();
	}

	@Override
	public VrstaPiva findOne(Long id) {

		return vrstaRepository.findOne(id);
	}

	@Override
	public void save(VrstaPiva vrsta) {
		vrstaRepository.save(vrsta);
	}

	@Override
	public void remove(Long id) {
		vrstaRepository.delete(id);

	}

}
