package samet.proje.projem.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.lang.Nullable;

import lombok.Data;
import lombok.NoArgsConstructor;
import samet.proje.projem.staticstuff.CommonPropertiesInjection;

@Entity(name = "ORGANIZATIONAL_STRUCTURE")
@Data
@NoArgsConstructor
public class Gorev extends CommonPropertiesInjection {

	@Column(name = "PARENT_NODE")
	@Nullable
	private Integer parentNode;

	@Column(name = "CHILD_NODES")
	@Nullable
	private String child_nodes;

	@Column(name = "IMG_LOC")
	private String img_loc;

}
