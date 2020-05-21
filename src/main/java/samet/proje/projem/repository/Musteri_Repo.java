package samet.proje.projem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import samet.proje.projem.model.Musteri;

public interface Musteri_Repo extends JpaRepository<Musteri, Long> {

	Optional<Musteri> findByUsername(String Username);
	
}
