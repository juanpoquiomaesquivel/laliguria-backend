package juanp.laliguria.production.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import juanp.laliguria.production.model.dto.ordercatalogue.CustomerRequestDTO;
import juanp.laliguria.production.model.dto.ordercatalogue.DgAdminOrderRequestDataDTO;
import juanp.laliguria.production.model.dto.ordercatalogue.OrderRequestDTO;
import juanp.laliguria.production.repository.PdOrderCatalogueRepo;

@Service
public class PdOrderCatalogueServ {

	@Autowired
	private PdOrderCatalogueRepo repo;

	@Transactional
	public List<DgAdminOrderRequestDataDTO> getDgAdminOrderRequestDataList() {
		return repo.UpPdGetDgAdminOrderRequestDataList();
	}

	@Transactional
	public List<OrderRequestDTO> getOrderRequestList() {
		return repo.UpPdGetOrderRequestList();
	}

	@Transactional
	public List<CustomerRequestDTO> getCustomerRequestList(Integer orderRequestId) {
		return repo.UpPdGetCustomerRequestList(orderRequestId);
	}

	@Transactional
	public Integer getOrderRequestStatus(Integer orderRequestId) {
		return repo.getOrderRequestStatus(orderRequestId);
	}

	@Transactional
	public void putStartOrderRequest(Integer orderRequestId) {
		repo.putStartOrderRequest(orderRequestId);
	}

	@Transactional
	public void putFinishOrderRequest(Integer orderRequestId) {
		repo.putFinishOrderRequest(orderRequestId);
	}

	@Transactional
	public Integer getVerifyOrderRequestStatus(Integer orderRequestId) {
		return repo.getVerifyOrderRequestStatus(orderRequestId);
	}

	@Transactional
	public Integer getCustomerRequestStatus(Integer customerRequestId) {
		return repo.getCustomerRequestStatus(customerRequestId);
	}

	@Transactional
	public void putStartCustomerRequest(Integer customerRequestId) {
		repo.putStartCustomerRequest(customerRequestId);
	}

	@Transactional
	public void putFinishCustomerRequest(Integer customerRequestId) {
		repo.putFinishCustomerRequest(customerRequestId);
	}
}
