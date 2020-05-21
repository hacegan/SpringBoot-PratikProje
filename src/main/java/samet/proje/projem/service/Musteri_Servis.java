package samet.proje.projem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import samet.proje.projem.model.Musteri;
import samet.proje.projem.repository.Musteri_Repo;

public class Musteri_Servis implements Musteri_Servis_Impl {

	@Autowired
	Musteri_Repo musteri_Repo;

	@Override
	public Optional<Musteri> getCustomers(String username) {
		return musteri_Repo.findByUsername(username);
	}

}
