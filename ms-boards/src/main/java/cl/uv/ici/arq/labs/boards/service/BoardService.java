package cl.uv.ici.arq.labs.boards.service;

import java.util.List;

import cl.uv.ici.arq.labs.boards.dtos.BoardDTO;
import cl.uv.ici.arq.labs.boards.dtos.PinsReqDTO;
import cl.uv.ici.arq.labs.boards.entities.PinsReqEntity;

public interface BoardService {

	public BoardDTO createBoards(BoardDTO board);
	public boolean remove(String idBoard);
	public List<BoardDTO> getBoards();
	public BoardDTO updateBoards(BoardDTO board);
	public BoardDTO getBoard(String idBoard);
	
	public PinsReqDTO getBoardPins(String boardId);
	public Boolean AddPin(String boardId, String pin_id);
	public Boolean DeletePin(String boardId , String pin_id);


}
