package samet.proje.projem.service;

import java.util.Optional;

import samet.proje.projem.model.Musteri;

public interface Musteri_Servis_Impl {

	Optional<Musteri> getCustomers(String username);
}
