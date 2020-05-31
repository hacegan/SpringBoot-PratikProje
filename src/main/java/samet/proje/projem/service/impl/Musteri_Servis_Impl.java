package samet.proje.projem.service.impl;

import java.util.List;
import java.util.Optional;

import samet.proje.projem.model.Musteri;

public interface Musteri_Servis_Impl {

	List<Musteri> getCustomers(String username, Integer pageNo, Integer pageSize, String sortBy);

	Musteri addCustomer(Musteri musteri);

	Musteri updateCustomer(Musteri musteri);

	void deleteCustomer(Musteri musteri);
}
