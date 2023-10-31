package juanp.laliguria.production.model.dto;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.Value;

@Value
public class SupplyDataDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "Id")
	private Integer id;
	
	@Column(name = "Quantity")
	private Integer quantity;
}
