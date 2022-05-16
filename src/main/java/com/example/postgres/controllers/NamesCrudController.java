package com.example.postgres.controllers;

import com.example.postgres.entity.Name;
import com.example.postgres.service.NamesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@RestController
public class NamesCrudController {
    private static Logger log = LoggerFactory.getLogger(NamesCrudController.class);

    @Autowired
    private NamesService namesService;



    @PostMapping(value = "/CRUDaddnames", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Name CRUDaddNames(@RequestBody Name name) {
        log.info(this.getClass().getName()
                + this.getClass().getEnclosingMethod().getName()
                + "__CRUD_"
                + name.getName());
        return namesService.save(name);
    }

    @PutMapping(value = "/CRUDupdatenames", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Name CRUDupdateNames(@RequestBody Name name) {
        Name existingNameEntity = namesService.getById(name.getId());
        if (existingNameEntity != null) {
            if (name.getName() != null) existingNameEntity.setName(name.getName());
            if (name.getCarId() != null) existingNameEntity.setCarId(name.getCarId());
        }
        log.info(this.getClass().getName()
                + "__CRUDupdate_"
                + existingNameEntity);
        return namesService.save(existingNameEntity);
//        curl -XPUT -H "Content-Type:application/json"   --data-raw "{\"id\" :\"6\",\"name\" : \"Peter1\"}" http://localhost:8080/CRUDupdatenames
    }

    @DeleteMapping(value = "/CRUDdeletenames")
    public Name CRUDdeleteNames(@RequestParam(value = "name", defaultValue = "*") String name) {
        log.info(this.getClass().getName()
                + "__CRUDdeleteNames_"
                + name);
        if (name != "")
            return namesService.delete(name);
        return null;
//        curl -X DELETE http://localhost:8080/CRUDdeletenames?name=jjj

    }


}
