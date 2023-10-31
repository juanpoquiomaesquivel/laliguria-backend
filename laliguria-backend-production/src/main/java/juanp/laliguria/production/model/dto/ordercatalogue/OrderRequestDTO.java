package juanp.laliguria.production.model.dto.ordercatalogue;

import javax.persistence.Column;

import lombok.Value;

@Value
public class OrderRequestDTO {

	@Column(name = "Index")
	private Integer index;

	@Column(name = "Id")
	private Integer id;

	@Column(name = "CustomerName")
	private String customerName;

	@Column(name = "Status")
	private Integer status;
}
