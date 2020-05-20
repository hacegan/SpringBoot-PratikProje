package samet.proje.projem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import samet.proje.projem.dto.CalisanlarDTO;
import samet.proje.projem.enums.EmployeePos_Enum;
import samet.proje.projem.model.Calisan_Detay;
import samet.proje.projem.model.Gorev;
import samet.proje.projem.repository.CalisanDetay_Repo;
import samet.proje.projem.repository.GorevRepo;

@Service
public class CalisanDetayServis implements CalisanServisImpl {

	@Autowired
	CalisanDetay_Repo calisanDetay_Repo;

	@Autowired
	GorevRepo gorevRepo;

	List<Gorev> listGorev;

	List<Calisan_Detay> listCalisanDetay;

	List<CalisanlarDTO> listCalisanDTO = new ArrayList<CalisanlarDTO>();
	List<Integer> toDelete = new ArrayList<Integer>();
	List<CalisanlarDTO> toRemove = new ArrayList<CalisanlarDTO>();
	List<CalisanlarDTO> tempList = new ArrayList<CalisanlarDTO>();
	CalisanlarDTO.Data data = new CalisanlarDTO().getData();

	public List<CalisanlarDTO> getWorkers() {
		listCalisanDTO = new ArrayList<CalisanlarDTO>();
		listGorev = gorevRepo.findAll();
		listCalisanDetay = calisanDetay_Repo.findAll();

		for (int i = 0; i < listCalisanDetay.size(); i++) {

			listCalisanDTO.add(new CalisanlarDTO(EmployeePos_Enum.getById(listCalisanDetay.get(i).getGorevi()).name(), // label
					new CalisanlarDTO().new Data(
							listCalisanDetay.get(i).getAdi() + " " + listCalisanDetay.get(i).getSoyadi(), null), // data
					new ArrayList<CalisanlarDTO>()// children
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
			listCalisanDTO.get((int) listGorev.get(i).getId() - 1).getData()
					.setAvatar(listGorev.get(i).getImg_loc());

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

		tempList.get(0).setLabel(EmployeePos_Enum.getById(3).name());
		tempList.get(1).setLabel(EmployeePos_Enum.getById(4).name());
		tempList.get(2).setLabel(EmployeePos_Enum.getById(5).name());
		tempList.get(3).setLabel(EmployeePos_Enum.getById(6).name());
		tempList.get(4).setLabel(EmployeePos_Enum.getById(7).name());

		return listCalisanDTO;
	}

}
