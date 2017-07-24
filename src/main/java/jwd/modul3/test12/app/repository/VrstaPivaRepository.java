package jwd.Modul3.Test12.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jwd.Modul3.Test12.app.model.VrstaPiva;
@Repository
public interface VrstaPivaRepository extends JpaRepository<VrstaPiva, Long> {

}
