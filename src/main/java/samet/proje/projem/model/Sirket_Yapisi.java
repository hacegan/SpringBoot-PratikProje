package samet.proje.projem.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.lang.Nullable;

import lombok.Data;
import lombok.NoArgsConstructor;
import samet.proje.projem.staticstuff.Common_Properties_Injection;

@Entity(name = "SIRKET_YAPISI")
@Data
@NoArgsConstructor
public class Sirket_Yapisi extends Common_Properties_Injection {

	@Column(name = "PARENT_NODE")
	@Nullable
	private Integer parentNode;

	@Column(name = "CHILD_NODES")
	@Nullable
	private String child_nodes;

	@Column(name = "IMG_LOC")
	private String img_loc;

}
