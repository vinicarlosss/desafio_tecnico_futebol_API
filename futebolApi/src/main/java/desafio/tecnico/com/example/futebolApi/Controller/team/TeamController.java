package desafio.tecnico.com.example.futebolApi.Controller.team;

import desafio.tecnico.com.example.futebolApi.Controller.team.response.GetRankingResponse;
import desafio.tecnico.com.example.futebolApi.Controller.team.response.GetTeamResponse;
import desafio.tecnico.com.example.futebolApi.Service.team.GetRankingService;
import desafio.tecnico.com.example.futebolApi.Service.team.GetTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private GetRankingService getRankingService;
    @Autowired
    private GetTeamService getTeamService;

    @GetMapping("/getRanking")
    public List<GetRankingResponse> getRanking(){
        return getRankingService.get();
    }

    @GetMapping("/getTeam/{teamId}")
    public GetTeamResponse getTeam(@PathVariable Long teamId){
        return getTeamService.get(teamId);
    }
}
