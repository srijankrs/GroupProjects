package com.example.barteringandtrading.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Getter
@Setter
@Table(name="user")
public class User {
    @Id
    @GeneratedValue()
    private int id;
    private String name;
    private String email;
    private int phone;
    private boolean active;

}
