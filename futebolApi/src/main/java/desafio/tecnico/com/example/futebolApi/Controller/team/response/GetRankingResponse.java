package desafio.tecnico.com.example.futebolApi.Controller.team.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetRankingResponse {

    private Long id;
    private String name;
    private int matchesPlayed;
    private int win;
    private int draw;
    private int loss;
    private int points;
}
