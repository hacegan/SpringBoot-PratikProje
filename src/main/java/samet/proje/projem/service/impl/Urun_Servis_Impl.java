package samet.proje.projem.service.impl;

import java.util.List;
import java.util.Optional;

import samet.proje.projem.model.Urun;

public interface Urun_Servis_Impl {
	
	Optional<List<Urun>> getProducts();
	
	Urun saveProduct(Urun urun);
	
	void deleteProduct(Urun urun);
	
	Urun updateProduct(Urun urun);

}
