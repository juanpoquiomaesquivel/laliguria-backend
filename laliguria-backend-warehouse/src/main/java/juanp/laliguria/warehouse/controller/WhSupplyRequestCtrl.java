package juanp.laliguria.warehouse.controller;

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

import juanp.laliguria.warehouse.model.dto.DgSupplyRequestSeeDataDTO;
import juanp.laliguria.warehouse.model.dto.StatusDTO;
import juanp.laliguria.warehouse.model.dto.SupplyRequestDTO;
import juanp.laliguria.warehouse.service.WhSupplyRequestServ;
import juanp.laliguria.warehouse.utils.Message;

@RestController
@RequestMapping("/warehouse/supply-request/api")
@CrossOrigin(origins = "http://localhost:4200")
public class WhSupplyRequestCtrl {

	@Autowired
	private WhSupplyRequestServ serv;

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

	@PutMapping("/put/request/{SupplyRequestId}/accept")
	public ResponseEntity<Message> putAcceptSupplyRequest(@PathVariable("SupplyRequestId") Integer supplyRequestId)
			throws Exception {
		int id = serv.getSupplyRequestStatus(supplyRequestId);

		switch (id) {
		case 1:
			return ResponseEntity.ok(new Message(101, "Accion denegada, la solicitud esta bloqueada."));
		case 3:
			return ResponseEntity.ok(new Message(103, "Accion denegada, la solicitud se encuentra en atencion."));
		case 4:
			return ResponseEntity.ok(new Message(104, "Accion denegada, la solicitud ha sido atendida."));
		case 5:
			return ResponseEntity.ok(new Message(105, "Accion denegada, la solicitud ha sido rechazada."));
		case 6:
			return ResponseEntity.ok(new Message(106, "Accion denegada, la solicitud ha sido cancelada."));
		}

		serv.putAcceptSupplyRequest(supplyRequestId);

		return ResponseEntity.ok(new Message(201, "Solicitud aceptada."));
	}

	@PutMapping("/put/request/{SupplyRequestId}/finish")
	public ResponseEntity<Message> putFinishSupplyRequest(@PathVariable("SupplyRequestId") Integer supplyRequestId)
			throws Exception {
		int id = serv.getSupplyRequestStatus(supplyRequestId);

		switch (id) {
		case 1:
			return ResponseEntity.ok(new Message(101, "Accion denegada, la solicitud esta bloqueada."));
		case 2:
			return ResponseEntity.ok(new Message(102, "Accion denegada, la solicitud se encuentra en espera."));
		case 4:
			return ResponseEntity.ok(new Message(104, "Accion denegada, la solicitud ha sido atendida."));
		case 5:
			return ResponseEntity.ok(new Message(105, "Accion denegada, la solicitud ha sido rechazada."));
		case 6:
			return ResponseEntity.ok(new Message(106, "Accion denegada, la solicitud ha sido cancelada."));
		}

		serv.putFinishSupplyRequest(supplyRequestId);

		return ResponseEntity.ok(new Message(202, "Solicitud atendida."));
	}

	@PutMapping("/put/request/{SupplyRequestId}/deny")
	public ResponseEntity<Message> putDenySupplyRequest(@PathVariable("SupplyRequestId") Integer supplyRequestId)
			throws Exception {
		int id = serv.getSupplyRequestStatus(supplyRequestId);

		switch (id) {
		case 1:
			return ResponseEntity.ok(new Message(101, "Accion denegada, la solicitud esta bloqueada."));
		case 3:
			return ResponseEntity.ok(new Message(103, "Accion denegada, la solicitud se encuentra en atencion."));
		case 4:
			return ResponseEntity.ok(new Message(104, "Accion denegada, la solicitud ha sido atendida."));
		case 5:
			return ResponseEntity.ok(new Message(105, "Accion denegada, la solicitud ha sido rechazada."));
		case 6:
			return ResponseEntity.ok(new Message(106, "Accion denegada, la solicitud ha sido cancelada."));
		}

		serv.putDenySupplyRequest(supplyRequestId);

		return ResponseEntity.ok(new Message(203, "Solicitud rechazada."));
	}
}
