package desafio.tecnico.com.example.futebolApi.Controller.team.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetTeamPlayerResponse {

    public Long id;
    public String playerName;
    public String country;
    public String position;
}
