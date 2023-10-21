package juanp.laliguria.general.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import juanp.laliguria.general.model.Request;
import juanp.laliguria.general.model.dto.DgSupplyRequestSeeDataDTO;
import juanp.laliguria.general.model.dto.SupplyRequestDTO;

@Repository
public interface WhSupplyRequestRepo extends JpaRepository<Request, Integer> {

	@Query(nativeQuery = true)
	public List<SupplyRequestDTO> UpWhGetSupplyRequestList();

	@Query(nativeQuery = true)
	public List<DgSupplyRequestSeeDataDTO> UpWhDgSupplyRequestSeeDataList(
			@Param("SupplyRequestId") Integer supplyRequestId);
	
	@Query(value = "SELECT re.requestStatusId FROM Request re WHERE re.id = :SupplyRequestId")
	public Integer getSupplyRequestStatus(@Param("SupplyRequestId") Integer supplyRequestId);
	
	@Modifying
	@Query(value = "UPDATE Request re SET re.requestStatusId = 3 WHERE re.id = :SupplyRequestId")
	public void putAcceptSupplyRequest(@Param("SupplyRequestId") Integer supplyRequestId);
	
	@Modifying
	@Query(value = "UPDATE Request re SET re.requestStatusId = 4 WHERE re.id = :SupplyRequestId")
	public void putFinishSupplyRequest(@Param("SupplyRequestId") Integer supplyRequestId);
	
	@Modifying
	@Query(value = "UPDATE Request re SET re.requestStatusId = 5 WHERE re.id = :SupplyRequestId")
	public void putDenySupplyRequest(@Param("SupplyRequestId") Integer supplyRequestId);
}
