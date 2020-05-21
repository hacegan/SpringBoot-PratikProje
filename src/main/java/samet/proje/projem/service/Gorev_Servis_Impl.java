package samet.proje.projem.service;

import java.util.Optional;

import samet.proje.projem.model.Gorev;

public interface Gorev_Servis_Impl {

	Optional<Gorev> findByUsername(String Username);

	void deleteGorev(Gorev gorev);
	
	Gorev updateGorev(Gorev gorev);

}
