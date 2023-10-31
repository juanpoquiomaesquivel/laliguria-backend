package juanp.laliguria.production.model.dto.dailycatalogue;

import javax.persistence.Column;

import lombok.Value;

@Value
public class DgAdminDailyRequestDataDTO {

	@Column(name = "Index")
	private Integer index;

	@Column(name = "ProductName")
	private String productName;

	@Column(name = "ProductionInfo")
	private Integer productionInfo;

	@Column(name = "CategoryId")
	private Integer categoryId;
}
