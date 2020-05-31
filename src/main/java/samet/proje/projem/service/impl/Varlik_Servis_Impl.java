package samet.proje.projem.service.impl;

import java.util.List;
import java.util.Optional;

import samet.proje.projem.model.Varlik;

public interface Varlik_Servis_Impl {

	Optional<List<Varlik>> getAssets();

	Varlik addAsset(Varlik varlik);

	Varlik updateAsset(Varlik varlik);

	void deleteAsset(Varlik varlik);

}
