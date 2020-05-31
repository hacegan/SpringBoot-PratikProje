package samet.proje.projem.staticstuff;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Bu class tüm entitylerde ortak olduğu için bu classı entity classlarımıza
 * kalıtımla aktarıcaz tekrar aynı propertileri olusturmadan.
 * 
 * @author samet
 *
 */

@MappedSuperclass
@Data
@NoArgsConstructor
public class Common_Properties_Injection {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "CREATED_BY")
	@NotNull
	private String createdBy;

	@Column(name = "UPDATED_BY")
	@NotNull
	private String updatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE")
	private Date updatedDate;

}
