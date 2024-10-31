package desafio.tecnico.com.example.futebolApi.Domain.team;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String teamName;
    private int matchesPlayed;
    private int win;
    private int draw;
    private int loss;
    private int goalsFor;
    private int goalsAgainst;
    private int goalsDifference;
    private int points;
    private int position;
}
