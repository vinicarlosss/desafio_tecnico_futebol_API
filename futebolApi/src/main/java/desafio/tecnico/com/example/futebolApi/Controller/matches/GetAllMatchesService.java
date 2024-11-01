package desafio.tecnico.com.example.futebolApi.Controller.matches;

import desafio.tecnico.com.example.futebolApi.Controller.matches.response.GetAllMatchesResponse;
import desafio.tecnico.com.example.futebolApi.Domain.matches.Matches;
import desafio.tecnico.com.example.futebolApi.Mapper.matches.GetAllMatchesMapper;
import desafio.tecnico.com.example.futebolApi.Repository.matches.MatchesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static desafio.tecnico.com.example.futebolApi.Mapper.matches.GetAllMatchesMapper.toResponse;

@Service
public class GetAllMatchesService {

    @Autowired
    private MatchesRepository matchesRepository;


    public List<GetAllMatchesResponse> get() {

        List<Matches> matches = matchesRepository.findHomeMatches();
        Map<String, List<Matches>> matchesByMatchweek = matches.stream()
                .collect(Collectors.groupingBy(Matches::getRound));

        return toResponse(matchesByMatchweek);
    }
}
