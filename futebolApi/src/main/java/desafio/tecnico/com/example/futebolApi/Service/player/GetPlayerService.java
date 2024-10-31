package desafio.tecnico.com.example.futebolApi.Service.player;

import desafio.tecnico.com.example.futebolApi.Controller.player.response.GetPlayerResponse;
import desafio.tecnico.com.example.futebolApi.Domain.player.Player;
import desafio.tecnico.com.example.futebolApi.Repository.player.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static desafio.tecnico.com.example.futebolApi.Mapper.player.GetPlayerMapper.toResponse;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class GetPlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public GetPlayerResponse get(Long playerId) {

        Player player = playerRepository.findById(playerId)
                .orElseThrow(()-> new ResponseStatusException(NOT_FOUND, "Jogador não encontrado."));
        return toResponse(player);
    }
}
