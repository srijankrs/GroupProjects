package com.example.barteringandtrading.Controller;

import com.example.barteringandtrading.Model.UserItem;
import com.example.barteringandtrading.Services.UserItemsService;
import com.example.barteringandtrading.Services.UserItemsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("api/items")
public class ItemController {

    @Autowired
    private UserItemsService userItemsService;

    @GetMapping(value = "/search/{itemId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Object>>getAllItems(@PathVariable("itemId") long itemId){

        Collection<Object> list = new ArrayList<>();
        list.add("test 1");
        list.add("test 2");
        list.add(itemId);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(value = "/add",produces = MediaType.APPLICATION_JSON_VALUE)
    public String addItems(@RequestBody UserItem userItem) throws IOException {

        return userItemsService.addItem(userItem);

    }
}
