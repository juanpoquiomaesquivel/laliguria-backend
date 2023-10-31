package juanp.laliguria.production.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import juanp.laliguria.production.model.dto.StatusDTO;
import juanp.laliguria.production.model.dto.supplyrequest.DgAdminSupplyDTO;
import juanp.laliguria.production.model.dto.supplyrequest.DgAdminSupplyOptionDTO;
import juanp.laliguria.production.model.dto.supplyrequest.DgSupplyRequestSeeDataDTO;
import juanp.laliguria.production.model.dto.supplyrequest.SupplyRequestDTO;
import juanp.laliguria.production.service.PdSupplyRequestServ;
import juanp.laliguria.production.utils.Message;

@RestController
@RequestMapping("production/supply-request/api")
@CrossOrigin(origins = "http://localhost:4200")
public class PdSupplyRequestCtrl {

	@Autowired
	private PdSupplyRequestServ serv;

	@GetMapping("/get/status/all")
	public ResponseEntity<List<StatusDTO>> getStatusList() throws Exception {
		Optional<List<StatusDTO>> list = Optional.ofNullable(serv.getStatusList());

		if (list.isEmpty()) {
			throw new Exception("ERROR => [getStatusList]");
		}

		return ResponseEntity.ok(list.get());
	}

	@GetMapping("/get/request/all")
	public ResponseEntity<List<SupplyRequestDTO>> getSupplyRequestList() throws Exception {
		Optional<List<SupplyRequestDTO>> list = Optional.ofNullable(serv.getSupplyRequestList());

		if (list.isEmpty()) {
			throw new Exception("ERROR => [getSupplyRequestList]");
		}

		return ResponseEntity.ok(list.get());
	}

	@GetMapping("/get/request/{SupplyRequestId}/see-data")
	public ResponseEntity<List<DgSupplyRequestSeeDataDTO>> getDgSupplyRequestSeeDataList(
			@PathVariable("SupplyRequestId") Integer supplyRequestId) throws Exception {
		Optional<List<DgSupplyRequestSeeDataDTO>> list = Optional
				.ofNullable(serv.getDgSupplyRequestSeeDataList(supplyRequestId));

		if (list.isEmpty()) {
			throw new Exception("ERROR => [getDgSupplyRequestSeeDataList]");
		}

		return ResponseEntity.ok(list.get());
	}

	@GetMapping("/get/form/supply-option/all")
	public ResponseEntity<List<DgAdminSupplyOptionDTO>> getDgAdminSupplyOptionList() throws Exception {
		Optional<List<DgAdminSupplyOptionDTO>> list = Optional.ofNullable(serv.getDgAdminSupplyOptionList());

		if (list.isEmpty()) {
			throw new Exception("ERROR => [getDgAdminSupplyOptionList]");
		}

		return ResponseEntity.ok(list.get());
	}

	@GetMapping("/get/form/request/{SupplyRequestId}/supply/all")
	public ResponseEntity<List<DgAdminSupplyDTO>> getDgAdminSupplyList(
			@PathVariable("SupplyRequestId") Integer supplyRequestId) throws Exception {
		Optional<List<DgAdminSupplyDTO>> list = Optional
				.ofNullable(serv.getDgAdminSupplyList(supplyRequestId));

		if (list.isEmpty()) {
			throw new Exception("ERROR => [getDgAdminSupplyList]");
		}

		return ResponseEntity.ok(list.get());
	}

	@PostMapping("/post/request/create")
	public ResponseEntity<Message> postCreateSupplyRequest(@RequestBody String supplyData) throws Exception {
		serv.postCreateSupplyRequest(supplyData);

		return ResponseEntity.ok(new Message(HttpStatus.ACCEPTED.value(), "Orden creada."));
	}

	@PutMapping("/put/request/{SupplyRequestId}/modify")
	public ResponseEntity<Message> putModifySupplyRequest(@PathVariable("SupplyRequestId") Integer supplyRequestId,
			/* @RequestParam("SupplyData") */ @RequestBody String supplyData) throws Exception {
		int status = serv.getSupplyRequestStatus(supplyRequestId);

		// JSONArray()

		System.out.println(supplyData);

		switch (status) {
		case 1:
			return ResponseEntity
					.ok(new Message(HttpStatus.BAD_REQUEST.value(), "Accion denegada, la orden esta bloqueada."));
		case 3:
			return ResponseEntity
					.ok(new Message(HttpStatus.BAD_REQUEST.value(), "Accion denegada, la orden esta en atencion."));
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

		serv.putModifySupplyRequest(supplyRequestId, supplyData);

		return ResponseEntity.ok(new Message(HttpStatus.ACCEPTED.value(), "Orden modificada."));
	}

	@PutMapping("/put/request/{SupplyRequestId}/cancel")
	public ResponseEntity<Message> putCancelSupplyRequest(@PathVariable("SupplyRequestId") Integer supplyRequestId)
			throws Exception {
		int status = serv.getSupplyRequestStatus(supplyRequestId);

		switch (status) {
		case 1:
			return ResponseEntity
					.ok(new Message(HttpStatus.BAD_REQUEST.value(), "Accion denegada, la orden esta bloqueada."));
		case 3:
			return ResponseEntity
					.ok(new Message(HttpStatus.BAD_REQUEST.value(), "Accion denegada, la orden esta en atencion."));
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

		serv.putCancelSupplyRequest(supplyRequestId);

		return ResponseEntity.ok(new Message(HttpStatus.ACCEPTED.value(), "Orden cancelada."));
	}
}
