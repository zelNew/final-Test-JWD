package jwd.Modul3.Test12.app.service;

import java.util.List;

import jwd.Modul3.Test12.app.model.VrstaPiva;

public interface VrstaPivaService {
	List<VrstaPiva> findAll();

	VrstaPiva findOne(Long id);

	void save(VrstaPiva vrsta);

	void remove(Long id);

}
