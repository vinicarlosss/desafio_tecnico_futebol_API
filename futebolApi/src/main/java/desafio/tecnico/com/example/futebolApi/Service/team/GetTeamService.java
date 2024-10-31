package desafio.tecnico.com.example.futebolApi.Service.team;

import desafio.tecnico.com.example.futebolApi.Controller.team.response.GetTeamPlayerResponse;
import desafio.tecnico.com.example.futebolApi.Controller.team.response.GetTeamResponse;
import desafio.tecnico.com.example.futebolApi.Domain.player.Player;
import desafio.tecnico.com.example.futebolApi.Domain.team.Team;
import desafio.tecnico.com.example.futebolApi.Mapper.team.GetTeamMapper;
import desafio.tecnico.com.example.futebolApi.Repository.player.PlayerRepository;
import desafio.tecnico.com.example.futebolApi.Repository.team.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class GetTeamService {

    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private PlayerRepository playerRepository;

    public GetTeamResponse get(Long teamId) {

        Team team = teamRepository.findById(teamId).orElseThrow(() ->
                new ResponseStatusException(NOT_FOUND, "Time não encontrado"));
        List<Player> teamPlayers = playerRepository.findByTeamIdOrderByPosition(teamId);
        return GetTeamMapper.toResponse(team, teamPlayers);
    }
}
