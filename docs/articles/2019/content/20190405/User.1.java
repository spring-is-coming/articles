package io.opph.example.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id // <1>
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String login;

    @JsonIgnore
    @NotNull @Size(min = 60, max = 60)
    private String password;

    @ElementCollection(fetch = FetchType.EAGER) // <2>
    @JsonIgnore @Singular("withAuthority") // <3>
    private Set<String> authorities = new HashSet<>();
}