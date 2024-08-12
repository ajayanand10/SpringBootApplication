package com.ajay.springboot.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;
    @Column
    private String password;
    @Column
    private String email;
    @Column(length = 10)
    private String mobile;

}
