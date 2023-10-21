package juanp.laliguria.general.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import juanp.laliguria.general.model.dto.DgSupplyRequestSeeDataDTO;
import juanp.laliguria.general.model.dto.SupplyRequestDTO;
import juanp.laliguria.general.repository.WhSupplyRequestRepo;

@Service
public class WhSupplyRequestServ {

	@Autowired
	private WhSupplyRequestRepo repo;

	@Transactional
	public Integer getSupplyRequestStatus(Integer supplyRequestId) {
		return repo.getSupplyRequestStatus(supplyRequestId);
	}

	@Transactional
	public List<SupplyRequestDTO> getSupplyRequestList() {
		return repo.UpWhGetSupplyRequestList();
	}

	@Transactional
	public List<DgSupplyRequestSeeDataDTO> getDgSupplyRequestSeeDataList(Integer supplyRequestId) {
		return repo.UpWhDgSupplyRequestSeeDataList(supplyRequestId);
	}

	@Transactional
	public void putAcceptSupplyRequest(Integer supplyRequestId) {
		repo.putAcceptSupplyRequest(supplyRequestId);
	}

	@Transactional
	public void putFinishSupplyRequest(Integer supplyRequestId) {
		repo.putFinishSupplyRequest(supplyRequestId);
	}

	@Transactional
	public void putDenySupplyRequest(Integer supplyRequestId) {
		repo.putDenySupplyRequest(supplyRequestId);
	}
}
