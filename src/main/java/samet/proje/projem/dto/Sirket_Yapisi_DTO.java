package samet.proje.projem.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sirket_Yapisi_DTO {

	private String label;

	private String type;

	private boolean expanded;

	private Data data;

	private List<Sirket_Yapisi_DTO> children;

	@JsonIgnore
	private long idalan;

	public class Data {
		public Data() {

		}

		public Data(String name2, String avatar2) {
			this.name = name2;
			this.avatar = avatar2;
		}

		private String name;
		private String avatar;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAvatar() {
			return avatar;
		}

		public void setAvatar(String avatar) {
			this.avatar = avatar;
		}

	}

	public Sirket_Yapisi_DTO(String label, List<Sirket_Yapisi_DTO> children, long idalan) {
		this.label = label;
		this.children = children;
		this.idalan = idalan;
	}

	public Sirket_Yapisi_DTO(String label, Data data2, ArrayList<Sirket_Yapisi_DTO> children, long gorevi) {
		this.label = label;
		this.data = data2;
		this.children = children;
		this.idalan = gorevi;
	}

}
