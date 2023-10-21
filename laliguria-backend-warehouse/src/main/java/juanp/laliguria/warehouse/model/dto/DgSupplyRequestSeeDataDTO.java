package juanp.laliguria.warehouse.model.dto;

import javax.persistence.Column;

import lombok.Value;

@Value
public class DgSupplyRequestSeeDataDTO {

	@Column(name = "Name")
	private String name;
	
	@Column(name = "RequestedQuantity")
	private Integer requestedQuantity;

	@Column(name = "IsEnough")
	private Boolean isEnough;
}
