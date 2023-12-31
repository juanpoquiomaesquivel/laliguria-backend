package juanp.laliguria.warehouse.model.dto;

import java.util.Date;

import javax.persistence.Column;

import lombok.Value;

@Value
public class SupplyItemDataDTO {

	@Column(name = "Code")
	private String code;

	@Column(name = "Name")
	private String name;

	@Column(name = "Description")
	private String description;

	@Column(name = "Provider")
	private String provider;

	@Column(name = "Category")
	private String category;

	@Column(name = "Registration")
	private Date registration;

	@Column(name = "Quantity")
	private Integer quantity;

	@Column(name = "Available")
	private Integer available;
}
