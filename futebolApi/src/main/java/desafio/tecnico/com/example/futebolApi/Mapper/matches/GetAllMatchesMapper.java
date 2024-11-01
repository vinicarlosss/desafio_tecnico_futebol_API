package desafio.tecnico.com.example.futebolApi.Mapper.matches;

import desafio.tecnico.com.example.futebolApi.Controller.matches.response.GetAllMatchesResponse;
import desafio.tecnico.com.example.futebolApi.Domain.matches.Matches;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GetAllMatchesMapper {
    public static List<GetAllMatchesResponse> toResponse(Map<String, List<Matches>> matchesByMatchweek) {

        return matchesByMatchweek.entrySet().stream()
                .sorted((entry1, entry2) -> {
                    int week1 = Integer.parseInt(entry1.getKey().replaceAll("\\D+", ""));
                    int week2 = Integer.parseInt(entry2.getKey().replaceAll("\\D+", ""));
                    return Integer.compare(week1, week2);
                })
                .map(entry -> new GetAllMatchesResponse(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
}
