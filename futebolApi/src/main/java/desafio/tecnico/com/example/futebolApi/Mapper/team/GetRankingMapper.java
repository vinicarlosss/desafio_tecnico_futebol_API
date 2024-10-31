package desafio.tecnico.com.example.futebolApi.Mapper.team;

import desafio.tecnico.com.example.futebolApi.Controller.team.response.GetRankingResponse;
import desafio.tecnico.com.example.futebolApi.Domain.team.Team;

import java.util.List;

public class GetRankingMapper {
    public static List<GetRankingResponse> toResponse(List<Team> teams) {
        return teams.stream()
                .map(team -> GetRankingResponse.builder()
                        .id(team.getId())
                        .name(team.getTeamName())
                        .matchesPlayed(team.getMatchesPlayed())
                        .win(team.getWin())
                        .draw(team.getDraw())
                        .loss(team.getLoss())
                        .points(team.getPoints())
                        .build())
                .toList();
    }
}
