package desafio.tecnico.com.example.futebolApi.Domain.matches;

import desafio.tecnico.com.example.futebolApi.Domain.player.Player;
import desafio.tecnico.com.example.futebolApi.Domain.team.Team;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Matches {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
    @ManyToOne
    @JoinColumn(name = "opponent_team_id")
    private Team opponentTeam;
    @ManyToOne
    @JoinColumn(name = "captain_id")
    private Player captain;
    private LocalDateTime date;
    private String round;
    private String weekDay;
    private int goalsFor;
    private int goalsAgainst;
    private int poss;
    private String formation;
    private String opponentFormation;
    private String venue;
    private String result;
}
