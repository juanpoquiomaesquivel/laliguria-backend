package juanp.laliguria.production.model.dto;

import java.util.Date;

import javax.persistence.Column;

import lombok.Value;

@Value
public class SupplyRequestDTO {

	@Column(name = "Index")
	private Integer index;

	@Column(name = "Id")
	private Integer id;

	@Column(name = "StatusId")
	private Integer statusId;

	@Column(name = "StatusName")
	private String statusName;

	@Column(name = "StatusDescription")
	private String statusDescription;

	@Column(name = "StatusColorHex")
	private String statusColorHex;

	@Column(name = "Area")
	private Integer area;

	@Column(name = "Registration")
	private Date registration;

	@Column(name = "Requester")
	private String requester;
}
