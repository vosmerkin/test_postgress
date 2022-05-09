package com.example.postgres.controllers;

import com.example.postgres.entity.Name;
import com.example.postgres.service.NamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@RestController
public class NamesController {

    @Autowired
    private NamesService namesService;

    @GetMapping("/getnames")
    public List<Name> getNames(@RequestParam(value = "name", defaultValue = "*") String name) {
        System.out.println(this.getClass() + "___" + name);
        return namesService.findAllByFirstName(name);
    }

    @GetMapping ("/addnames")
    public void addNames(@RequestParam(value = "name", defaultValue = "*") String name) {

//        curl -XPOST -H "Content-Type:application/json"   --data-raw '{"id" : null,"name" : "Peter"}' http://localhost:8080/CRUDaddnames


    String curlString = "curl -XPOST -H \"Content-Type:application/json\" "
                + "  --data-raw '%s' http://localhost:8080/CRUDaddnames";

//        String curlString = "curl -XPOST  \"http://localhost:8080/CRUDaddnames\" " ;

        System.out.println(String.format(curlString, new Name(name).toJson()));
        try {
            java.lang.Process process = Runtime.getRuntime().exec(String.format(curlString, new Name(name).toJson()));
            System.out.println("curl posted");

            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            System.out.println("output: ");
            try {
                Thread.sleep(2000);
                while (process.isAlive()) Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("return value: " + process.exitValue());
            reader.lines().forEach(System.out::println);
            reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            reader.lines().forEach(System.err::println);

//            System.out.println("---");
//            System.out.println(process.getInputStream().toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

//        return namesService.save(new Name(name));
    }

    @PostMapping(value = "/CRUDaddnames", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Name CRUDaddNames(@RequestBody Name name) {
        System.out.println(this.getClass() + "__CRUD_" + name);

        return namesService.save(name);




//        return namesService.save(name);
    }
}
