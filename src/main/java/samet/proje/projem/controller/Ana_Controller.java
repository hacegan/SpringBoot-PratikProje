package samet.proje.projem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import samet.proje.projem.dto.Sirket_Yapisi_DTO;
import samet.proje.projem.model.Gorev;
import samet.proje.projem.model.Kullanici;
import samet.proje.projem.model.Kullanici_Detay;
import samet.proje.projem.model.Musteri;
import samet.proje.projem.service.Gorev_Servis;
import samet.proje.projem.service.Kullanici_Detay_Servis;
import samet.proje.projem.service.Kullanici_Servis;
import samet.proje.projem.service.Musteri_Servis;

@RestController
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Ana_Controller {

	@Autowired
	Kullanici_Servis kullaniciServis;

	@Autowired
	Kullanici_Detay_Servis kullanici_Detay_Servis;

	@Autowired
	Gorev_Servis gorevServis;

	@Autowired
	Musteri_Servis musteri_Servis;

	@GetMapping("/musteriler") // musterilerimizi getiriyoruz
	public ResponseEntity<Musteri> getCustomers() {
	Musteri	musteri_Servis.getCustomers("test1")
		return ResponseEntity.ok()			;
	}

	@GetMapping("/gorevler") // giris yapan kullanicinin gorevlerini getiriyoruz
	public ResponseEntity<Gorev> getTasks() {
		Optional<Gorev> tasks = gorevServis.findByUsername("test1");
		return tasks.isPresent() ? ResponseEntity.ok(tasks.get()) : ResponseEntity.noContent().build();
	}

	@DeleteMapping("/gorevler") // gorev silme islemi
	public ResponseEntity<Gorev> deleteTask(Gorev gorev) {
		gorevServis.deleteGorev(gorev);
		return getTasks();
	}

	@PostMapping("/gorevler") // gorev guncelleme islemi
	public ResponseEntity<Gorev> updateTask(Gorev gorev) {
		return ResponseEntity.ok(gorevServis.updateGorev(gorev));
	}

	@GetMapping("/profil") // giris yapan kullanicinin profilini getiriyoruz
	public ResponseEntity<Kullanici_Detay> getProfile() {
		Optional<Kullanici_Detay> profil = kullanici_Detay_Servis.getProfile();
		return profil.isPresent() ? ResponseEntity.ok(profil.get()) : ResponseEntity.noContent().build();
	}

	@PostMapping("/profil") // profili güncelliyoruz
	public ResponseEntity<Kullanici_Detay> getUpdatedProfile(@RequestBody Kullanici_Detay kullanici_Detay) {
		kullanici_Detay.setKul_username("test1");
		return ResponseEntity.ok(kullanici_Detay_Servis.updateProfile(kullanici_Detay));
	}

	@GetMapping("/calisanlar") // tüm sirket yapisini kim sirkette hangi pozisyonda onu getiriyoruz.
	public ResponseEntity<List<Sirket_Yapisi_DTO>> getWorkers() {
		return ResponseEntity.ok(kullanici_Detay_Servis.getWorkers());
	}

	@PostMapping("/kayitol")
	public ResponseEntity<Kullanici> createUser(@RequestBody Kullanici kullanici) {
		Kullanici kul = kullaniciServis.createUser(kullanici);
		return ResponseEntity.ok(kul);
	}

	@PostMapping("/girisyap")
	public ResponseEntity<Kullanici> loginUser(@RequestBody Kullanici kullanici) {

		System.out.println(kullanici.getUsername() + kullanici.getUser_password());
		Optional<Kullanici> kullar = kullaniciServis.loginUser(kullanici);
		System.out.println(kullar.isPresent());
		return kullar.isPresent() ? ResponseEntity.ok(kullar.get()) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<Kullanici> deleteUser(@PathVariable(name = "id") int gelenid) {
		kullaniciServis.deleteUser(gelenid);
		return ResponseEntity.ok().build();
	}

}
