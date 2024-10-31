package desafio.tecnico.com.example.futebolApi.Repository.team;

import desafio.tecnico.com.example.futebolApi.Domain.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {

    List<Team> findAllByOrderByPositionAsc();
}
