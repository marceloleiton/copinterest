package cl.uv.ici.arq.labs.boards.controller;

import java.util.List;

import javax.validation.Valid;

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

import cl.uv.ici.arq.labs.boards.config.CustomConfig;
import cl.uv.ici.arq.labs.boards.dtos.BoardDTO;
import cl.uv.ici.arq.labs.boards.service.BoardService;
import cl.uv.ici.arq.labs.boards.entities.PinsReqEntity;
import cl.uv.ici.arq.labs.boards.dtos.PinsReqDTO;

@RestController
@RequestMapping("/boards")

public class BoardsController {

  @Autowired
  CustomConfig config;
  
  @Autowired
  BoardService service;
  
  	@PostMapping
  	public ResponseEntity<BoardDTO> save(@RequestBody @Valid BoardDTO boardDTO) {
	  return new ResponseEntity<>(service.createBoards(boardDTO), HttpStatus.CREATED);
  	}

  	@GetMapping
  	public ResponseEntity<List<BoardDTO>> GetAllBoards() {
	  return new ResponseEntity<>(service.getBoards(), HttpStatus.OK);
  	}



  	@DeleteMapping("/{boardId}")
  	public ResponseEntity<Boolean> remove(@PathVariable String boardId) {
	  return new ResponseEntity<>(service.remove(boardId), HttpStatus.OK);
  	}
  
  	@GetMapping("/{boardId}")
  	public ResponseEntity<BoardDTO> findBoardById(@PathVariable String boardId) {
	  return new ResponseEntity<>(service.getBoard(boardId), HttpStatus.OK);
  	}
  
  	@PutMapping
  	public ResponseEntity<BoardDTO> update(@RequestBody @Valid BoardDTO boardDTO) {
	  return new ResponseEntity<>(service.updateBoards(boardDTO), HttpStatus.OK);
  	}
  
	@GetMapping("/{boardId}/pins/")
	public ResponseEntity<PinsReqDTO> boardPins(@PathVariable String boardId) {
		return new ResponseEntity<>(service.getBoardPins(boardId), HttpStatus.OK);
	}
  
	@DeleteMapping("/{boardId}/{pin_id}/follow/")
	public ResponseEntity<Boolean> removePin(@PathVariable String boardId,@PathVariable String pin_id) {
		return new ResponseEntity<>(service.DeletePin(boardId, pin_id), HttpStatus.OK);
	}
	
	@PutMapping("/{boardId}/{pin_id}/Add/")
	public ResponseEntity<Boolean> AddPin(@PathVariable String boardId ,@PathVariable String pin_id) {
		return new ResponseEntity<>(service.AddPin(boardId, pin_id), HttpStatus.OK);
	}
  
}
