package desafio.tecnico.com.example.futebolApi.Controller.team.response;

import desafio.tecnico.com.example.futebolApi.Domain.matches.Matches;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetTeamResponse {

    private Long id;
    private String teamName;
    private int matches_played;
    private int win;
    private int draw;
    private int loss;
    private int goalsFor;
    private int goalsAgainst;
    private int goalsDifference;
    private int points;
    private int position;
    private List<GetTeamPlayerResponse> players;
    private List<GetTeamMatchesResponse> matches;
}
