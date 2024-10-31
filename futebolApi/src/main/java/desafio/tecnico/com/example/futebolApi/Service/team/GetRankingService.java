package desafio.tecnico.com.example.futebolApi.Service.team;

import desafio.tecnico.com.example.futebolApi.Controller.team.response.GetRankingResponse;
import desafio.tecnico.com.example.futebolApi.Domain.team.Team;
import desafio.tecnico.com.example.futebolApi.Mapper.team.GetRankingMapper;
import desafio.tecnico.com.example.futebolApi.Repository.team.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetRankingService {

    @Autowired
    private TeamRepository teamRepository;

    public List<GetRankingResponse> get() {

        List<Team> teams = teamRepository.findAllByOrderByPositionAsc();
        return GetRankingMapper.toResponse(teams);
    }
}
