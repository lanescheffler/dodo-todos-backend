package net.yorksolutions.dodotodosbackend.dodotodosbackend;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//ProcessEntity

@Repository
public interface StageRepository extends CrudRepository<StageEntity, Long> {

    Optional<StageEntity> findByPromptu(String promptu);

    Optional<StageEntity> findById(Long id);

//    Optional<ThreadList> findByCurrentUser(String currentUser);
//    Optional<ThreadList> findByTitle(String title);

}