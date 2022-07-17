package net.yorksolutions.dodotodosbackend.dodotodosbackend;

//import org.jetbrains.annotations.NotNull;

import org.apache.tomcat.jni.Proc;
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

    private StageRepository stageRepository;

    private UserRepository userRepository;

    private HashMap<UUID, Long> tokenMap;

//    public PublicService(ProcessRepository processRepository, HashMap<UUID, Long> tokenMap) {
//        this.processRepository = processRepository;
//        this.tokenMap = tokenMap;
//    }

    @Autowired
    public PublicService(@NonNull ProcessRepository processRepository, StageRepository stageRepository, UserRepository userRepository) {
        this.processRepository = processRepository;
        this.stageRepository = stageRepository;
        this.userRepository = userRepository;
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

    public void AddStage(StageEntity stage) {
        Optional<StageEntity> createdStage = stageRepository.findByProcessId(stage.getPromptu());
        if (createdStage.isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        } else {
            StageEntity newStage = new StageEntity(stage.getId(), stage.getProcessId(), stage.getOrderNumber(), stage.getPromptu(), stage.isPending(), stage.isDone(), stage.getComments());
            stageRepository.save(newStage);
        }
    }

    public void AddUser(String name, String processStarted) {
        if (userRepository.findByName(name).isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        } else {
            userRepository.save(new UserEntity(name, processStarted));
        }
    }

//    public UUID StartProcess(String name, String processStarted) {
//        Optional<UserEntity> result = userRepository.findByName(name);
//        if (result.isPresent()) {
//            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
//        } else {
//            final UUID token = UUID.randomUUID();
//            tokenMap.put(token, result.get().id);
//            return token;
//        }
//    }

    public List<ProcessEntity> displayProcessList() {
        // this name cannot be the same name as your processList/state on front end
        List<ProcessEntity> toDoList = (List<ProcessEntity>) processRepository.findAll();
        return toDoList;
    }

    public List<StageEntity> displayStageList() {
        // this name cannot be the same name as your processList/state on front end
        List<StageEntity> stepList = (List<StageEntity>) stageRepository.findAll();
        return stepList;
    }

    public void editProcess(ProcessEntity process, String title) {
        processRepository.findByTitle(title).map(e -> {
            e.setTitle(process.getTitle());
            return processRepository.save(e);
        });
    }

    public void editStage(StageEntity stage, Long id) {
        stageRepository.findById(id).map(e -> {
            e.setOrderNumber(stage.getOrderNumber());
            e.setPromptu(stage.getPromptu());
            e.setPending(stage.isPending());
            e.setDone(stage.isDone());
            return stageRepository.save(e);
        });
    }

    public void deleteProcess(String title) {
        Optional<ProcessEntity> result = processRepository.findByTitle(title);
        if(result.isPresent()) {
            processRepository.deleteById(result.get().getId());
        }
    }

    public void deleteStage(Long id) {
        Optional<StageEntity> result = stageRepository.findById(id);
        if(result.isPresent()) {
            stageRepository.deleteById(result.get().getId());
        }
    }
}

