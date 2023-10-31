package juanp.laliguria.production.model.dto;

import javax.persistence.Column;

import lombok.Value;

@Value
public class DgSeeIngredientDataDTO {

	@Column(name = "Name")
	private String name;

	@Column(name = "Quantity")
	private Integer quantity;

	@Column(name = "Units")
	private String units;
}
