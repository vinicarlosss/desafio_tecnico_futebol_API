package desafio.tecnico.com.example.futebolApi.Mapper.team;

import desafio.tecnico.com.example.futebolApi.Controller.team.response.GetTeamMatchesResponse;
import desafio.tecnico.com.example.futebolApi.Controller.team.response.GetTeamPlayerResponse;
import desafio.tecnico.com.example.futebolApi.Controller.team.response.GetTeamResponse;
import desafio.tecnico.com.example.futebolApi.Domain.matches.Matches;
import desafio.tecnico.com.example.futebolApi.Domain.player.Player;
import desafio.tecnico.com.example.futebolApi.Domain.team.Team;

import java.util.List;

public class GetTeamMapper {
    public static GetTeamResponse toResponse(Team team, List<Player> teamPlayers, List<Matches> matches, Matches nextMatch) {

        List<GetTeamPlayerResponse> teamPlayerResponses = teamPlayers.stream().map(player
                        -> GetTeamPlayerResponse
                        .builder()
                        .id(player.getId())
                        .playerName(player.getPlayerName())
                        .country(player.getCountry())
                        .position(player.getPosition())
                        .build())
                .toList();
        List<GetTeamMatchesResponse> teamMatchesResponses = matches.stream()
                .map(match -> GetTeamMatchesResponse
                        .builder()
                        .id(match.getId())
                        .teamName(match.getTeam().getTeamName())
                        .opponentTeamName(match.getOpponentTeam().getTeamName())
                        .captainName(match.getCaptain() != null ?
                                match.getCaptain().getPlayerName() : "Capitão não definido")
                        .date(match.getDate())
                        .round(match.getRound())
                        .weekDay(match.getWeekDay())
                        .goalsFor(match.getGoalsFor())
                        .goalsAgainst(match.getGoalsAgainst())
                        .poss(match.getPoss())
                        .formation(match.getFormation())
                        .opponentFormation(match.getOpponentFormation())
                        .venue(match.getVenue())
                        .result(match.getResult())
                        .isNextMatch(nextMatch != null && nextMatch.equals(match))
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
                .matches(teamMatchesResponses)
                .build();
    }
}
