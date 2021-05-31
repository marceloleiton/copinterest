package cl.uv.ici.arq.labs.bff.dtos;

import java.util.List;

import lombok.Data;

@Data
public class PinsRespDTO {
	
	public PinsRespDTO(BoardDTO board, List<PinsDTO> pins) {
		this.board = board;
		this.pin_list = pins;
	}
	
	public PinsRespDTO() {}
	
	private BoardDTO board;
	private List<PinsDTO> pin_list;

}
