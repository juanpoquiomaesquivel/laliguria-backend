package juanp.laliguria.warehouse.model.dto;

import javax.persistence.Column;

import lombok.Value;

@Value
public class StatusDTO {

	@Column(name = "Id")
	private Integer id;

	@Column(name = "Name")
	private String name;

	@Column(name = "Description")
	private String description;

	@Column(name = "ColorHex")
	private String colorHex;
}
