package desafio.tecnico.com.example.futebolApi.Domain.team;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private int matches_played;
    private int win;
    private int draw;
    private int loss;
    private int goalsFor;
    private int goalsAgainst;
    private int goalsDifference;
    private int points;
    private int position;
}
