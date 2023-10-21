package juanp.laliguria.production.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import juanp.laliguria.production.model.dto.SupplyItemDataDTO;
import juanp.laliguria.production.repository.WhInventoryRepo;

@Service
public class WhInventoryServ {

	@Autowired
	private WhInventoryRepo repo;

	@Transactional
	public List<SupplyItemDataDTO> getSupplyItemDataList() {
		return repo.UpWhGetSupplyItemDataList();
	}
}
