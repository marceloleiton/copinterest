package cl.uv.ici.arq.labs.pins.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.uv.ici.arq.labs.pins.entities.PinsEntity;

@Repository("pinsRepository")
public interface PinsRepository extends JpaRepository<PinsEntity, UUID> {
	
	 @Query(value = "SELECT * FROM users_pins", nativeQuery = true)
	    public List<PinsEntity> getAll();

}
