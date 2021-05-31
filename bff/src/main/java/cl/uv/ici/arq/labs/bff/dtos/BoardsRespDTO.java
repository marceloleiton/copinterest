package cl.uv.ici.arq.labs.bff.dtos;

import java.util.List;

import lombok.Data;

@Data
public class BoardsRespDTO {
	
	public BoardsRespDTO(UserDTO user, List<PinsRespDTO> boards_list) {
		this.user = user;
		this.boards_list = boards_list;
	}
	
	public BoardsRespDTO() {}
	
	private UserDTO user;
	//private List<BoardDTO> boards_list;
	private List<PinsRespDTO> boards_list;
}

