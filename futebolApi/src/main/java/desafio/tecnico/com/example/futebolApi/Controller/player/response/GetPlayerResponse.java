package desafio.tecnico.com.example.futebolApi.Controller.player.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetPlayerResponse {

    private Long id;
    private String playerName;
    private String teamName;
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
