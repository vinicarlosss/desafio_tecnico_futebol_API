package desafio.tecnico.com.example.futebolApi.Repository.player;

import desafio.tecnico.com.example.futebolApi.Domain.player.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query("SELECT p FROM Player p WHERE p.team.id = :teamId ORDER BY " +
            "CASE p.position " +
            "WHEN 'Goleiro' THEN 1 " +
            "WHEN 'Lateral esquerdo' THEN 2 " +
            "WHEN 'Zagueiro' THEN 3 " +
            "WHEN 'Lateral direito' THEN 4 " +
            "WHEN 'Lateral' THEN 5 " +
            "WHEN 'Zagueiro central' THEN 6 " +
            "WHEN 'Volante' THEN 7 " +
            "WHEN 'Meio-campista Central' THEN 8 " +
            "WHEN 'Meio-campista Esquerdo' THEN 9 " +
            "WHEN 'Meio-campista Direito' THEN 10 " +
            "WHEN 'Meio-campista Aberto' THEN 11 " +
            "WHEN 'Meio campo' THEN 12 " +
            "WHEN 'Meio-campista Ofensivo' THEN 13 " +
            "WHEN 'Ponta Esquerdo' THEN 14 " +
            "WHEN 'Ponta Direito' THEN 15 " +
            "WHEN 'Atacante' THEN 16 " +
            "ELSE 17 END")
    List<Player> findByTeamIdOrderByPosition(@Param("teamId") Long teamId);
}
