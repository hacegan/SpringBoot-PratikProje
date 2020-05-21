package samet.proje.projem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import samet.proje.projem.model.Kullanici;

public interface Kullanici_Repo extends JpaRepository<Kullanici, Long> {

	Optional<Kullanici> findByUsername(String username);

}
