package samet.proje.projem.service.impl;

import java.util.List;
import java.util.Optional;

import samet.proje.projem.model.Gorev;

public interface Gorev_Servis_Impl {

	Optional<List<Gorev>> findByUsername(String Username);

	void deleteGorev(Gorev gorev);
	
	Gorev updateGorev(Gorev gorev);
	
	Gorev createNewGorev(Gorev gorev);

}
