package com.example.postgres;

import com.example.postgres.entity.Names;
import com.example.postgres.service.NamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostgressController {

    @Autowired
    private NamesService namesService;

    @GetMapping("/namesService")
    public List<Names> namesService(@RequestParam(value = "name", defaultValue = "*") String name) {
        System.out.println(this.getClass() + "___" + name);
        return namesService.findAllByName(name);
    }
}
