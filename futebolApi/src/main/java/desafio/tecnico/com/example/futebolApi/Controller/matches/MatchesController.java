package desafio.tecnico.com.example.futebolApi.Controller.matches;

import desafio.tecnico.com.example.futebolApi.Controller.matches.response.GetAllMatchesResponse;
import desafio.tecnico.com.example.futebolApi.Service.matches.GetAllMatchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchesController {

    @Autowired
    private GetAllMatchesService getAllMatchesService;

    @GetMapping("/getAll")
    public List<GetAllMatchesResponse> getAll(){
        return getAllMatchesService.get();
    }
}
