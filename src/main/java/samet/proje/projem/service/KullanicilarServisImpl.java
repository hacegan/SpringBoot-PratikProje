package samet.proje.projem.service;

import java.util.Optional;

import samet.proje.projem.model.Kullanicilar;

public interface KullanicilarServisImpl {
	Kullanicilar createUser(Kullanicilar kullanici);
	Optional<Kullanicilar> loginUser(Kullanicilar kullanici);
}
