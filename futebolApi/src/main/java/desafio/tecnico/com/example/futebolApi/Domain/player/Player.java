package desafio.tecnico.com.example.futebolApi.Domain.player;

import desafio.tecnico.com.example.futebolApi.Domain.team.Team;
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
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String playerName;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
    private String country;
    private String position;
    private int age;
    private int matchesPlayed;
    private int started;
    private int minutes;
    private int goals;
    private int assist;
    private int penaltysMade;
    private int penaltysAttempted;
    private int yellowCard;
    private int redCard;
}
