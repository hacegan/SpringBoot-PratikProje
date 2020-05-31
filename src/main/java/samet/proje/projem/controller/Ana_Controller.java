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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import samet.proje.projem.dto.Kullanici_Detay_DTO;
import samet.proje.projem.dto.Sirket_Yapisi_DTO;
import samet.proje.projem.model.Gorev;
import samet.proje.projem.model.Kullanici;
import samet.proje.projem.model.Kullanici_Detay;
import samet.proje.projem.model.Musteri;
import samet.proje.projem.model.Urun;
import samet.proje.projem.model.Varlik;
import samet.proje.projem.service.Gorev_Servis;
import samet.proje.projem.service.Kullanici_Detay_Servis;
import samet.proje.projem.service.Kullanici_Servis;
import samet.proje.projem.service.Musteri_Servis;
import samet.proje.projem.service.Urun_Servis;
import samet.proje.projem.service.Varlik_Servis;
import samet.proje.projem.staticstuff.Principal;

/**
 * Uygulamamızın ilk ana controller yapısı buradan servislerimiz araclıgıyla db
 * islemlerimizi gerceklestiriyoruz
 * 
 * @author samet
 *
 */

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

	@Autowired
	Urun_Servis urun_Servis;

	@Autowired
	Varlik_Servis varlik_Servis;

	@GetMapping("/varliklar") // varliklari getiriyoruz
	public ResponseEntity<List<Varlik>> getAssets() {
		Optional<List<Varlik>> varliklar = varlik_Servis.getAssets();
		return varliklar.isPresent() ? ResponseEntity.ok(varliklar.get()) : ResponseEntity.notFound().build();
	}

	@PostMapping("/varliklar") // varlik ekliyoruz
	public ResponseEntity<List<Varlik>> addAsset(@RequestBody Varlik varlik) {
		varlik_Servis.addAsset(varlik);
		return getAssets();
	}

	@PutMapping("/varliklar") // varlik guncelliyoruz
	public ResponseEntity<List<Varlik>> updateAsset(@RequestBody Varlik varlik) {
		varlik_Servis.updateAsset(varlik);
		return getAssets();
	}

	@DeleteMapping("/varliklar") // varlik siliyloruz
	public ResponseEntity<List<Varlik>> deleteAsset(@RequestBody Varlik varlik) {
		varlik_Servis.deleteAsset(varlik);
		return getAssets();
	}

	@GetMapping("/urunler")
	public ResponseEntity<List<Urun>> getProducts() {// ürünlerimizi getiriyoruz
		Optional<List<Urun>> urunler = urun_Servis.getProducts();
		return urunler.isPresent() ? ResponseEntity.ok(urunler.get()) : ResponseEntity.notFound().build();
	}

	@PostMapping("/urunler") // ürün ekliyoruz
	public ResponseEntity<List<Urun>> addProduct(@RequestParam Urun urun) {
		urun_Servis.saveProduct(urun);
		return getProducts();
	}

	@PutMapping("/urunler") // urun guncelliyoruz
	public ResponseEntity<List<Urun>> updateProduct(@RequestParam Urun urun) {
		urun_Servis.updateProduct(urun);
		return getProducts();
	}

	@DeleteMapping("/urunler") // urun siliyoruz
	public ResponseEntity<List<Urun>> deleteProduct(Urun urun) {
		urun_Servis.deleteProduct(urun);
		return getProducts();
	}

	@GetMapping("/musteriler") // musterilerimizi getiriyoruz
	public ResponseEntity<List<Musteri>> getCustomers(
			@RequestParam(defaultValue = "0", required = false) Integer pageNo,
			@RequestParam(defaultValue = "10", required = false) Integer pageSize,
			@RequestParam(defaultValue = "id", required = false) String sortBy) {
		Optional<List<Musteri>> musteri = musteri_Servis.getCustomers(Principal.loggedInUser.getUsername(), pageNo,
				pageSize, sortBy);
		return musteri.isPresent() ? ResponseEntity.ok(musteri.get()) : ResponseEntity.notFound().build();
	}

	@PostMapping("/musteriler") // musterilerimizi ekliyoruz
	public ResponseEntity<List<Musteri>> addCustomer(@RequestBody Musteri musteri) {
		musteri_Servis.addCustomer(musteri);
		return getCustomers();
	}

	@PutMapping("/musteriler") // musterilerimizi guncelliyoruz
	public ResponseEntity<List<Musteri>> updateCustomer(@RequestBody Musteri musteri) {
		musteri_Servis.updateCustomer(musteri);
		return getCustomers();
	}

	@DeleteMapping("/musteriler") // musteri siliyoruz
	public ResponseEntity<List<Musteri>> deleteCustomer(@RequestBody Musteri musteri) {
		musteri_Servis.deleteCustomer(musteri);
		return getCustomers();
	}

	@GetMapping("/gorevler") // giris yapan kullanicinin gorevlerini getiriyoruz
	public ResponseEntity<List<Gorev>> getTasks() {
		Optional<List<Gorev>> tasks = gorevServis.findByUsername(Principal.loggedInUser.getUsername());
		return tasks.isPresent() ? ResponseEntity.ok(tasks.get()) : ResponseEntity.noContent().build();
	}

	@DeleteMapping("/gorevler") // gorev silme islemi
	public ResponseEntity<List<Gorev>> deleteTask(Gorev gorev) {
		gorevServis.deleteGorev(gorev);
		return getTasks();
	}

	@PostMapping("/gorevler") // gorev ekleme islemi
	public ResponseEntity<List<Gorev>> createNewTask(@RequestBody Gorev gorev) {
		gorev.setKulusername(Principal.loggedInUser.getUsername());
		gorevServis.createNewGorev(gorev);
		return getTasks();
	}

	@PutMapping("/gorevler") // gorev guncelleme islemi
	public ResponseEntity<List<Gorev>> updateTask(@RequestBody Gorev gorev) {
		gorevServis.updateGorev(gorev);
		return getTasks();
	}

	@GetMapping("/profil") // giris yapan kullanicinin profilini getiriyoruz
	public ResponseEntity<Kullanici_Detay> getProfile() {
		Optional<Kullanici_Detay> profil = kullanici_Detay_Servis.getProfile();
		return profil.isPresent() ? ResponseEntity.ok(profil.get()) : ResponseEntity.noContent().build();
	}

	@PutMapping("/profil") // profili güncelliyoruz
	public ResponseEntity<Kullanici_Detay> getUpdatedProfile(@RequestBody Kullanici_Detay kullanici_Detay) {

		// eğer kullanıcı yeni kayıt edildiyse
		// profilini güncelledigimizde
		// kul_adınıda ekliyoruzki sonra
		// istedigimizde ulasabilelim.
		if (kullanici_Detay.getKulusername() == null) {
			kullanici_Detay.setKulusername(Principal.loggedInUser.getUsername());
		}

		System.out.println("girdi****");

		return ResponseEntity.ok(kullanici_Detay_Servis.updateProfile(kullanici_Detay));
	}

	@GetMapping("/sirket_yapisi") // tüm sirket yapisini kim sirkette hangi pozisyonda onu getiriyoruz.
	public ResponseEntity<List<Sirket_Yapisi_DTO>> getWorkers() {
		return ResponseEntity.ok(kullanici_Detay_Servis.getWorkers());
	}

	@PostMapping("/kayitol")
	public ResponseEntity<Kullanici> createUser(@RequestBody Kullanici kullanici) {
		Kullanici kul = kullaniciServis.createUser(kullanici);
		Principal.loggedInUser = kul;
		return ResponseEntity.ok(kul);
	}

	@PostMapping("/girisyap")
	public ResponseEntity<Kullanici> loginUser(@RequestBody Kullanici kullanici) {
		Optional<Kullanici> kullar = kullaniciServis.loginUser(kullanici);
		Principal.loggedInUser = kullar.get();
		return kullar.isPresent() ? ResponseEntity.ok(kullar.get()) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<Kullanici> deleteUser(@PathVariable(name = "id") int gelenid) {
		kullaniciServis.deleteUser(gelenid);
		return ResponseEntity.ok().build();
	}

}
