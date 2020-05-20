package samet.proje.projem.model;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import samet.proje.projem.staticstuff.CommonPropertiesInjection;

@Entity(name = "KULLANICILAR")
@Data
@NoArgsConstructor
public class Kullanicilar extends CommonPropertiesInjection {

	@NotNull
	private String username;

	@NotNull
	private String user_password;

	@Email
	private String email;

	@NotNull
	private int enabled;

}
