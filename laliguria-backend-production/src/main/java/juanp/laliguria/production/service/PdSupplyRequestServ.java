package juanp.laliguria.production.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import juanp.laliguria.production.model.dto.StatusDTO;
import juanp.laliguria.production.model.dto.supplyrequest.DgAdminSupplyDTO;
import juanp.laliguria.production.model.dto.supplyrequest.DgAdminSupplyOptionDTO;
import juanp.laliguria.production.model.dto.supplyrequest.DgSupplyRequestSeeDataDTO;
import juanp.laliguria.production.model.dto.supplyrequest.SupplyRequestDTO;
import juanp.laliguria.production.repository.PdSupplyRequestRepo;

@Service
public class PdSupplyRequestServ {

	@Autowired
	private PdSupplyRequestRepo repo;

	@Transactional
	public List<StatusDTO> getStatusList() {
		return repo.getStatusList();
	}

	@Transactional
	public List<SupplyRequestDTO> getSupplyRequestList() {
		return repo.UpPdGetSupplyRequestList();
	}

	@Transactional
	public List<DgSupplyRequestSeeDataDTO> getDgSupplyRequestSeeDataList(Integer supplyRequestId) {
		return repo.UpPdGetDgSupplyRequestSeeDataList(supplyRequestId);
	}

	@Transactional
	public List<DgAdminSupplyOptionDTO> getDgAdminSupplyOptionList() {
		return repo.getDgAdminSupplyOptionList();
	}

	@Transactional
	public List<DgAdminSupplyDTO> getDgAdminSupplyList(@Param("SupplyRequestId") Integer supplyRequestId) {
		return repo.UpPdGetDgAdminSupplyList(supplyRequestId);
	}

	@Transactional
	public Integer getSupplyRequestStatus(Integer supplyRequestId) {
		return repo.getSupplyRequestStatus(supplyRequestId);
	}

	@Transactional
	public void postCreateSupplyRequest(String supplyData) {
		repo.UpPdPostCreateSupplyRequest(supplyData);
	}

	@Transactional
	public void putModifySupplyRequest(Integer supplyRequestId, String supplyData) {
		repo.UpPdPutModifySupplyRequest(supplyRequestId, supplyData);
	}

	@Transactional
	public void putBlockSupplyRequest(Integer supplyRequestId) {
		repo.putBlockSupplyRequest(supplyRequestId);
	}

	@Transactional
	public void putCancelSupplyRequest(Integer supplyRequestId) {
		repo.putCancelSupplyRequest(supplyRequestId);
	}
}
