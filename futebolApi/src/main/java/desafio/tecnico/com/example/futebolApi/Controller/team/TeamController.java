package desafio.tecnico.com.example.futebolApi.Controller.team;

import desafio.tecnico.com.example.futebolApi.Controller.team.response.GetRankingResponse;
import desafio.tecnico.com.example.futebolApi.Service.team.GetRankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private GetRankingService getRankingService;

    @GetMapping("/getRanking")
    public List<GetRankingResponse> get(){
        return getRankingService.get();
    }
}
