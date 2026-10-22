package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Carro;
import app.service.CarroService;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/carro")
public class CarroController {

	@Autowired
	private CarroService carroService;

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Carro carro) {
		try {
			String msg = this.carroService.save(carro);
			return ResponseEntity.ok(msg);
		}catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@PutMapping("/update/{id}")
	public  ResponseEntity<String> update(@RequestBody Carro carro, @PathVariable Long id) {
		try {
			String msg = this.carroService.update(carro, id);
			return ResponseEntity.ok(msg);
		}catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<String> delete(@PathVariable Long id) {
		try {
			String msg = this.carroService.delete(id);
			return ResponseEntity.ok(msg);
		}catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<Carro>> findAll() {
		try {
			List<Carro> dados = this.carroService.findAll();
			return ResponseEntity.ok(dados);
		}catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<Carro> findById(@PathVariable Long id) {
	    try {
	        Carro carro = this.carroService.findById(id);
	        return ResponseEntity.ok(carro);
	    } catch (Exception e) {
	        return ResponseEntity.badRequest().build();
	    }
	}

}
