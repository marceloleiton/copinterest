package cl.uv.ici.arq.labs.bff.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import cl.uv.ici.arq.labs.bff.dtos.UserDTO;
import cl.uv.ici.arq.labs.bff.dtos.BoardsReqDTO;
import cl.uv.ici.arq.labs.bff.dtos.PinsReqDTO;


@FeignClient(name = "userClient", url = "${rest.endpoints.user.url}")
public interface UserClient {

	@PostMapping("/users")
	public ResponseEntity<UserDTO> save(@RequestBody UserDTO userDTO);
	
	@GetMapping("/users")
	public ResponseEntity<List<UserDTO>> getAll();
	
	@GetMapping("/users/{user_name}/")
	public ResponseEntity<UserDTO> getByUName(@PathVariable String user_name);

	@DeleteMapping("/users/{user_name}/{board_id}/follow/")
	public ResponseEntity<Boolean> removeBoard(@PathVariable String board_id,@PathVariable String user_name);
	
	@PutMapping("/users/{user_name}/{board_id}/follow/")
	public ResponseEntity<BoardsReqDTO> followBoard(@PathVariable String user_name,@PathVariable String board_id);


	@GetMapping("/users/{user_name}/boards/feed")
	public ResponseEntity<BoardsReqDTO> userBoards(@PathVariable String user_name);
	

	@GetMapping("/users/{user_name}/pins/")
	public ResponseEntity<PinsReqDTO> userPins(@PathVariable String user_name);

}
