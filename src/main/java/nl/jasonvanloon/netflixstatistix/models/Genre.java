package nl.jasonvanloon.netflixstatistix.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotBlank
    @Size(max = 255)
    String name;

    @ManyToMany(mappedBy = "genres")
    List<Program> programs = new ArrayList<>();
}