package cl.uv.ici.arq.labs.pins.service.impl;

import java.util.List;
import java.util.UUID;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.uv.ici.arq.labs.pins.mapper.MapperUtils;
import cl.uv.ici.arq.labs.pins.dtos.PinsDTO;
import cl.uv.ici.arq.labs.pins.entities.PinsEntity;
import cl.uv.ici.arq.labs.pins.repository.PinsRepository;
import cl.uv.ici.arq.labs.pins.service.PinsService;

@Service("PinsService")
public class PinsServiceImpl implements PinsService {

	@Autowired
	PinsRepository pinsRepository;
	
	

	private PinsEntity mapUserEntity(PinsDTO pinsDTO) {
		PinsEntity pin= new PinsEntity();		
		pin.setImage(pinsDTO.getImage());
		pin.setImageBase64(pinsDTO.getImageBase64());
		pin.setUrl(pinsDTO.getUrl());
		pin.setTitle(pinsDTO.getTitle());
		pin.setCode(pinsDTO.getCode());
		return pin;
	}
	
	@Override
	public PinsDTO createPin(PinsDTO pinsDTO) {
		PinsEntity pinsEntity = this.mapUserEntity(pinsDTO);
		pinsEntity =this.pinsRepository.save(pinsEntity);
		pinsDTO=(PinsDTO) MapperUtils.map(pinsEntity,PinsDTO.class);
		return pinsDTO;
	}
	
	@Override
	public PinsDTO updatePins(PinsDTO pinsDTO) {
		PinsEntity pinsEntity = this.mapUserEntity(pinsDTO);
		pinsEntity.setPinId(UUID.fromString(pinsDTO.getPinId()));
		pinsEntity =this.pinsRepository.save(pinsEntity);
		pinsDTO=(PinsDTO) MapperUtils.map(pinsEntity, PinsDTO.class);
		return pinsDTO;
	}
	@Override
	public boolean delete(String pinId) {
		boolean delete=true;		
		this.pinsRepository.deleteById(UUID.fromString(pinId));		
		return delete;
	}

	@Override
	public PinsDTO savePin(PinsDTO pinsDTO) {
		PinsEntity pinsEntity = this.mapUserEntity(pinsDTO);
		pinsEntity =this.pinsRepository.save(pinsEntity);
		pinsDTO=(PinsDTO) MapperUtils.map(pinsEntity, PinsDTO.class);
		return pinsDTO;
	}

	@Override
	public PinsDTO getPin(String pinId) {
		return (PinsDTO) MapperUtils.map(this.pinsRepository.findById(UUID.fromString(pinId)).get(), PinsDTO.class);
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<PinsDTO> getPins() {
		 return (List<PinsDTO>) MapperUtils.mapAsList(pinsRepository.getAll(), new TypeToken<List<PinsDTO>>() {}.getType());
		 
	}
}