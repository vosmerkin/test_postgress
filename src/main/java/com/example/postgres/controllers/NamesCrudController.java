package com.example.postgres.controllers;

import com.example.postgres.entity.Name;
import com.example.postgres.dto.*;
import com.example.postgres.service.NamesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NamesCrudController {
    private static final Logger log = LoggerFactory.getLogger(NamesCrudController.class);

    @Autowired
    private NamesService namesService;

    @GetMapping("/CRUDgetnames")
    public List<Name> getNames(@RequestParam(value = "name", defaultValue = "*") String name) {
        log.info("__CRUDgetnames_{}", name);
        return namesService.findAllByFirstName(name);
    }

    @PostMapping(value = "/CRUDaddnames", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Name CRUDaddNames(@Validated(NameDto.New.class) @RequestBody NameDto nameDto) {
        log.info("__CRUDaddnames_{}", nameDto.getName());
        return namesService.save(nameDto.toEntity());
//        curl -XPOST -H "Content-Type:application/json"   --data-raw "{\"id\" : null,\"name\" : \"Peter1\"}" http://localhost:8080/CRUDaddnames
    }

    @PutMapping(value = "/CRUDupdatenames", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Name CRUDupdateNames(@Validated(NameDto.UpdateName.class) @RequestBody NameDto nameDto) {
        log.info("__CRUDupdatenames_{}", nameDto);
        return namesService.updateName(nameDto.toEntity());
//        curl -XPUT -H "Content-Type:application/json"   --data-raw "{\"id\" :\"6\",\"name\" : \"Peter\"}" http://localhost:8080/CRUDupdatenames
    }

    @DeleteMapping(value = "/CRUDdeletenames")
    public ResponseEntity<String> CRUDdeleteNames(@RequestParam(value = "name") String name) {
        log.info("__CRUDupdatenames_{}", name);
        ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.RESET_CONTENT).body("HTTP 205 Reset Content___Unsuccessfull_No such name or multiplenames");
        if ((namesService.delete(name))||"".equals(name)) {
            responseEntity = ResponseEntity.status(HttpStatus.NO_CONTENT).body("HTTP 204 No Content___Succsesfully deleted");
        }
        log.info(responseEntity.toString());
        return responseEntity;
//        curl -X DELETE http://localhost:8080/CRUDdeletenames?name=jjj
    }
}
