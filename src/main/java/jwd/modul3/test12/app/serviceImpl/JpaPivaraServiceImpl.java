package jwd.Modul3.Test12.app.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwd.Modul3.Test12.app.model.Pivara;
import jwd.Modul3.Test12.app.repository.PivaraRepository;
import jwd.Modul3.Test12.app.service.PivaraService;

@Service
@Transactional
public class JpaPivaraServiceImpl implements PivaraService {
	@Autowired
	private PivaraRepository pivaraReository;

	@Override
	public List<Pivara> findAll() {
		return pivaraReository.findAll();
	}

	@Override
	public Pivara findOne(Long id) {
		return pivaraReository.findOne(id);
	}

	@Override
	public void save(Pivara pivara) {
		pivaraReository.save(pivara);

	}

	@Override
	public void remove(Long id) {
		pivaraReository.delete(id);

	}

}
