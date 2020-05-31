package samet.proje.projem.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import samet.proje.projem.model.Musteri;

public interface Musteri_Repo extends JpaRepository<Musteri, Long> {

	Page<Musteri> findByKulusername(String Username, Pageable pageable);

}
