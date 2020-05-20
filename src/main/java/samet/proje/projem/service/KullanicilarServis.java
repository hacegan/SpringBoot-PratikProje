package samet.proje.projem.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import samet.proje.projem.model.Kullanicilar;
import samet.proje.projem.repository.KullanicilarRepo;
import samet.proje.projem.staticstuff.Principal;

@Service
public class KullanicilarServis implements KullanicilarServisImpl {

	@Autowired
	KullanicilarRepo kullanicilarRepo;

	public int deleteUser(long gelenid) {
		kullanicilarRepo.deleteById(gelenid);
		return 1;
	}

	public Kullanicilar createUser(Kullanicilar kullanici) {
		kullanici.setEnabled(1);

		Date date = new Date();
		kullanici.setCreatedDate(date);
		kullanici.setUpdatedDate(date);

		kullanici.setCreatedBy(
				Principal.currentUserName.isBlank() ? kullanici.getUsername() : Principal.currentUserName);
		kullanici.setUpdatedBy(
				Principal.currentUserName.isBlank() ? kullanici.getUsername() : Principal.currentUserName);

		return kullanicilarRepo.save(kullanici);
	}

	public Optional<Kullanicilar> loginUser(Kullanicilar kullanici) {
		return kullanicilarRepo.findByUsername(kullanici.getUsername());
	}

}
