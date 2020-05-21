package samet.proje.projem.service;

import java.util.List;
import java.util.Optional;

import samet.proje.projem.dto.Sirket_Yapisi_DTO;
import samet.proje.projem.model.Kullanici_Detay;

public interface Kullanici_Detay_Servis_Impl {

	List<Sirket_Yapisi_DTO> getWorkers();

	Optional<Kullanici_Detay> getProfile();

	Kullanici_Detay updateProfile(Kullanici_Detay kullanici_Detay);

}
