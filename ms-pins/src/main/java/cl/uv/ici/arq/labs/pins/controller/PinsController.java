package cl.uv.ici.arq.labs.pins.controller;

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

import cl.uv.ici.arq.labs.pins.config.CustomConfig;
import cl.uv.ici.arq.labs.pins.dtos.PinsDTO;
import cl.uv.ici.arq.labs.pins.service.PinsService;

@RestController
@RequestMapping("/pins")

public class PinsController {

  @Autowired
  CustomConfig config;
  
  @Autowired
  PinsService service;
  
  
  @PostMapping
  public ResponseEntity<PinsDTO> create(@RequestBody @Valid PinsDTO pinsDTO) {
    return new ResponseEntity<>(service.createPin(pinsDTO), HttpStatus.CREATED);
  }
  
  @DeleteMapping("/{pinId}")
  public ResponseEntity<Boolean> remove(@PathVariable String pinId) {
    return new ResponseEntity<>(service.delete(pinId), HttpStatus.OK);
  }
  
  @GetMapping
	public ResponseEntity<List<PinsDTO>> GetAllPins() {
	  return new ResponseEntity<>(service.getPins(), HttpStatus.OK);
  }
  
  @GetMapping("/{pinId}")
  public ResponseEntity<PinsDTO> getPin(@PathVariable String pinId) {
    return new ResponseEntity<>(service.getPin(pinId), HttpStatus.OK);
  }

  @PutMapping
  public ResponseEntity<PinsDTO> update(@RequestBody @Valid PinsDTO pinsDTO) {
    return new ResponseEntity<>(service.updatePins(pinsDTO), HttpStatus.OK);
  }


}