package com.veronika.interidtest.repository.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "dog")
@Data
public class DogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String runSpeed;
    private String name;
}