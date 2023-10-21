package juanp.laliguria.general.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import juanp.laliguria.general.model.dto.SupplyItemDataDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NamedNativeQuery(name = "Inventory.UpWhGetSupplyItemDataList", query = "{call UpWhGetSupplyItemDataList()}", resultSetMapping = "Mapping.SupplyItemDataDTO")
@SqlResultSetMapping(name = "Mapping.SupplyItemDataDTO", classes = @ConstructorResult(targetClass = SupplyItemDataDTO.class, columns = {
		@ColumnResult(name = "Code"), @ColumnResult(name = "Name"), @ColumnResult(name = "Description"),
		@ColumnResult(name = "Provider"), @ColumnResult(name = "Category"), @ColumnResult(name = "Registration"),
		@ColumnResult(name = "ReceivedAmount", type = Integer.class), @ColumnResult(name = "Available", type = Integer.class) }))
@Entity
@Table(name = "Inventory")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Inventory implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Id")
	private Integer id;

	@Column(name = "ProvisionId")
	private Integer provisionId;

	@Column(name = "ProviderId")
	private Integer providerId;

	@Column(name = "OperatorEmployeeId")
	private Integer operatorEmployeeId;

	@Column(name = "Registration")
	private Date registration;

	@Column(name = "ReceivedAmount")
	private Integer receivedAmount;

	@Column(name = "DerivedAmount")
	private Integer derivedAmount;
}
