package com.polytech.F1_Assist.intro_projet.model;

import lombok.*;
import javax.persistence.*; // import persistance library

@Entity // mark class as a database entity
@Getter // specify separately lombok annotation instead of @Data to avoid some problems
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "postes") // name of database table
public class Poste {

    @Id // annotation for ID column
    @GeneratedValue(strategy = GenerationType.IDENTITY) // strategy for ID, here it well be ID++
    @Column(length = 11) // column size on database side definition
    private Integer id;

    @Column(name = "tyre", nullable = false, length = 50) // database definiton => will launch SQL exception
    // NB: words in name should be linked by underscore => name_of_column
    private String tyre;

    @Column(name = "activity", nullable = false, length = 50) // database definiton => will launch SQL exception
    // NB: words in name should be linked by underscore => name_of_column
    private String activity;

    @Column(name = "mechanic", length = 50) // database definiton => will launch SQL exception
    // NB: words in name should be linked by underscore => name_of_column
    private Integer mechanic;
}
