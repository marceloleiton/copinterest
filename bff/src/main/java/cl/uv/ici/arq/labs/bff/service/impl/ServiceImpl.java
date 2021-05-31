package cl.uv.ici.arq.labs.bff.service.impl;

import java.lang.annotation.Annotation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import cl.uv.ici.arq.labs.bff.dtos.BoardDTO;
import cl.uv.ici.arq.labs.bff.dtos.BoardsReqDTO;
import cl.uv.ici.arq.labs.bff.dtos.BoardsRespDTO;
import cl.uv.ici.arq.labs.bff.dtos.PinsReqDTO;
import cl.uv.ici.arq.labs.bff.dtos.PinsRespDTO;
import cl.uv.ici.arq.labs.bff.dtos.UserDTO;
import cl.uv.ici.arq.labs.bff.dtos.PinsDTO;
import cl.uv.ici.arq.labs.bff.service.ServiceBff;
import cl.uv.ici.arq.labs.bff.service.client.BoardClient;
import cl.uv.ici.arq.labs.bff.service.client.PinsClient;
import cl.uv.ici.arq.labs.bff.service.client.UserClient;

@Service("ServiceBff")
public class ServiceImpl implements ServiceBff{
	@Autowired
	private UserClient user;
	
	@Autowired
	private BoardClient board;
	
	@Autowired
	private PinsClient pin;
	@Override
	public BoardsRespDTO userBoards(String user_name){
		UserDTO userdto = user.getByUName(user_name).getBody();
		List<PinsRespDTO> listBoard = new ArrayList<PinsRespDTO>();
		List<String> boards = user.userBoards(user_name).getBody().getBoards_list();
		
		for(String boardId: boards) {
			listBoard.add(boardPins(boardId));
			//listBoard.add(board.findBoardById(boardId).getBody());
			
		}
		return new BoardsRespDTO(userdto,listBoard);
	}
	
	@Override
	public PinsRespDTO boardPins(String boardId){
		BoardDTO boardto = board.findBoardById(boardId).getBody();
		List<PinsDTO> listPins = new ArrayList<PinsDTO>();
		List<String> pins = board.boardPins(boardId).getBody().getPins_list();
		for(String pinId : pins) {
			listPins.add(pin.getPin(pinId).getBody());		
		}
		return new PinsRespDTO(boardto,listPins);
	}
}
