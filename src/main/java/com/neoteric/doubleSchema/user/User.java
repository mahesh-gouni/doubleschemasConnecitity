package com.neoteric.doubleSchema.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
@Component
public class User {






    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;


    private String email;

    private int age;

        // Getters and Setters
    }


