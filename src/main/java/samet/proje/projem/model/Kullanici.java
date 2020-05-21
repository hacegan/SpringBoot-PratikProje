package samet.proje.projem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import samet.proje.projem.staticstuff.Common_Properties_Injection;

@Entity(name = "KULLANICILAR")
@Data
@NoArgsConstructor
public class Kullanici extends Common_Properties_Injection {

	@NotNull
	@Column(name = "USERNAME")
	private String username;

	@NotNull
	@Column(name = "USER_PASSWORD")
	private String user_password;

	@Email
	@Column(name = "EMAIL")
	private String email;

	@NotNull
	@Column(name = "ENABLED")
	private int enabled;

}
