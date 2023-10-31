package juanp.laliguria.production.model.dto.ordercatalogue;

import javax.persistence.Column;

import lombok.Value;

@Value
public class CustomerRequestDTO {

	@Column(name = "Index")
	private Integer index;

	@Column(name = "Id")
	private Integer id;

	@Column(name = "ProductId")
	private Integer productId;

	@Column(name = "ProductName")
	private String productName;

	@Column(name = "ProductionInfo")
	private Integer productionInfo;

	@Column(name = "Status")
	private Integer status;
}
