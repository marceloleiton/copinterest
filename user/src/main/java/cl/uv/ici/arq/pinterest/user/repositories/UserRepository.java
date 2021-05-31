package cl.uv.ici.arq.pinterest.user.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.uv.ici.arq.pinterest.user.entities.UserEntity;


@Repository("userRepository")
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    @Query(value = "SELECT * FROM users", nativeQuery = true)
    public List<UserEntity> getAll();
    
    @Query(value = "SELECT * FROM users WHERE user_name = :user_name", nativeQuery = true)
    public List<UserEntity> getByUName(String user_name);
}