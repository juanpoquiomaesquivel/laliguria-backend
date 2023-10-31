package juanp.laliguria.production.model.dto.supplyrequest;

import javax.persistence.Column;

import lombok.Value;

@Value
public class DgAdminSupplyOptionDTO {

	@Column(name = "Id")
	private Integer id;

	@Column(name = "Name")
	private String name;

	@Column(name = "Description")
	private String description;
}
