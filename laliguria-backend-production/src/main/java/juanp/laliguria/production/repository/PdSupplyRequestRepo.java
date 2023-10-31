package juanp.laliguria.production.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import juanp.laliguria.production.model.Request;
import juanp.laliguria.production.model.dto.StatusDTO;
import juanp.laliguria.production.model.dto.supplyrequest.DgAdminSupplyDTO;
import juanp.laliguria.production.model.dto.supplyrequest.DgAdminSupplyOptionDTO;
import juanp.laliguria.production.model.dto.supplyrequest.DgSupplyRequestSeeDataDTO;
import juanp.laliguria.production.model.dto.supplyrequest.SupplyRequestDTO;

@Repository
public interface PdSupplyRequestRepo extends JpaRepository<Request, Integer> {
	
	@Query(nativeQuery = true)
	public List<StatusDTO> getStatusList();

	@Query(nativeQuery = true)
	public List<SupplyRequestDTO> UpPdGetSupplyRequestList();

	@Query(nativeQuery = true)
	public List<DgSupplyRequestSeeDataDTO> UpPdGetDgSupplyRequestSeeDataList(@Param("SupplyRequestId") Integer supplyRequestId);

	@Query(nativeQuery = true)
	public List<DgAdminSupplyOptionDTO> getDgAdminSupplyOptionList();
	
	@Query(nativeQuery = true)
	public List<DgAdminSupplyDTO> UpPdGetDgAdminSupplyList(@Param("SupplyRequestId") Integer supplyRequestId);


	@Query(value = "SELECT re.statusId FROM Request re WHERE re.id = :SupplyRequestId")
	public Integer getSupplyRequestStatus(@Param("SupplyRequestId") Integer supplyRequestId);
	
	@Modifying
	@Query(value = "{call UpPdPostCreateSupplyRequest(:SupplyData)}", nativeQuery = true)
	public void UpPdPostCreateSupplyRequest(@Param("SupplyData") String supplyData);
	
	@Modifying
	@Query(value = "{call UpPdPutModifySupplyRequest(:SupplyRequestId, :SupplyData)}", nativeQuery = true)
	public void UpPdPutModifySupplyRequest(@Param("SupplyRequestId") Integer supplyRequestId, @Param("SupplyData") String supplyData);

	@Modifying
	@Query(value = "UPDATE Request re SET re.statusId = 1 WHERE re.id = :SupplyRequestId")
	public void putBlockSupplyRequest(@Param("SupplyRequestId") Integer supplyRequestId);

	@Modifying
	@Query(value = "UPDATE Request re SET re.statusId = 2 WHERE re.id = :SupplyRequestId")
	public void putFreeSupplyRequest(@Param("SupplyRequestId") Integer supplyRequestId);

	@Modifying
	@Query(value = "UPDATE Request re SET re.statusId = 6 WHERE re.id = :SupplyRequestId")
	public void putCancelSupplyRequest(@Param("SupplyRequestId") Integer supplyRequestId);
}
