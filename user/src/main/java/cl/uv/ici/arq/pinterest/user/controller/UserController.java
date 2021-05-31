package cl.uv.ici.arq.pinterest.user.controller;

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

import cl.uv.ici.arq.pinterest.user.dto.BoardsReqDTO;
import cl.uv.ici.arq.pinterest.user.dto.PinsReqDTO;
import cl.uv.ici.arq.pinterest.user.dto.UserDTO;
import cl.uv.ici.arq.pinterest.user.entities.BoardsReqEntity;
import cl.uv.ici.arq.pinterest.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService service;
	
	@PostMapping
	public ResponseEntity<UserDTO> save(@RequestBody UserDTO userDTO) {
		return new ResponseEntity<>(service.createUser(userDTO), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> getAll() {
		return new ResponseEntity<>(service.allUsers(), HttpStatus.OK);
	}
	
	@GetMapping("/{user_name}/")
	public ResponseEntity<UserDTO> getByUName(@PathVariable String user_name) {
		return new ResponseEntity<>(service.getUser(user_name), HttpStatus.OK);
	}
	
	@DeleteMapping("/{user_name}/{board_id}/follow/")
	public ResponseEntity<Boolean> removeBoard(@PathVariable String board_id,@PathVariable String user_name) {
		return new ResponseEntity<>(service.unfollowBoard(board_id, user_name), HttpStatus.OK);
	}
	
	@PutMapping("/{user_name}/{board_id}/follow/")
	public ResponseEntity<BoardsReqEntity> followBoard(@PathVariable String user_name,@PathVariable String board_id) {
		return new ResponseEntity<>(service.folowBoard(user_name,board_id), HttpStatus.OK);
	}
	
	@GetMapping("/{user_name}/boards/feed")
	public ResponseEntity<BoardsReqDTO> userBoards(@PathVariable String user_name) {
		return new ResponseEntity<>(service.getUserBoards(user_name), HttpStatus.OK);
	}
	/*
	@GetMapping("/{user_name}/pins/")
	public ResponseEntity<PinsReqDTO> userPins(@PathVariable String user_name) {
		return new ResponseEntity<>(service.getUserPins(user_name), HttpStatus.OK);
	}
	*/
}
