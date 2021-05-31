package cl.uv.ici.arq.labs.pins.service;


import java.util.List;

import cl.uv.ici.arq.labs.pins.dtos.PinsDTO;



public interface PinsService {
	
	public PinsDTO savePin(PinsDTO pins);
	public PinsDTO createPin(PinsDTO pins);
	public List<PinsDTO> getPins();
	public PinsDTO updatePins(PinsDTO pins);
	public boolean delete(String pinId);
	public PinsDTO getPin(String pinId);
	
}
