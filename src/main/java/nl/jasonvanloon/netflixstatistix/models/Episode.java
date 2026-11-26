package nl.jasonvanloon.netflixstatistix.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Episode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "program_id", nullable = false)
    Program program;

    @NotBlank
    @Size(max = 255)
    String name;

    // Duration in minutes
    @PositiveOrZero
    Long duration;

    @OneToMany(mappedBy = "episode")
    List<WatchHistory> watchHistory = new ArrayList<>();
}