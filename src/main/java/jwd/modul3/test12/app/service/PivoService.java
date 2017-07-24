package jwd.Modul3.Test12.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import jwd.Modul3.Test12.app.model.Pivo;



public interface PivoService {
	Page<Pivo> findAll(int pageNum);

	Pivo findOne(Long id);

	void save(Pivo pivo);

	void remove(Long id);

	Page<Pivo> findByPivaraId(int pageNum, Long pivoId);
	
	Page<Pivo> pretraga(
			@Param("naziv") String naziv, 
			@Param("minIBU") Double minIBU,
			@Param("maxIBU") Double maxIBU, 
			@Param("nazivPivare") String nazivPivare, 
			@Param("nemaNaStanju") Integer nemaNaStanju,
			int page);

}
