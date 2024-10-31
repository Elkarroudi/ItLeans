package com.itLens.surveyApp.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
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

    @NotBlank
    @Size(max = 255)
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

    @CreationTimestamp
    @Column(
            updatable = false,
            nullable = false
    )
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
