package samet.proje.projem.model;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import samet.proje.projem.staticstuff.Common_Properties_Injection;

public class Musteri extends Common_Properties_Injection {

	@NotNull
	private String kul_username;

	@NotNull
	private String customer_name;

	@NotNull
	private String customer_phone_no;

	@NotNull
	private String customer_address;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date theStartDate_Of_Contract;

	@Temporal(TemporalType.TIMESTAMP)
	private Date theEndDate_Of_Contract;

	@NotNull
	private String customer_assets;

	@NotNull
	private String customer_payments;

	@NotNull
	@Range(min = 1, max = 4)
	private int customer_priority;

}
