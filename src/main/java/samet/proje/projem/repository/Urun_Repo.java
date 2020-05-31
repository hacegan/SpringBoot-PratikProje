package samet.proje.projem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import samet.proje.projem.model.Urun;

public interface Urun_Repo extends JpaRepository<Urun, Long> {

	Optional<List<Urun>> findByKulusername(String username);

}
