package net.yorksolutions.dodotodosbackend.dodotodosbackend;

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



}
