package cl.uv.ici.arq.labs.bff.service;

import cl.uv.ici.arq.labs.bff.dtos.BoardsRespDTO;
import cl.uv.ici.arq.labs.bff.dtos.PinsRespDTO;

public interface ServiceBff {
	//--Board
	//public Boolean followBoard(String user_name, String board_id);
	//public Boolean removeBoard(String board_id, String user_name);
	public BoardsRespDTO userBoards(String user_name);
	//--pin
	public PinsRespDTO boardPins(String boardId);
	//public Boolean removePin(String boardId, String pin_id);
	//public Boolean AddPin(String boardId, String pin_id);
	
}
