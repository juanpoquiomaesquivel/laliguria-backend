package juanp.laliguria.production.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import juanp.laliguria.production.model.dto.DgSeeIngredientDataDTO;
import juanp.laliguria.production.model.dto.dailycatalogue.DailyRequestDTO;
import juanp.laliguria.production.model.dto.dailycatalogue.DgAdminCategoryDTO;
import juanp.laliguria.production.model.dto.dailycatalogue.DgAdminDailyRequestDataDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NamedNativeQuery(name = "Order.getDgAdminCategoryList", query = "SELECT pc.Id, pc.`Name`, pc.`Description` FROM ProductCategory pc", resultSetMapping = "Mapping.DgAdminCategoryDTO")
@SqlResultSetMapping(name = "Mapping.DgAdminCategoryDTO", classes = @ConstructorResult(targetClass = DgAdminCategoryDTO.class, columns = {
		@ColumnResult(name = "Id", type = Integer.class), @ColumnResult(name = "Name"),
		@ColumnResult(name = "Description") }))

@NamedNativeQuery(name = "Order.UpPdGetDgAdminDailyRequestDataList", query = "{call UpPdGetDgAdminDailyRequestDataList()}", resultSetMapping = "Mapping.DgAdminDailyRequestDataDTO")
@SqlResultSetMapping(name = "Mapping.DgAdminDailyRequestDataDTO", classes = @ConstructorResult(targetClass = DgAdminDailyRequestDataDTO.class, columns = {
		@ColumnResult(name = "Index", type = Integer.class), @ColumnResult(name = "ProductName"),
		@ColumnResult(name = "ProductionInfo", type = Integer.class),
		@ColumnResult(name = "CategoryId", type = Integer.class) }))

@NamedNativeQuery(name = "Order.UpPdGetDailyRequestList", query = "{call UpPdGetDailyRequestList()}", resultSetMapping = "Mapping.DailyRequestDTO")
@SqlResultSetMapping(name = "Mapping.DailyRequestDTO", classes = @ConstructorResult(targetClass = DailyRequestDTO.class, columns = {
		@ColumnResult(name = "Index", type = Integer.class), @ColumnResult(name = "Id", type = Integer.class),
		@ColumnResult(name = "ProductId", type = Integer.class), @ColumnResult(name = "ProductName"),
		@ColumnResult(name = "ProductionInfo", type = Integer.class),
		@ColumnResult(name = "Status", type = Integer.class) }))

@NamedNativeQuery(name = "Order.UpPdGetDgSeeIngredientDataList", query = "{call UpPdGetDgSeeIngredientDataList(:ProductId)}", resultSetMapping = "Mapping.DgSeeIngredientDataDTO")
@SqlResultSetMapping(name = "Mapping.DgSeeIngredientDataDTO", classes = @ConstructorResult(targetClass = DgSeeIngredientDataDTO.class, columns = {
		@ColumnResult(name = "Name"), @ColumnResult(name = "Quantity", type = Integer.class),
		@ColumnResult(name = "Units") }))
@Entity
@Table(name = "`Order`")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Id")
	private Integer id;

	@Column(name = "CatalogueId")
	private Integer catalogueId;

	@Column(name = "ProductId")
	private Integer productId;

	@Column(name = "Quantity")
	private Integer quantity;

	@Column(name = "StatusId")
	private Integer statusId;
}