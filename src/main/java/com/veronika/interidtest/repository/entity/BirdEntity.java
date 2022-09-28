package com.veronika.interidtest.repository.entity;

import com.veronika.interidtest.model.Animal;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "bird")
@Data
public class BirdEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal flightSpeed;
    private String name;
}
