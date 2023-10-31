package juanp.laliguria.production.model;

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

import juanp.laliguria.production.model.dto.ordercatalogue.CustomerRequestDTO;
import juanp.laliguria.production.model.dto.ordercatalogue.DgAdminOrderRequestDataDTO;
import juanp.laliguria.production.model.dto.ordercatalogue.OrderRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NamedNativeQuery(name = "Catalogue.UpPdGetDgAdminOrderRequestDataList", query = "{call UpPdGetDgAdminOrderRequestDataList()}", resultSetMapping = "Mapping.DgAdminOrderRequestDataDTO")
@SqlResultSetMapping(name = "Mapping.DgAdminOrderRequestDataDTO", classes = @ConstructorResult(targetClass = DgAdminOrderRequestDataDTO.class, columns = {
		@ColumnResult(name = "Index", type = Integer.class), @ColumnResult(name = "Id", type = Integer.class),
		@ColumnResult(name = "CustomerName"), @ColumnResult(name = "Registration"),
		@ColumnResult(name = "Status", type = Integer.class) }))

@NamedNativeQuery(name = "Catalogue.UpPdGetOrderRequestList", query = "{call UpPdGetOrderRequestList()}", resultSetMapping = "Mapping.OrderRequestDTO")
@SqlResultSetMapping(name = "Mapping.OrderRequestDTO", classes = @ConstructorResult(targetClass = OrderRequestDTO.class, columns = {
		@ColumnResult(name = "Index", type = Integer.class), @ColumnResult(name = "Id", type = Integer.class),
		@ColumnResult(name = "CustomerName"), @ColumnResult(name = "Status", type = Integer.class) }))

@NamedNativeQuery(name = "Catalogue.UpPdGetCustomerRequestList", query = "{call UpPdGetCustomerRequestList(:OrderRequestId)}", resultSetMapping = "Mapping.CustomerRequestDTO")
@SqlResultSetMapping(name = "Mapping.CustomerRequestDTO", classes = @ConstructorResult(targetClass = CustomerRequestDTO.class, columns = {
		@ColumnResult(name = "Index", type = Integer.class), @ColumnResult(name = "Id", type = Integer.class),
		@ColumnResult(name = "ProductId", type = Integer.class), @ColumnResult(name = "ProductName"),
		@ColumnResult(name = "ProductionInfo", type = Integer.class),
		@ColumnResult(name = "Status", type = Integer.class) }))

@Entity
@Table(name = "Catalogue")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Catalogue implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Id")
	private Integer id;

	@Column(name = "`Type`")
	private Boolean type;

	@Column(name = "CustomerName")
	private String customerName;

	@Column(name = "StatusId")
	private Integer statusId;

	@Column(name = "Reception")
	private Date reception;

	@Column(name = "Deadline")
	private Date deadline;
}