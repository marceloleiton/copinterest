package cl.uv.ici.arq.labs.bff.service.client;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import cl.uv.ici.arq.labs.bff.dtos.BoardDTO;
import cl.uv.ici.arq.labs.bff.dtos.PinsReqDTO;

@FeignClient(name = "boardClient", url = "${rest.endpoints.boards.url}")
public interface BoardClient {

	@PostMapping("/boards")
	public ResponseEntity<BoardDTO> save(@RequestBody @Valid BoardDTO boardDTO);
	
	@GetMapping("/boards")
	public ResponseEntity<List<BoardDTO>> GetAllBoards();
	 
	@DeleteMapping("/boards/{boardId}")
	public ResponseEntity<Boolean> remove(@PathVariable String boardId);
	 		
	@GetMapping("/boards/{boardId}")
	public ResponseEntity<BoardDTO> findBoardById(@PathVariable String boardId);


	@PutMapping("/boards")
	public ResponseEntity<BoardDTO> update(@RequestBody @Valid BoardDTO boardDTO);
	
	@GetMapping("/boards/{boardId}/pins/")
	public ResponseEntity<PinsReqDTO> boardPins(@PathVariable String boardId);
	
	@DeleteMapping("/{boardId}/{pin_id}/follow/")
	public ResponseEntity<Boolean> removePin(@PathVariable String boardId,@PathVariable String pin_id);

	@PutMapping("/{boardId}/{pin_id}/Add/")
	public ResponseEntity<Boolean> AddPin(@PathVariable String boardId ,@PathVariable String pin_id);

}
