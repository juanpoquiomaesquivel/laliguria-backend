package juanp.laliguria.warehouse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import juanp.laliguria.warehouse.model.Request;
import juanp.laliguria.warehouse.model.dto.DgSupplyRequestSeeDataDTO;
import juanp.laliguria.warehouse.model.dto.StatusDTO;
import juanp.laliguria.warehouse.model.dto.SupplyRequestDTO;

@Repository
public interface WhSupplyRequestRepo extends JpaRepository<Request, Integer> {

	@Query(nativeQuery = true)
	public List<StatusDTO> getStatusList();

	@Query(nativeQuery = true)
	public List<SupplyRequestDTO> UpWhGetSupplyRequestList();

	@Query(nativeQuery = true)
	public List<DgSupplyRequestSeeDataDTO> UpWhDgSupplyRequestSeeDataList(
			@Param("SupplyRequestId") Integer supplyRequestId);

	@Query(value = "SELECT re.statusId FROM Request re WHERE re.id = :SupplyRequestId")
	public Integer getSupplyRequestStatus(@Param("SupplyRequestId") Integer supplyRequestId);

	@Modifying
	@Query(value = "UPDATE Request re SET re.statusId = 3 WHERE re.id = :SupplyRequestId")
	public void putAcceptSupplyRequest(@Param("SupplyRequestId") Integer supplyRequestId);

	@Modifying
	@Query(value = "UPDATE Request re SET re.statusId = 4 WHERE re.id = :SupplyRequestId")
	public void putFinishSupplyRequest(@Param("SupplyRequestId") Integer supplyRequestId);

	@Modifying
	@Query(value = "UPDATE Request re SET re.statusId = 5 WHERE re.id = :SupplyRequestId")
	public void putDenySupplyRequest(@Param("SupplyRequestId") Integer supplyRequestId);
}
