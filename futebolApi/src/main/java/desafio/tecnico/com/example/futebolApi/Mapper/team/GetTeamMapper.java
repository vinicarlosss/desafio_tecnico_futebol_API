package desafio.tecnico.com.example.futebolApi.Mapper.team;

import desafio.tecnico.com.example.futebolApi.Controller.team.response.GetTeamPlayerResponse;
import desafio.tecnico.com.example.futebolApi.Controller.team.response.GetTeamResponse;
import desafio.tecnico.com.example.futebolApi.Domain.player.Player;
import desafio.tecnico.com.example.futebolApi.Domain.team.Team;

import java.util.List;

public class GetTeamMapper {
    public static GetTeamResponse toResponse(Team team, List<Player> teamPlayers) {

        List<GetTeamPlayerResponse> teamPlayerResponses = teamPlayers.stream().map(player
                        -> GetTeamPlayerResponse
                        .builder()
                        .id(player.getId())
                        .playerName(player.getPlayerName())
                        .country(player.getCountry())
                        .position(player.getPosition())
                        .build())
                .toList();
        return GetTeamResponse.builder()
                .id(team.getId())
                .teamName(team.getTeamName())
                .goalsFor(team.getGoalsFor())
                .goalsAgainst(team.getGoalsAgainst())
                .matches_played(team.getMatchesPlayed())
                .win(team.getWin())
                .draw(team.getDraw())
                .loss(team.getLoss())
                .points(team.getPoints())
                .position(team.getPosition())
                .players(teamPlayerResponses)
                .build();
    }
}
