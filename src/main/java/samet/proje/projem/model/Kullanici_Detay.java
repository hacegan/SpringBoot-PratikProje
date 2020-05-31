package samet.proje.projem.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import samet.proje.projem.staticstuff.Common_Properties_Injection;

@Entity(name = "KULLANICI_DETAY")
@Data
@NoArgsConstructor
public class Kullanici_Detay extends Common_Properties_Injection{
	
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
	
	private String ev_adresi;
	
	@NotNull
	private LocalDate ise_baslama_zamani;
	
	private LocalDate isten_ayrilis_zamani;
	
	@NotNull
	@JsonIgnore
	private String kulusername;
	
	@NotNull
	private String img_loc;
	
	@NotNull
	private int cinsiyet;
	

}
