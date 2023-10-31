package juanp.laliguria.production.model.dto.supplyrequest;

import javax.persistence.Column;

import lombok.Value;

@Value
public class DgSupplyRequestSeeDataDTO {

	@Column(name = "Name")
	private String name;

	@Column(name = "Description")
	private String description;

	@Column(name = "RequestedQuantity")
	private Integer requestedQuantity;
}
