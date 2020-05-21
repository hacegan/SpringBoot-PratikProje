package samet.proje.projem.service;

import java.util.Optional;

import samet.proje.projem.model.Kullanici;

public interface Kullanici_Servis_Impl {
	Kullanici createUser(Kullanici kullanici);
	Optional<Kullanici> loginUser(Kullanici kullanici);
}
