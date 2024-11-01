package desafio.tecnico.com.example.futebolApi.Repository.matches;

import desafio.tecnico.com.example.futebolApi.Domain.matches.Matches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MatchesRepository extends JpaRepository<Matches, Long> {

    List<Matches> findByTeamId(Long teamId);
    @Query("SELECT m FROM Matches m WHERE m.venue = 'Casa' ORDER BY m.round, m.date")
    List<Matches> findHomeMatches();
}
