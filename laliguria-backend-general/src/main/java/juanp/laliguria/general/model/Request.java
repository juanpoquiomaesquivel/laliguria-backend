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

import juanp.laliguria.general.model.dto.DgSupplyRequestSeeDataDTO;
import juanp.laliguria.general.model.dto.SupplyRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NamedNativeQuery(name = "Request.UpWhGetSupplyRequestList", query = "{call UpWhGetSupplyRequestList()}", resultSetMapping = "Mapping.SupplyRequestDTO")
@SqlResultSetMapping(name = "Mapping.SupplyRequestDTO", classes = @ConstructorResult(targetClass = SupplyRequestDTO.class, columns = {
		@ColumnResult(name = "Index", type = Integer.class), @ColumnResult(name = "Id", type = Integer.class),
		@ColumnResult(name = "StatusId", type = Integer.class), @ColumnResult(name = "StatusName"),
		@ColumnResult(name = "StatusDescription"), @ColumnResult(name = "StatusColorHex"),
		@ColumnResult(name = "Area", type = Integer.class), @ColumnResult(name = "Registration"),
		@ColumnResult(name = "Requester") }))

@NamedNativeQuery(name = "Request.UpWhDgSupplyRequestSeeDataList", query = "{call UpWhDgSupplyRequestSeeDataList(:SupplyRequestId)}", resultSetMapping = "Mapping.DgSupplyRequestSeeDataDTO")
@SqlResultSetMapping(name = "Mapping.DgSupplyRequestSeeDataDTO", classes = @ConstructorResult(targetClass = DgSupplyRequestSeeDataDTO.class, columns = {
		@ColumnResult(name = "Name"), @ColumnResult(name = "RequestedQuantity", type = Integer.class),
		@ColumnResult(name = "IsEnough", type = Boolean.class) }))
@Entity
@Table(name = "Request")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Request implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Id")
	private Integer id;

	@Column(name = "FromAreaId")
	private Integer fromAreaId;

	@Column(name = "DemandingEmployeeId")
	private Integer demandingEmployeeId;

	@Column(name = "ToAreaId")
	private Integer toAreaId;

	@Column(name = "ResponderEmployeeId")
	private Integer responderEmployeeId;

	@Column(name = "Registration")
	private Date registration;

	@Column(name = "Information")
	private String information;

	@Column(name = "RequestStatusId")
	private Integer requestStatusId;
}
