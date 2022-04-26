package com.example.postgres.controllers;

import com.example.postgres.entity.Name;
import com.example.postgres.service.NamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/addnames")
    public Name addNames(@RequestParam(value = "name", defaultValue = "*") String name) {
        System.out.println(this.getClass() + "___" + name);
        return namesService.save(name);
    }
}
