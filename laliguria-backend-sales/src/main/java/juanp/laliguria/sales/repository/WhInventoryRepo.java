package juanp.laliguria.sales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import juanp.laliguria.sales.model.Inventory;
import juanp.laliguria.sales.model.dto.SupplyItemDataDTO;

@Repository
public interface WhInventoryRepo extends JpaRepository<Inventory, Integer> {

	@Query(nativeQuery = true)
	public List<SupplyItemDataDTO> UpWhGetSupplyItemDataList();
}
