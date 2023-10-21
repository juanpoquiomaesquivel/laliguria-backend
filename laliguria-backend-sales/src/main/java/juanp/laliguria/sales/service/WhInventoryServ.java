package juanp.laliguria.sales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import juanp.laliguria.sales.model.dto.SupplyItemDataDTO;
import juanp.laliguria.sales.repository.WhInventoryRepo;

@Service
public class WhInventoryServ {

	@Autowired
	private WhInventoryRepo repo;

	@Transactional
	public List<SupplyItemDataDTO> getSupplyItemDataList() {
		return repo.UpWhGetSupplyItemDataList();
	}
}
