package com.example.barteringandtrading.Model;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Setter
@Table(name="UserItems")
public class UserItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private long userId;
    private String itemFor;
    private String itemsRequired;
    private double itemValue;
    private int requiredItemListDeltaValue;
    private boolean deleted;




}
