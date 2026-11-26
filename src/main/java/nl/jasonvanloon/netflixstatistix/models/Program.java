package nl.jasonvanloon.netflixstatistix.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotBlank
    @Size(max = 255)
    String name;

    String imageName;

    // Duration in minutes
    @PositiveOrZero
    Long duration;

    @NotNull
    @Enumerated(EnumType.STRING)
    ProgramType type;

    @ManyToMany
    @JoinTable(name = "program_genres", joinColumns = @JoinColumn(name = "program_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
    List<Genre> genres = new ArrayList<>();

    // Language codes
    String language;

    @Min(0)
    Integer age;

    @OneToMany(mappedBy = "program")
    List<Episode> episodes = new ArrayList<>();

    @OneToMany(mappedBy = "program")
    List<WatchHistory> watchHistory = new ArrayList<>();

    public enum ProgramType {
        MOVIE,
        SERIES
    }
}