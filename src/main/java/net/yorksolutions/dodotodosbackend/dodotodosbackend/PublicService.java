package net.yorksolutions.dodotodosbackend.dodotodosbackend;

//import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PublicService {

    private ProcessRepository processRepository;

//    private StageRepository stageRepository;

    private HashMap<UUID, Long> tokenMap;

//    public PublicService(ProcessRepository processRepository, HashMap<UUID, Long> tokenMap) {
//        this.processRepository = processRepository;
//        this.tokenMap = tokenMap;
//    }

    @Autowired
    public PublicService(@NonNull ProcessRepository processRepository){
        this.processRepository = processRepository;
        this.tokenMap = new HashMap<>();
    }

    public void AddProcess(ProcessEntity process) {
        Optional<ProcessEntity> createdProcess = processRepository.findByTitle(process.getTitle());
        if (createdProcess.isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        } else {
            ProcessEntity newProcess = new ProcessEntity(process.getTitle(), process.getId(), process.isFinished(), process.isStarted());
            processRepository.save(newProcess);
        }

    }

}
