package com.example.barteringandtrading.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name="user")
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private int phone;
    @Column
    private boolean active;

}
