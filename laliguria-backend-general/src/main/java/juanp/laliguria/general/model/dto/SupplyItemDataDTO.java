package juanp.laliguria.general.model.dto;

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

	@Column(name = "ReceivedAmount")
	private Integer receivedAmount;

	@Column(name = "Available")
	private Integer available;
}
