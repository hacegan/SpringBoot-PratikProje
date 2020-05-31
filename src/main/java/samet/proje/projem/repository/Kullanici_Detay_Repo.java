package samet.proje.projem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import samet.proje.projem.model.Kullanici_Detay;

public interface Kullanici_Detay_Repo extends JpaRepository<Kullanici_Detay, Long> {
	
	List<Kullanici_Detay> findAllByGorevi(int id);
	
	Optional<Kullanici_Detay> findByKulusername(String username);
	
}
