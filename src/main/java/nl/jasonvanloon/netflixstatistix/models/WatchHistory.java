package nl.jasonvanloon.netflixstatistix.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class WatchHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "profile_id", nullable = false)
    Profile profile;

    @ManyToOne
    @JoinColumn(name = "program_id")
    Program program;

    @ManyToOne
    @JoinColumn(name = "episode_id")
    Episode episode;

    @NotNull
    @DecimalMin("0.0")
    @DecimalMax("100.0")
    Double watchPercentage;
}