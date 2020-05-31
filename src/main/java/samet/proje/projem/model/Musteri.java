package samet.proje.projem.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import samet.proje.projem.staticstuff.Common_Properties_Injection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MUSTERI")
public class Musteri extends Common_Properties_Injection {

	@NotNull
	@Column(name = "KULUSERNAME")
	private String kulusername;

	@NotNull
	@Column(name = "CUSTOMER_NAME")
	private String customer_name;

	@NotNull
	@Column(name = "CUSTOMER_PHONE_NO")
	private String customer_phone_no;

	@NotNull
	@Column(name = "CUSTOMER_ADDRESS")
	private String customer_address;

	@NotNull
	@Column(name = "STARTDATE_CONTRACT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date theStartDate_Of_Contract;

	@Column(name = "ENDDATE_CONTRACT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date theEndDate_Of_Contract;

	@NotNull
	@Column(name = "CUSTOMER_ASSETS")
	private String customer_assets;

	@NotNull
	@Column(name = "CUSTOMER_PAYMENT")
	private String customer_payment;

	@NotNull
	@Range(min = 1, max = 4)
	@Column(name = "CUSTOMER_PRIORITY")
	private int customer_priority;

}
