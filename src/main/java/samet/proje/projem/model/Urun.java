package samet.proje.projem.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import samet.proje.projem.staticstuff.Common_Properties_Injection;

@Entity
@Table(name = "URUN")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Urun extends Common_Properties_Injection {

	@NotNull
	private String product_img;

	@NotNull
	private String product_name;

	@NotNull
	private BigDecimal previous_product_price;

	@NotNull
	private BigDecimal current_product_price;

	@NotNull
	private BigDecimal lowest_product_price;

	@NotNull
	private BigDecimal highest_product_price;

	private int sold_product_quantity;

	private BigDecimal total_price_sold_product;

	@NotNull
	private int stock_quantity;

	@NotNull
	private String person_who_changed_product_lastly;

	@NotNull
	private String kulusername;

}
