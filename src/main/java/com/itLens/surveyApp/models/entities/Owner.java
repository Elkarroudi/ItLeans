package com.itLens.surveyApp.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "owners")
public class Owner implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID )
    private String id;

    @Column(
            name = "name",
            unique = true,
            nullable = false
    )
    private String name;

    @OneToMany(
            mappedBy = "owner",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private List<Survey> surveys;

}
