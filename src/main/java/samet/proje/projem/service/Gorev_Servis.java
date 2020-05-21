package samet.proje.projem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import samet.proje.projem.model.Gorev;
import samet.proje.projem.repository.Gorev_Repo;

public class Gorev_Servis implements Gorev_Servis_Impl {

	@Autowired
	Gorev_Repo gorev_Repo;

	@Override
	public Optional<Gorev> findByUsername(String Username) {
		return gorev_Repo.findByUsername(Username);
	}

	@Override
	public void deleteGorev(Gorev gorev) {
		gorev_Repo.delete(gorev);
	}

	@Override
	public Gorev updateGorev(Gorev gorev) {
		return gorev_Repo.save(gorev);
	}

}
