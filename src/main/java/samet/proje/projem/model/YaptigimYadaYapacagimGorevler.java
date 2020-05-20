package samet.proje.projem.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import samet.proje.projem.staticstuff.CommonPropertiesInjection;

public class YaptigimYadaYapacagimGorevler extends CommonPropertiesInjection {

	@NotNull
	@Column(name = "task_name")
	private String taskName;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "task_start_time")
	private Date taskStartTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "task_end_time")
	private Date taskEndTime;

}
