package juanp.laliguria.production.model.dto.supplyrequest;

import java.util.Date;

import javax.persistence.Column;

import lombok.Value;

@Value
public class SupplyRequestDTO {

	@Column(name = "Index")
	private Integer index;

	@Column(name = "Id")
	private Integer id;

	@Column(name = "Status")
	private Integer status;

	@Column(name = "Registration")
	private Date registration;
}
