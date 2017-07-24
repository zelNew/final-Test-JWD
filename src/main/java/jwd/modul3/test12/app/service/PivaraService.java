package jwd.Modul3.Test12.app.service;

import java.util.List;

import jwd.Modul3.Test12.app.model.Pivara;

public interface PivaraService {
	List<Pivara> findAll();

	Pivara findOne(Long id);

	void save(Pivara pivara);

	void remove(Long id);

}
