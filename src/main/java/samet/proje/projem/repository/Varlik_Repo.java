package samet.proje.projem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import samet.proje.projem.model.Varlik;

public interface Varlik_Repo extends JpaRepository<Varlik, Long> {
	
	Optional<List<Varlik>> findByKulusername(String username);

}
