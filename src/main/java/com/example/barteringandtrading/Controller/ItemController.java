package com.example.barteringandtrading.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("api/items")
public class ItemController {

    @GetMapping(value = "/search/{itemId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Object>>getAllItems(@PathVariable("itemId") long itemId){

        Collection<Object> list = new ArrayList<>();
        list.add("test 1");
        list.add("test 2");
        list.add(itemId);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
