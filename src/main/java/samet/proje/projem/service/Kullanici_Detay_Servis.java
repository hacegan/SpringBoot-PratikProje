package samet.proje.projem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import samet.proje.projem.dto.Sirket_Yapisi_DTO;
import samet.proje.projem.enums.Kullanici_Pozisyon_Enum;
import samet.proje.projem.model.Kullanici_Detay;
import samet.proje.projem.model.Sirket_Yapisi;
import samet.proje.projem.repository.Kullanici_Detay_Repo;
import samet.proje.projem.repository.Sirket_Yapisi_Repo;
import samet.proje.projem.service.impl.Kullanici_Detay_Servis_Impl;
import samet.proje.projem.staticstuff.Principal;

@Service
public class Kullanici_Detay_Servis implements Kullanici_Detay_Servis_Impl {

	@Autowired
	Kullanici_Detay_Repo kullanici_Detay_Repo;

	@Autowired
	Sirket_Yapisi_Repo gorevRepo;

	List<Sirket_Yapisi> listGorev;

	List<Kullanici_Detay> listCalisanDetay;

	List<Sirket_Yapisi_DTO> listCalisanDTO = new ArrayList<Sirket_Yapisi_DTO>();
	List<Integer> toDelete = new ArrayList<Integer>();
	List<Sirket_Yapisi_DTO> toRemove = new ArrayList<Sirket_Yapisi_DTO>();
	List<Sirket_Yapisi_DTO> tempList = new ArrayList<Sirket_Yapisi_DTO>();
	Sirket_Yapisi_DTO.Data data = new Sirket_Yapisi_DTO().getData();

	public List<Sirket_Yapisi_DTO> getWorkers() {
		listCalisanDTO = new ArrayList<Sirket_Yapisi_DTO>();
		listGorev = gorevRepo.findAll();
		listCalisanDetay = kullanici_Detay_Repo.findAll();

		for (int i = 0; i < listCalisanDetay.size(); i++) {

			listCalisanDTO.add(
					new Sirket_Yapisi_DTO(Kullanici_Pozisyon_Enum.getById(listCalisanDetay.get(i).getGorevi()).name(), // label
							new Sirket_Yapisi_DTO().new Data(
									listCalisanDetay.get(i).getAdi() + " " + listCalisanDetay.get(i).getSoyadi(), null), // data
							new ArrayList<Sirket_Yapisi_DTO>()// children
							, listCalisanDetay.get(i).getGorevi()));// idalan
		}
		for (int i = 0; i < listGorev.size(); i++) {

			if (listGorev.get(i).getChild_nodes() != null) {// child nodeları bulup parentlara ekledik sonra silinmek
															// üzere kaydettik cünkü concurrent hatası alıyoruz
				String[] childs = listGorev.get(i).getChild_nodes().split(",");
				for (int j = 0; j < childs.length; j++) {
					listCalisanDTO.get((int) listGorev.get(i).getId() - 1).getChildren()
							.add(listCalisanDTO.get(Integer.valueOf(childs[j]) - 1));
					listCalisanDTO.get((int) listGorev.get(i).getId() - 1).setExpanded(true);
					toDelete.add(Integer.valueOf(childs[j]) - 1);
				}
			}

			listCalisanDTO.get((int) listGorev.get(i).getId() - 1).setType("person");
			listCalisanDTO.get((int) listGorev.get(i).getId() - 1).getData().setAvatar(listGorev.get(i).getImg_loc());

			listCalisanDTO.removeIf((calisan) -> toDelete.contains(calisan.getIdalan()));// silinmesi gerekenleri sildik

			listCalisanDTO.forEach((calisan) -> {// hepsini tek bir json objesine dönüstürdük yani fazlalık kayıtları
													// sildik cünkü onlar zaten parentlarının childı oldular.
				if (calisan.getIdalan() > 1) {
					toRemove.add(calisan);
				}
			});
		}

		listCalisanDTO.removeAll(toRemove);

		tempList = listCalisanDTO.get(0).getChildren().get(0).getChildren();

		tempList.forEach((tempVar) -> {
			tempVar.setType(null);
			tempVar.getData().setAvatar("");
		});

		tempList.get(0).setLabel(Kullanici_Pozisyon_Enum.getById(3).name());
		tempList.get(1).setLabel(Kullanici_Pozisyon_Enum.getById(4).name());
		tempList.get(2).setLabel(Kullanici_Pozisyon_Enum.getById(5).name());
		tempList.get(3).setLabel(Kullanici_Pozisyon_Enum.getById(6).name());
		tempList.get(4).setLabel(Kullanici_Pozisyon_Enum.getById(7).name());

		return listCalisanDTO;
	}

	@Override
	public Optional<Kullanici_Detay> getProfile() {
		return kullanici_Detay_Repo.findByKulusername(Principal.loggedInUser.getUsername());
	}

	@Override
	public Kullanici_Detay updateProfile(Kullanici_Detay kullanici_Detay) {
		return kullanici_Detay_Repo.save(kullanici_Detay);
	}

}
