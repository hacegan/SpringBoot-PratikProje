package samet.proje.projem.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import samet.proje.projem.staticstuff.CommonPropertiesInjection;

@Entity(name = "CALISAN_DETAY")
@Data
@NoArgsConstructor
public class Calisan_Detay extends CommonPropertiesInjection{
	
	@NotNull
	private String adi;
	
	@NotNull
	private String soyadi;
	
	@NotNull
	private int yasi;
	
	@NotNull
	private int gorevi;
	
	@NotNull
	private float maasi;
	
	private String telefon_no;
	
	private String ev_adres;
	
	@NotNull
	private LocalDate ise_baslama_tarihi;
	
	private LocalDate isten_ayrilis_tarihi;
	

}
