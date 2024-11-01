package desafio.tecnico.com.example.futebolApi.Controller.matches.response;

import desafio.tecnico.com.example.futebolApi.Domain.matches.Matches;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetAllMatchesResponse {

    private String matchweek;
    private List<Matches> matches;

    public GetAllMatchesResponse(String matchweek, List<Matches> matches){
        this.matchweek = matchweek;
        this.matches = matches;
    }

}
