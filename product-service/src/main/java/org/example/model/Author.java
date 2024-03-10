package org.example.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "authors")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
