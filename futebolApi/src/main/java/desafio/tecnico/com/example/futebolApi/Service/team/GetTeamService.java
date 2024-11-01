package desafio.tecnico.com.example.futebolApi.Service.team;

import desafio.tecnico.com.example.futebolApi.Controller.team.response.GetTeamResponse;
import desafio.tecnico.com.example.futebolApi.Domain.matches.Matches;
import desafio.tecnico.com.example.futebolApi.Domain.player.Player;
import desafio.tecnico.com.example.futebolApi.Domain.team.Team;
import desafio.tecnico.com.example.futebolApi.Repository.matches.MatchesRepository;
import desafio.tecnico.com.example.futebolApi.Repository.player.PlayerRepository;
import desafio.tecnico.com.example.futebolApi.Repository.team.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

import static desafio.tecnico.com.example.futebolApi.Mapper.team.GetTeamMapper.toResponse;
import static java.time.LocalDateTime.*;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class GetTeamService {

    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private MatchesRepository matchesRepository;

    public GetTeamResponse get(Long teamId) {

        Team team = teamRepository.findById(teamId).orElseThrow(() ->
                new ResponseStatusException(NOT_FOUND, "Time não encontrado"));
        List<Player> teamPlayers = playerRepository.findByTeamIdOrderByPosition(teamId);
        List<Matches> matches = matchesRepository.findByTeamId(teamId);
        Matches nextMatch = matches.stream()
                .filter(match -> !match.getDate().isBefore(now()))
                .min(Comparator.comparing(Matches::getDate))
                .orElse(null);
        return toResponse(team, teamPlayers, matches, nextMatch);
    }
}
