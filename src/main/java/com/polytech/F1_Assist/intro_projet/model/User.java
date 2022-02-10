package com.polytech.F1_Assist.intro_projet.model;

import lombok.*;
import javax.persistence.*; // import persistance library

@Entity // mark class as a database entity
@Getter // specify separately lombok annotation instead of @Data to avoid some problems
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users") // name of database table
public class User {

    @Id // annotation for ID column
    @GeneratedValue(strategy = GenerationType.IDENTITY) // strategy for ID, here it well be ID++
    @Column(length = 11) // column size on database side definition
    private Integer id;

    @Column(name = "name", nullable = false, length = 45) // database definiton => will launch SQL exception
    // NB: words in name should be linked by underscore => name_of_column
    private String name;

    @Column(name = "timeScrewTyre", nullable = true, length = 5) // database definiton => will launch SQL exception
    // NB: words in name should be linked by underscore => name_of_column
    private double timeScrewTyre;

    @Column(name = "timeRemoveTyre", nullable = true, length = 5) // database definiton => will launch SQL exception
    // NB: words in name should be linked by underscore => name_of_column
    private double timeRemoveTyre;

    @Column(name = "timeAddTyre", nullable = true, length = 5) // database definiton => will launch SQL exception
    // NB: words in name should be linked by underscore => name_of_column
    private double timeAddTyre;

    @Column(name = "available", nullable = true) // database definiton => will launch SQL exception
    // NB: words in name should be linked by underscore => name_of_column
    private boolean available;

}