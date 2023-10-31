package juanp.laliguria.production.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import juanp.laliguria.production.model.dto.ordercatalogue.CustomerRequestDTO;
import juanp.laliguria.production.model.dto.ordercatalogue.DgAdminOrderRequestDataDTO;
import juanp.laliguria.production.model.dto.ordercatalogue.OrderRequestDTO;
import juanp.laliguria.production.service.PdOrderCatalogueServ;
import juanp.laliguria.production.utils.Message;

@RestController
@RequestMapping("production/order-catalogue/api")
@CrossOrigin(origins = "http://localhost:4200")
public class PdOrderCatalogueCtrl {

	@Autowired
	private PdOrderCatalogueServ serv;

	@GetMapping("/get/admin/order/all")
	public ResponseEntity<List<DgAdminOrderRequestDataDTO>> getDgAdminOrderRequestDataList() throws Exception {
		Optional<List<DgAdminOrderRequestDataDTO>> list = Optional.ofNullable(serv.getDgAdminOrderRequestDataList());

		if (list.isEmpty()) {
			throw new Exception("ERROR => [getDgAdminOrderRequestDataList]");
		}

		return ResponseEntity.ok(list.get());
	}

	@GetMapping("/get/order/all")
	public ResponseEntity<List<OrderRequestDTO>> getOrderRequestList() throws Exception {
		Optional<List<OrderRequestDTO>> list = Optional.ofNullable(serv.getOrderRequestList());

		if (list.isEmpty()) {
			throw new Exception("ERROR => [getOrderRequestList]");
		}

		return ResponseEntity.ok(list.get());
	}

	@GetMapping("/get/order/{OrderRequestId}/product/all")
	public ResponseEntity<List<CustomerRequestDTO>> getCustomerRequestList(
			@PathVariable("OrderRequestId") Integer orderRequestId) throws Exception {
		Optional<List<CustomerRequestDTO>> list = Optional.ofNullable(serv.getCustomerRequestList(orderRequestId));

		if (list.isEmpty()) {
			throw new Exception("ERROR => [getCustomerRequestList]");
		}

		return ResponseEntity.ok(list.get());
	}

	@PutMapping("/put/order/{OrderRequestId}/product/{CustomerRequestId}/start")
	public ResponseEntity<Message> putStartCustomerRequest(@PathVariable("OrderRequestId") Integer orderRequestId,
			@PathVariable("CustomerRequestId") Integer customerRequestId) throws Exception {
		int catalogueStatus = serv.getOrderRequestStatus(orderRequestId);

		switch (catalogueStatus) {
		case 1:
			return ResponseEntity
					.ok(new Message(HttpStatus.BAD_REQUEST.value(), "Accion denegada, la orden esta bloqueada."));
		case 2:
			serv.putStartOrderRequest(orderRequestId);
			break;
		case 4:
			return ResponseEntity
					.ok(new Message(HttpStatus.BAD_REQUEST.value(), "Accion denegada, la orden ha sido atendida."));
		case 5:
			return ResponseEntity
					.ok(new Message(HttpStatus.BAD_REQUEST.value(), "Accion denegada, la orden ha sido rechazada."));
		case 6:
			return ResponseEntity
					.ok(new Message(HttpStatus.BAD_REQUEST.value(), "Accion denegada, la orden ha sido cancelada."));
		}

		int id = serv.getCustomerRequestStatus(customerRequestId);

		switch (id) {
		case 1:
			return ResponseEntity
					.ok(new Message(HttpStatus.BAD_REQUEST.value(), "Accion denegada, la orden esta bloqueada."));
		case 3:
			return ResponseEntity.ok(
					new Message(HttpStatus.BAD_REQUEST.value(), "Accion denegada, la orden se encuentra en atencion."));
		case 4:
			return ResponseEntity
					.ok(new Message(HttpStatus.BAD_REQUEST.value(), "Accion denegada, la orden ha sido atendida."));
		case 5:
			return ResponseEntity
					.ok(new Message(HttpStatus.BAD_REQUEST.value(), "Accion denegada, la orden ha sido rechazada."));
		case 6:
			return ResponseEntity
					.ok(new Message(HttpStatus.BAD_REQUEST.value(), "Accion denegada, la orden ha sido cancelada."));
		}

		serv.putStartCustomerRequest(customerRequestId);

		return ResponseEntity.ok(new Message(HttpStatus.ACCEPTED.value(), "Orden iniciada."));
	}

	@PutMapping("/put/order/{OrderRequestId}/product/{CustomerRequestId}/finish")
	public ResponseEntity<Message> putFinishCustomerRequest(@PathVariable("OrderRequestId") Integer orderRequestId,
			@PathVariable("CustomerRequestId") Integer customerRequestId) throws Exception {
		int catalogueStatus = serv.getOrderRequestStatus(orderRequestId);

		switch (catalogueStatus) {
		case 1:
			return ResponseEntity
					.ok(new Message(HttpStatus.BAD_REQUEST.value(), "Accion denegada, la orden esta bloqueada."));
		case 2:
			return ResponseEntity.ok(
					new Message(HttpStatus.BAD_REQUEST.value(), "Accion denegada, la orden se encuentra en espera."));
		case 4:
			return ResponseEntity
					.ok(new Message(HttpStatus.BAD_REQUEST.value(), "Accion denegada, la orden ha sido atendida."));
		case 5:
			return ResponseEntity
					.ok(new Message(HttpStatus.BAD_REQUEST.value(), "Accion denegada, la orden ha sido rechazada."));
		case 6:
			return ResponseEntity
					.ok(new Message(HttpStatus.BAD_REQUEST.value(), "Accion denegada, la orden ha sido cancelada."));
		}

		int id = serv.getCustomerRequestStatus(customerRequestId);

		switch (id) {
		case 1:
			return ResponseEntity
					.ok(new Message(HttpStatus.BAD_REQUEST.value(), "Accion denegada, la orden esta bloqueada."));
		case 2:
			return ResponseEntity.ok(
					new Message(HttpStatus.BAD_REQUEST.value(), "Accion denegada, la orden se encuentra en espera."));
		case 4:
			return ResponseEntity
					.ok(new Message(HttpStatus.BAD_REQUEST.value(), "Accion denegada, la orden ha sido atendida."));
		case 5:
			return ResponseEntity
					.ok(new Message(HttpStatus.BAD_REQUEST.value(), "Accion denegada, la orden ha sido rechazada."));
		case 6:
			return ResponseEntity
					.ok(new Message(HttpStatus.BAD_REQUEST.value(), "Accion denegada, la orden ha sido cancelada."));
		}

		serv.putFinishCustomerRequest(customerRequestId);

		int len = serv.getVerifyOrderRequestStatus(orderRequestId); // gives us the number of customer orders with no attention

		if (len == 0) {
			serv.putFinishOrderRequest(orderRequestId);
		}

		return ResponseEntity.ok(new Message(HttpStatus.ACCEPTED.value(), "Orden terminada."));
	}
}
