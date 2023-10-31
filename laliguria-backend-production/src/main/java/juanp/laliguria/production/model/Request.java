package juanp.laliguria.production.model;

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

import juanp.laliguria.production.model.dto.StatusDTO;
import juanp.laliguria.production.model.dto.supplyrequest.DgAdminSupplyDTO;
import juanp.laliguria.production.model.dto.supplyrequest.DgAdminSupplyOptionDTO;
import juanp.laliguria.production.model.dto.supplyrequest.DgSupplyRequestSeeDataDTO;
import juanp.laliguria.production.model.dto.supplyrequest.SupplyRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NamedNativeQuery(name = "Request.getStatusList", query = "SELECT * FROM `Status`", resultSetMapping = "Mapping.StatusDTO")
@SqlResultSetMapping(name = "Mapping.StatusDTO", classes = @ConstructorResult(targetClass = StatusDTO.class, columns = {
		@ColumnResult(name = "Id", type = Integer.class), @ColumnResult(name = "Name"),
		@ColumnResult(name = "Description"), @ColumnResult(name = "ColorHex") }))

@NamedNativeQuery(name = "Request.UpPdGetSupplyRequestList", query = "{call UpPdGetSupplyRequestList()}", resultSetMapping = "Mapping.SupplyRequestDTO")
@SqlResultSetMapping(name = "Mapping.SupplyRequestDTO", classes = @ConstructorResult(targetClass = SupplyRequestDTO.class, columns = {
		@ColumnResult(name = "Index", type = Integer.class), @ColumnResult(name = "Id", type = Integer.class),
		@ColumnResult(name = "Status", type = Integer.class), @ColumnResult(name = "Registration") }))

@NamedNativeQuery(name = "Request.UpPdGetDgSupplyRequestSeeDataList", query = "{call UpPdGetDgSupplyRequestSeeDataList(:SupplyRequestId)}", resultSetMapping = "Mapping.DgSupplyRequestSeeDataDTO")
@SqlResultSetMapping(name = "Mapping.DgSupplyRequestSeeDataDTO", classes = @ConstructorResult(targetClass = DgSupplyRequestSeeDataDTO.class, columns = {
		@ColumnResult(name = "Name"), @ColumnResult(name = "Description"),
		@ColumnResult(name = "RequestedQuantity", type = Integer.class) }))

@NamedNativeQuery(name = "Request.getDgAdminSupplyOptionList", query = "SELECT pv.id, pv.name, pv.description FROM Provision pv", resultSetMapping = "Mapping.DgAdminSupplyOptionDTO")
@SqlResultSetMapping(name = "Mapping.DgAdminSupplyOptionDTO", classes = @ConstructorResult(targetClass = DgAdminSupplyOptionDTO.class, columns = {
		@ColumnResult(name = "Id", type = Integer.class), @ColumnResult(name = "Name"),
		@ColumnResult(name = "Description") }))

@NamedNativeQuery(name = "Request.UpPdGetDgAdminSupplyList", query = "{call UpPdGetDgAdminSupplyList(:SupplyRequestId)}", resultSetMapping = "Mapping.DgAdminSupplyDTO")
@SqlResultSetMapping(name = "Mapping.DgAdminSupplyDTO", classes = @ConstructorResult(targetClass = DgAdminSupplyDTO.class, columns = {
		@ColumnResult(name = "Id", type = Integer.class), @ColumnResult(name = "Name"),
		@ColumnResult(name = "Description"), @ColumnResult(name = "RequestedQuantity", type = Integer.class) }))

@Entity
@Table(name = "Request")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Request {

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

	@Column(name = "StatusId")
	private Integer statusId;
}
