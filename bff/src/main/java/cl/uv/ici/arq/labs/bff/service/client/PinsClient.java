package cl.uv.ici.arq.labs.bff.service.client;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import cl.uv.ici.arq.labs.bff.dtos.PinsDTO;

@FeignClient(name = "pinsClient", url = "${rest.endpoints.pins.url}")
public interface PinsClient {

	@PostMapping("/pins")
	public ResponseEntity<PinsDTO> create(@RequestBody @Valid PinsDTO pinsDTO);

	@DeleteMapping("/pins/{pinId}")
	public ResponseEntity<Boolean> remove(@PathVariable String pinId);

	@GetMapping("/pins/{pinId}")
	public ResponseEntity<PinsDTO> getPin(@PathVariable String pinId);

	@PutMapping("/pins")
	public ResponseEntity<PinsDTO> save(@RequestBody @Valid PinsDTO pinsDTO);

}
