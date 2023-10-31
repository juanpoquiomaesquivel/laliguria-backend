package juanp.laliguria.production.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import juanp.laliguria.production.model.Order;
import juanp.laliguria.production.model.dto.DgSeeIngredientDataDTO;
import juanp.laliguria.production.model.dto.dailycatalogue.DailyRequestDTO;
import juanp.laliguria.production.model.dto.dailycatalogue.DgAdminCategoryDTO;
import juanp.laliguria.production.model.dto.dailycatalogue.DgAdminDailyRequestDataDTO;

@Repository
public interface PdDailyCatalogueRepo extends JpaRepository<Order, Integer> {
	
	@Query(nativeQuery = true)
	public List<DgAdminCategoryDTO> getDgAdminCategoryList();

	@Query(nativeQuery = true)
	public List<DgAdminDailyRequestDataDTO> UpPdGetDgAdminDailyRequestDataList();

	@Query(nativeQuery = true)
	public List<DailyRequestDTO> UpPdGetDailyRequestList();

	@Query(nativeQuery = true)
	public List<DgSeeIngredientDataDTO> UpPdGetDgSeeIngredientDataList(@Param("ProductId") Integer productId);

	@Query(value = "SELECT od.statusId FROM Order od WHERE od.id = :OrderId")
	public Integer getOrderStatus(@Param("OrderId") Integer orderId);

	@Modifying
	@Query(value = "UPDATE Order od SET od.statusId = 3 WHERE od.id = :OrderId")
	public void putStartDailyRequest(@Param("OrderId") Integer orderId);

	@Modifying
	@Query(value = "UPDATE Order od SET od.statusId = 4 WHERE od.id = :OrderId")
	public void putFinishDailyRequest(@Param("OrderId") Integer orderId);
}
