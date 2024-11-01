package desafio.tecnico.com.example.futebolApi.Controller.team.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class GetTeamMatchesResponse {

    private Long id;
    private String teamName;
    private String opponentTeamName;
    private String captainName;
    private LocalDateTime date;
    private String round;
    private String weekDay;
    private Integer goalsFor;
    private Integer goalsAgainst;
    private Integer poss;
    private String formation;
    private String opponentFormation;
    private String venue;
    private String result;
    private boolean isNextMatch;
}
