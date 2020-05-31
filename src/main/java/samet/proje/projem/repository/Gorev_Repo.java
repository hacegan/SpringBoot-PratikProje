package samet.proje.projem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import samet.proje.projem.model.Gorev;

public interface Gorev_Repo extends JpaRepository<Gorev, Long> {

	Optional<List<Gorev>> findByKulusername(String Username);

}
