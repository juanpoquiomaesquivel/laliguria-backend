package juanp.laliguria.production.model.dto.ordercatalogue;

import java.util.Date;

import javax.persistence.Column;

import lombok.Value;

@Value
public class DgAdminOrderRequestDataDTO {

	@Column(name = "Index")
	private Integer index;

	@Column(name = "Id")
	private Integer id;

	@Column(name = "CustomerName")
	private String customerName;

	@Column(name = "Reception")
	private Date reception;

	@Column(name = "Status")
	private Integer status;
}
