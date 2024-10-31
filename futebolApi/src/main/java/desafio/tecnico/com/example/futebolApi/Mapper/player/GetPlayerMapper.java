package desafio.tecnico.com.example.futebolApi.Mapper.player;

import desafio.tecnico.com.example.futebolApi.Controller.player.response.GetPlayerResponse;
import desafio.tecnico.com.example.futebolApi.Domain.player.Player;

public class GetPlayerMapper {

    public static GetPlayerResponse toResponse(Player player) {
        return GetPlayerResponse.builder()
                .id(player.getId())
                .playerName(player.getPlayerName())
                .teamName(player.getTeam().getTeamName())
                .country(player.getCountry())
                .position(player.getPosition())
                .age(player.getAge())
                .matchesPlayed(player.getMatchesPlayed())
                .started(player.getStarted())
                .minutes(player.getMinutes())
                .goals(player.getGoals())
                .assist(player.getAssist())
                .penaltysMade(player.getPenaltysMade())
                .penaltysAttempted(player.getPenaltysAttempted())
                .yellowCard(player.getYellowCard())
                .redCard(player.getRedCard())
                .build();
    }
}
