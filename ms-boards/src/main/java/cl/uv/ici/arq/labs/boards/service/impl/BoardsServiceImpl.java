package cl.uv.ici.arq.labs.boards.service.impl;

import java.util.List;
import java.util.UUID;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.uv.ici.arq.labs.boards.dtos.BoardDTO;
import cl.uv.ici.arq.labs.boards.entities.BoardEntity;
import cl.uv.ici.arq.labs.boards.entities.PinsReqEntity;
import cl.uv.ici.arq.labs.boards.mapper.MapperUtils;
import cl.uv.ici.arq.labs.boards.repository.BoardRepository;
import cl.uv.ici.arq.labs.boards.service.BoardService;

import cl.uv.ici.arq.labs.boards.dtos.PinsReqDTO;
import cl.uv.ici.arq.labs.boards.repository.PinsReqRepository;

@Service("BoardService")
public class BoardsServiceImpl implements BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	

	private BoardEntity mapUserEntity(BoardDTO boardDTO) {
		BoardEntity board= new BoardEntity();		
		board.setName(boardDTO.getName());
		board.setCategory(boardDTO.getCategory());
		board.setDescription(boardDTO.getDescription());
		board.setInitial_pins(boardDTO.getInitial_pins());
		board.setImages(boardDTO.getImages());
		board.setCover(boardDTO.getCover());
		return board;
	}
	
	@Override
	public BoardDTO createBoards(BoardDTO boardDTO) {
		BoardEntity boardEntity = this.mapUserEntity(boardDTO);
		boardEntity =this.boardRepository.save(boardEntity);
		boardDTO=(BoardDTO) MapperUtils.map(boardEntity, BoardDTO.class);
		return boardDTO;
	}


	@Override
	public boolean remove(String boardId) {
		boolean delete=true;		
		this.boardRepository.deleteById(UUID.fromString(boardId));		
		return delete;
	}

	@Override
    public BoardDTO updateBoards(BoardDTO boardDTO) {
        BoardEntity boardEntity = this.mapUserEntity(boardDTO);
        boardEntity.setBoardId(UUID.fromString(boardDTO.getBoardId()));
        boardEntity =this.boardRepository.save(boardEntity);
        boardDTO=(BoardDTO) MapperUtils.map(boardEntity, BoardDTO.class);
        return boardDTO;
    }
	
	@Override
	public BoardDTO getBoard(String boardId) {
		return (BoardDTO) MapperUtils.map(this.boardRepository.findById(UUID.fromString(boardId)).get(), BoardDTO.class);
	}
	@Autowired
	private PinsReqRepository pinRepository;
	
	@Override
	public PinsReqDTO getBoardPins(String boardId) {
		return new PinsReqDTO(boardId, (pinRepository.getBoardsByUName(boardId)));
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<BoardDTO> getBoards() {
		 return (List<BoardDTO>) MapperUtils.mapAsList(boardRepository.getAll(), new TypeToken<List<BoardDTO>>() {}.getType());
		 //return (List<UserDTO>) MapperUtils.mapAsList(userRepository.findAll(), new TypeToken<List<UserDTO>>() {}.getType());
	}
	
	@Override
	public Boolean AddPin(String boardId , String pin_id) {
		boolean added = true;
		PinsReqEntity pinsEntity = new PinsReqEntity(pin_id , boardId );
		pinsEntity = this.pinRepository.save(pinsEntity);
		return added;
	}
	
	@Override
	public Boolean DeletePin(String boardId , String pin_id) {
		boolean delete = true;
		this.pinRepository.deletePinID(pin_id, boardId);
		return delete;
	}
	
	
	
}
