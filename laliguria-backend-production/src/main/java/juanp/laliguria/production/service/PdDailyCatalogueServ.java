package juanp.laliguria.production.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import juanp.laliguria.production.model.dto.DgSeeIngredientDataDTO;
import juanp.laliguria.production.model.dto.dailycatalogue.DailyRequestDTO;
import juanp.laliguria.production.model.dto.dailycatalogue.DgAdminCategoryDTO;
import juanp.laliguria.production.model.dto.dailycatalogue.DgAdminDailyRequestDataDTO;
import juanp.laliguria.production.repository.PdDailyCatalogueRepo;

@Service
public class PdDailyCatalogueServ {

	@Autowired
	private PdDailyCatalogueRepo repo;

	@Transactional
	public List<DgAdminCategoryDTO> getDgAdminCategoryList() {
		return repo.getDgAdminCategoryList();
	}

	@Transactional
	public List<DgAdminDailyRequestDataDTO> getDgAdminDailyRequestDataList() {
		return repo.UpPdGetDgAdminDailyRequestDataList();
	}

	@Transactional
	public List<DailyRequestDTO> getDailyRequestList() {
		return repo.UpPdGetDailyRequestList();
	}

	@Transactional
	public List<DgSeeIngredientDataDTO> getDgSeeIngredientDataList(Integer productId) {
		return repo.UpPdGetDgSeeIngredientDataList(productId);
	}

	@Transactional
	public Integer getOrderStatus(Integer orderId) {
		return repo.getOrderStatus(orderId);
	}

	@Transactional
	public void putStartDailyRequest(Integer orderId) {
		repo.putStartDailyRequest(orderId);
	}

	@Transactional
	public void putFinishDailyRequest(Integer orderId) {
		repo.putFinishDailyRequest(orderId);
	}
}
