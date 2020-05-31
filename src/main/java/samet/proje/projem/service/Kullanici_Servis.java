package samet.proje.projem.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import samet.proje.projem.model.Kullanici;
import samet.proje.projem.repository.Kullanici_Repo;
import samet.proje.projem.service.impl.Kullanici_Servis_Impl;
import samet.proje.projem.staticstuff.Principal;

@Service
public class Kullanici_Servis implements Kullanici_Servis_Impl {

	@Autowired
	Kullanici_Repo kullanicilarRepo;

	public int deleteUser(long gelenid) {
		kullanicilarRepo.deleteById(gelenid);
		return 1;
	}

	public Kullanici createUser(Kullanici kullanici) {
		kullanici.setEnabled(1);

		Date date = new Date();
		kullanici.setCreatedDate(date);
		kullanici.setUpdatedDate(date);

		kullanici.setCreatedBy(Principal.loggedInUser == null ? kullanici.getUsername() : Principal.loggedInUser.getUsername());
		kullanici.setUpdatedBy(Principal.loggedInUser == null ? kullanici.getUsername() : Principal.loggedInUser.getUsername());

		return kullanicilarRepo.save(kullanici);
	}

	public Optional<Kullanici> loginUser(Kullanici kullanici) {
		return kullanicilarRepo.findByUsername(kullanici.getUsername());
	}

}
