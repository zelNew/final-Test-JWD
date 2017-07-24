package jwd.Modul3.Test12.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jwd.Modul3.Test12.app.model.Pivo;

@Repository
public interface PivoRepository extends JpaRepository<Pivo, Long> {
	Page<Pivo> findByPivaraId(Long pivoId,  Pageable pageRequest);
	
	
	@Query("SELECT p FROM Pivo p WHERE"
			+ "(:naziv IS NULL OR p.naziv LIKE :naziv) AND"
			+ "(:minIBU IS NULL OR p.ibu >= :minIBU) AND"
			+ "(:maxIBU IS NULL OR p.ibu <= :maxIBU) AND"
			+ "(:nazivPivare IS NULL OR p.pivara.naziv LIKE :nazivPivare) AND"
			+ "(:nemaNaStanju IS NULL OR p.naStanju = :nemaNaStanju)"
			)
	Page<Pivo> pretraga(
			@Param("naziv") String naziv, 
			@Param("minIBU") Double minIBU,
			@Param("maxIBU") Double maxIBU, 
			@Param("nazivPivare") String nazivPivare,
			@Param("nemaNaStanju") Integer nemaNaStanju,
			Pageable pageRequest);

}
