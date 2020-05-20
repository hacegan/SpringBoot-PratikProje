package samet.proje.projem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import samet.proje.projem.model.Kullanicilar;

public interface KullanicilarRepo extends JpaRepository<Kullanicilar, Long> {

	Optional<Kullanicilar> findByUsername(String userName);

}
