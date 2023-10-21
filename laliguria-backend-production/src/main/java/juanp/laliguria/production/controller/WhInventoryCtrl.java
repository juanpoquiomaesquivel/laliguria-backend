package juanp.laliguria.production.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import juanp.laliguria.production.model.dto.SupplyItemDataDTO;
import juanp.laliguria.production.service.WhInventoryServ;

@RestController
@RequestMapping("wh/inventory/api")
@CrossOrigin(origins = "http://localhost:4200")
public class WhInventoryCtrl {

	@Autowired
	private WhInventoryServ serv;

	@GetMapping("/get/supply/list")
	public ResponseEntity<List<SupplyItemDataDTO>> getSupplyItemDataList() throws Exception {
		Optional<List<SupplyItemDataDTO>> list = Optional.ofNullable(serv.getSupplyItemDataList());

		if (list.isEmpty()) {
			throw new Exception("ERROR => [getSupplyItemDataList]");
		}

		return ResponseEntity.ok(list.get());
	}
}
