package samet.proje.projem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import samet.proje.projem.model.Calisan_Detay;

public interface CalisanDetay_Repo extends JpaRepository<Calisan_Detay, Long> {
	
	List<Calisan_Detay> findAllByGorevi(int id);

}
