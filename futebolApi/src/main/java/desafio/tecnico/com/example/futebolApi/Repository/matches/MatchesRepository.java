package desafio.tecnico.com.example.futebolApi.Repository.matches;

import desafio.tecnico.com.example.futebolApi.Domain.matches.Matches;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchesRepository extends JpaRepository<Matches, Long> {

    List<Matches> findByTeamId(Long teamId);
}
