package samet.proje.projem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import samet.proje.projem.model.Varlik;
import samet.proje.projem.repository.Varlik_Repo;
import samet.proje.projem.service.impl.Varlik_Servis_Impl;
import samet.proje.projem.staticstuff.Principal;

@Service
public class Varlik_Servis implements Varlik_Servis_Impl {

	@Autowired
	Varlik_Repo varlik_Repo;

	@Override
	public Optional<List<Varlik>> getAssets() {
		return varlik_Repo.findByKulusername(Principal.loggedInUser.getUsername());
	}

	@Override
	public Varlik addAsset(Varlik varlik) {
		return varlik_Repo.save(varlik);
	}

	@Override
	public Varlik updateAsset(Varlik varlik) {
		return varlik_Repo.save(varlik);
	}

	@Override
	public void deleteAsset(Varlik varlik) {
		varlik_Repo.delete(varlik);
	}

}
