package samet.proje.projem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import samet.proje.projem.model.Urun;
import samet.proje.projem.repository.Urun_Repo;
import samet.proje.projem.service.impl.Urun_Servis_Impl;
import samet.proje.projem.staticstuff.Principal;

@Service
public class Urun_Servis implements Urun_Servis_Impl {

	@Autowired
	Urun_Repo urun_Repo;

	@Override
	public Optional<List<Urun>> getProducts() {
		return urun_Repo.findByKulusername(Principal.loggedInUser.getUsername());
	}

	@Override
	public Urun saveProduct(Urun urun) {
		return urun_Repo.save(urun);
	}

	@Override
	public void deleteProduct(Urun urun) {
		urun_Repo.delete(urun);
	}

	@Override
	public Urun updateProduct(Urun urun) {
		return urun_Repo.save(urun);
	}

}
