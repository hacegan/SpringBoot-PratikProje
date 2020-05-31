package samet.proje.projem.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import samet.proje.projem.staticstuff.Common_Properties_Injection;

@Entity
@Table(name = "VARLIK")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Varlik extends Common_Properties_Injection {

	@NotNull
	@Column(name = "IS_PAYEE_OR_PAYER")
	private boolean is_Payee_Or_Payer;

	@NotNull
	@Column(name = "PAYEE_OR_PAYER_NAME")
	private String payee_Or_payeer_name;

	@NotNull
	private BigDecimal price;

	private Varlik[] children;

	@NotNull
	private String kulusername;

}
