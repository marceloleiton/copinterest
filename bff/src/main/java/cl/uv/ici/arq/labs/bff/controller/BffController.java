package cl.uv.ici.arq.labs.bff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.uv.ici.arq.labs.bff.dtos.PinsRespDTO;
import cl.uv.ici.arq.labs.bff.service.ServiceBff;
import cl.uv.ici.arq.labs.bff.dtos.BoardsReqDTO;
import cl.uv.ici.arq.labs.bff.dtos.BoardsRespDTO;



@RestController
@RequestMapping("/bff")
public class BffController {
//------Board-User
	
	@Autowired
	private ServiceBff service;
	
	@GetMapping("/users/{user_name}/boards/feed")
	public ResponseEntity<BoardsRespDTO> GetAllB(@PathVariable String user_name) {
		return new ResponseEntity<>(service.userBoards(user_name), HttpStatus.OK);
	}
	/*
	@GetMapping("/boards/{boardId}/pins/")
	public ResponseEntity<PinsRespDTO> GetAllP(@PathVariable String boardId) {
		return new ResponseEntity<>(service.boardPins(boardId),HttpStatus.OK);
	}
	*/
	/*
	@PutMapping("/users/{user_name}/{board_id}/follow/")
	public ResponseEntity<Boolean> AddBoard(@PathVariable String user_name,@PathVariable String board_id) {
		return new ResponseEntity<>(service.followBoard(user_name, board_id), HttpStatus.OK);
	}
	
	@DeleteMapping("/users/{user_name}/{board_id}/follow/")
	public ResponseEntity<Boolean> RemoveB(@PathVariable String board_id,@PathVariable String user_name) {
		return new ResponseEntity<>(service.removeBoard(board_id, user_name), HttpStatus.OK);
	}

//-----Pins-Board
	
	
	@DeleteMapping("/boards/{boardId}/{pin_id}")
	public ResponseEntity<Boolean> RemoveP(@PathVariable String boardId,@PathVariable String pin_id){
		return new ResponseEntity<>(service.removePin(boardId,pin_id), HttpStatus.OK);
	}
	
	@PutMapping("/boards/{boardId}/{pin_id}/Add/")
	public ResponseEntity<Boolean> AddPin(@PathVariable String boardId ,@PathVariable String pin_id){
		return new ResponseEntity<>(service.AddPin(boardId, pin_id), HttpStatus.OK);
	}
	*/
	
}