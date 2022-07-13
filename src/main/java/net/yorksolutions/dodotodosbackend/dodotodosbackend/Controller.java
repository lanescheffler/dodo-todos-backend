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

    @GetMapping("/getProcessList")
    public List<ProcessEntity> displayProcessList () {
        return service.displayProcessList();
    }

    @PutMapping(
            value="/editProcess/{title}"
    )
    public void EditProcess(@RequestBody ProcessEntity processToDo, @PathVariable String title){
        service.editProcess(processToDo, title);

    }

    @DeleteMapping(
            value="/deleteProcess/{title}"
    )
    public void deleteProcess(@PathVariable String title) {service.deleteProcess(title);
    }

}
