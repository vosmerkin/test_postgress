package com.example.postgres.controllers;

import com.example.postgres.entity.Name;
import com.example.postgres.service.NamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class NamesController {

    @Autowired
    private NamesService namesService;

    @Autowired
    private NamesService addNames;

    @GetMapping("/getnames")
    public List<Name> getNames(@RequestParam(value = "name", defaultValue = "*") String name) {
        System.out.println(this.getClass() + "___" + name);
        return namesService.findAllByName(name);
    }

    @GetMapping ("/addnames")
    public void addNames(@RequestParam(value = "name", defaultValue = "*") String name) {


        String curlString = "curl -H \"Content-Type:application/json\" "
                +"-XPOST \"http://localhost:8080/CRUDaddnames\" -d \"%s\"" ;

        System.out.println(String.format(curlString, new Name(name)).toString());

        try {
            java.lang.Process process = Runtime.getRuntime().exec(String.format(curlString, new Name(name)));
        } catch (IOException e) {
            e.printStackTrace();
        }

//        return namesService.save(new Name(name));
    }

    @PostMapping("/CRUDaddnames")
    public Name CRUDaddNames(@RequestBody Name name) {
        System.out.println(this.getClass() + "__CRUD_" + name);

        return namesService.save(name);




//        return namesService.save(name);
    }
}
