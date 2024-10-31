package desafio.tecnico.com.example.futebolApi.Controller.player;

import desafio.tecnico.com.example.futebolApi.Controller.player.response.GetPlayerResponse;
import desafio.tecnico.com.example.futebolApi.Service.player.GetPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private GetPlayerService getPlayerService;

    @GetMapping("/getPlayer/{playerId}")
    public GetPlayerResponse getPlayer(@PathVariable Long playerId){
        return getPlayerService.get(playerId);
    }
}
