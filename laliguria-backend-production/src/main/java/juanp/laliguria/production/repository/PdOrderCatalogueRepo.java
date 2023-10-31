package juanp.laliguria.production.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import juanp.laliguria.production.model.Catalogue;
import juanp.laliguria.production.model.dto.ordercatalogue.CustomerRequestDTO;
import juanp.laliguria.production.model.dto.ordercatalogue.DgAdminOrderRequestDataDTO;
import juanp.laliguria.production.model.dto.ordercatalogue.OrderRequestDTO;

@Repository
public interface PdOrderCatalogueRepo extends JpaRepository<Catalogue, Integer> {

	@Query(nativeQuery = true)
	public List<DgAdminOrderRequestDataDTO> UpPdGetDgAdminOrderRequestDataList();

	@Query(nativeQuery = true)
	public List<OrderRequestDTO> UpPdGetOrderRequestList();

	@Query(nativeQuery = true)
	public List<CustomerRequestDTO> UpPdGetCustomerRequestList(@Param("OrderRequestId") Integer orderRequestId);

	@Query(value = "SELECT cg.statusId FROM Catalogue cg WHERE cg.id = :OrderRequestId")
	public Integer getOrderRequestStatus(@Param("OrderRequestId") Integer orderRequestId);@Modifying
	
	@Query(value = "UPDATE Catalogue cg SET cg.statusId = 3 WHERE cg.id = :OrderRequestId")
	public void putStartOrderRequest(@Param("OrderRequestId") Integer orderRequestId);

	@Modifying
	@Query(value = "UPDATE Catalogue cg SET cg.statusId = 4 WHERE cg.id = :OrderRequestId")
	public void putFinishOrderRequest(@Param("OrderRequestId") Integer orderRequestId);

	@Query(value = "SELECT count(*) FROM Order od WHERE od.catalogueId = :OrderRequestId and od.statusId = 2")
	public Integer getVerifyOrderRequestStatus(@Param("OrderRequestId") Integer orderRequestId);

	@Query(value = "SELECT od.statusId FROM Order od WHERE od.id = :CustomerRequestId")
	public Integer getCustomerRequestStatus(@Param("CustomerRequestId") Integer customerRequestId);

	@Modifying
	@Query(value = "UPDATE Order od SET od.statusId = 3 WHERE od.id = :CustomerRequestId")
	public void putStartCustomerRequest(@Param("CustomerRequestId") Integer customerRequestId);

	@Modifying
	@Query(value = "UPDATE Order od SET od.statusId = 4 WHERE od.id = :CustomerRequestId")
	public void putFinishCustomerRequest(@Param("CustomerRequestId") Integer customerRequestId);
}
