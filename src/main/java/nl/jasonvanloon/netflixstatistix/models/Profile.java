package nl.jasonvanloon.netflixstatistix.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotBlank
    @Size(max = 255)
    String name;

    @Min(1900)
    @NotBlank
    Integer birthYear;

    @ManyToOne(optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    Account account;

    @OneToMany(mappedBy = "profile")
    List<WatchHistory> watchHistory = new ArrayList<>();

    public Integer getAge() {
        return Year.now().getValue() - birthYear;
    }
}