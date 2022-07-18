package net.yorksolutions.dodotodosbackend.dodotodosbackend;

import org.apache.tomcat.jni.Proc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/")
@CrossOrigin
public class Controller {

    private PublicService service;

    @Autowired
    public Controller(@NonNull PublicService service) { this.service = service; }

    @PostMapping(
            value = "/createProcess",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )

    public void CreateProcess(@RequestBody ProcessEntity newProcess) {
        service.AddProcess(newProcess);
    }

    @PostMapping(
            value = "/createStage",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )

    public void CreateStage(@RequestBody StageEntity newStage) {
        service.AddStage(newStage);
    }

//    @PostMapping(
//            value = "/addUser",
//            consumes = {MediaType.APPLICATION_JSON_VALUE},
//            produces = {MediaType.APPLICATION_JSON_VALUE}
//    )
//
//    public void CreateUser(@RequestBody UserEntity user) {
//        service.AddUser(user);
//    }

    @GetMapping("/addUser")
    public void AddUser(@RequestParam String name, String processStarted) { service.AddUser(name, processStarted); }

    @GetMapping("/getProcessList")
    public List<ProcessEntity> displayProcessList () {
        return service.displayProcessList();
    }

    @GetMapping("/getStageList")
    public List<StageEntity> displayStageList () {
        return service.displayStageList();
    }

    @PutMapping(
            value="/editProcess/{title}"
    )
    public void EditProcess(@RequestBody ProcessEntity processToDo, @PathVariable String title){
        service.editProcess(processToDo, title);

    }

    @PutMapping(
            value="/editStage/{id}"
    )
    public void EditStage(@RequestBody StageEntity stepToDo, @PathVariable Long id){
        service.editStage(stepToDo, id);

    }

    @DeleteMapping(
            value="/deleteProcess/{title}"
    )
    public void deleteProcess(@PathVariable String title) {service.deleteProcess(title);
    }

    @DeleteMapping(
            value="/deleteStage/{id}"
    )
    public void deleteStage(@PathVariable Long id) {service.deleteStage(id);
    }

    @GetMapping("startProcess")
    public UUID StartProcess(@RequestParam String name, String processStarted) {return service.StartProcess(name, processStarted); }

}
