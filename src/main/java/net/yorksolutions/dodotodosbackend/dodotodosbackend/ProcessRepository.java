package net.yorksolutions.dodotodosbackend.dodotodosbackend;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//ProcessEntity

@Repository
public interface ProcessRepository extends CrudRepository<ProcessEntity, Long> {

    Optional<ProcessEntity> findByTitle(String title);
    Optional<ProcessEntity> findById(Long id);

//    Optional<ThreadList> findByCurrentUser(String currentUser);
//    Optional<ThreadList> findByTitle(String title);

}

