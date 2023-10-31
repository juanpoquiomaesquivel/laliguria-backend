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

import juanp.laliguria.production.model.dto.DgSeeIngredientDataDTO;
import juanp.laliguria.production.model.dto.dailycatalogue.DailyRequestDTO;
import juanp.laliguria.production.model.dto.dailycatalogue.DgAdminCategoryDTO;
import juanp.laliguria.production.model.dto.dailycatalogue.DgAdminDailyRequestDataDTO;
import juanp.laliguria.production.service.PdDailyCatalogueServ;
import juanp.laliguria.production.utils.Message;

@RestController
@RequestMapping("production/daily-catalogue/api")
@CrossOrigin(origins = "http://localhost:4200")
public class PdDailyCatalogueCtrl {

	@Autowired
	private PdDailyCatalogueServ serv;

	@GetMapping("/get/admin/category/all")
	public ResponseEntity<List<DgAdminCategoryDTO>> getDgAdminCategoryList() throws Exception {
		Optional<List<DgAdminCategoryDTO>> list = Optional.ofNullable(serv.getDgAdminCategoryList());

		if (list.isEmpty()) {
			throw new Exception("ERROR => [getDgAdminCategoryList]");
		}

		return ResponseEntity.ok(list.get());
	}

	@GetMapping("/get/admin/order/all")
	public ResponseEntity<List<DgAdminDailyRequestDataDTO>> getDgAdminDailyRequestDataList() throws Exception {
		Optional<List<DgAdminDailyRequestDataDTO>> list = Optional.ofNullable(serv.getDgAdminDailyRequestDataList());

		if (list.isEmpty()) {
			throw new Exception("ERROR => [getDgAdminDailyRequestDataList]");
		}

		return ResponseEntity.ok(list.get());
	}

	@GetMapping("/get/order/all")
	public ResponseEntity<List<DailyRequestDTO>> getDailyRequestList() throws Exception {
		Optional<List<DailyRequestDTO>> list = Optional.ofNullable(serv.getDailyRequestList());

		if (list.isEmpty()) {
			throw new Exception("ERROR => [getDailyRequestList]");
		}

		return ResponseEntity.ok(list.get());
	}

	@GetMapping("/get/order/product/{ProductId}/see-data")
	public ResponseEntity<List<DgSeeIngredientDataDTO>> getDgSeeIngredientDataList(
			@PathVariable("ProductId") Integer productId) throws Exception {
		Optional<List<DgSeeIngredientDataDTO>> list = Optional.ofNullable(serv.getDgSeeIngredientDataList(productId));

		if (list.isEmpty()) {
			throw new Exception("ERROR => [getDgSeeIngredientDataList]");
		}

		return ResponseEntity.ok(list.get());
	}

	@PutMapping("/put/order/{OrderId}/start")
	public ResponseEntity<Message> putStartDailyRequest(@PathVariable("OrderId") Integer orderId) throws Exception {
		int id = serv.getOrderStatus(orderId);

		switch (id) {
		case 1:
			return ResponseEntity
					.ok(new Message(HttpStatus.BAD_REQUEST.value(), "Accion denegada, la orden esta bloqueada."));
		case 3:
			return ResponseEntity.ok(new Message(HttpStatus.BAD_REQUEST.value(),
					"Accion denegada, la orden se encuentra en atencion."));
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

		serv.putStartDailyRequest(orderId);

		return ResponseEntity.ok(new Message(HttpStatus.ACCEPTED.value(), "Orden iniciada."));
	}

	@PutMapping("/put/order/{OrderId}/finish")
	public ResponseEntity<Message> putFinishDailyRequest(@PathVariable("OrderId") Integer orderId) throws Exception {
		int id = serv.getOrderStatus(orderId);

		switch (id) {
		case 1:
			return ResponseEntity
					.ok(new Message(HttpStatus.BAD_REQUEST.value(), "Accion denegada, la orden esta bloqueada."));
		case 2:
			return ResponseEntity.ok(new Message(HttpStatus.BAD_REQUEST.value(),
					"Accion denegada, la orden se encuentra en espera."));
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

		serv.putFinishDailyRequest(orderId);

		return ResponseEntity.ok(new Message(HttpStatus.ACCEPTED.value(), "Orden terminada."));
	}
}
