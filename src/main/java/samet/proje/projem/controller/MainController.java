package samet.proje.projem.controller;

import java.net.URI;
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
import samet.proje.projem.dto.CalisanlarDTO;
import samet.proje.projem.model.Kullanicilar;
import samet.proje.projem.service.CalisanDetayServis;
import samet.proje.projem.service.KullanicilarServis;

@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class MainController {

	@Autowired
	KullanicilarServis kullaniciServis;

	@Autowired
	CalisanDetayServis calisanDetayServis;

	@GetMapping("/calisanlar")
	public ResponseEntity<List<CalisanlarDTO>> getWorkers() {
		return ResponseEntity.ok(calisanDetayServis.getWorkers());
	}

	@PostMapping("/kayitol")
	public ResponseEntity<Kullanicilar> createUser(@RequestBody Kullanicilar kullanici) {
		Kullanicilar kul = kullaniciServis.createUser(kullanici);
		System.out.println("kulid" + kul.getId());
		URI location = URI.create("/calisanlar/" + kul.getId());
		return ResponseEntity.created(location).build();
	}

	@PostMapping("/girisyap")
	public ResponseEntity<Kullanicilar> loginUser(@RequestBody Kullanicilar kullanici) {
		Optional<Kullanicilar> kullar = kullaniciServis.loginUser(kullanici);
		return kullar.isPresent() ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<Kullanicilar> deleteUser(@PathVariable(name = "id") int gelenid) {
		kullaniciServis.deleteUser(gelenid);
		return ResponseEntity.ok().build();
	}

}
