package samet.proje.projem.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kullanici_Detay_DTO {

	private String name_surname;

	private String img_loc;

	@JsonIgnore
	private Date last_login_date;

	public Kullanici_Detay_DTO(String name_surname, String img_loc) {
		this.name_surname = name_surname;
		this.img_loc = img_loc;
	}

}
