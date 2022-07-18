package net.yorksolutions.dodotodosbackend.dodotodosbackend;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {


    Optional<UserEntity> findByNameAndProcessStarted(String name, String processStarted);

    Optional<UserEntity> findByName(String name);

}
