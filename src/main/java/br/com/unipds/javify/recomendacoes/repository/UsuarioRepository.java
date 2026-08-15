package br.com.unipds.javify.recomendacoes.repository;

import br.com.unipds.javify.recomendacoes.domain.Usuario;
import br.com.unipds.javify.recomendacoes.dto.RecomendacaoArtista;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepository extends Neo4jRepository<Usuario, Long> {

    @Query("""
            MATCH (usuario:Usuario {id: $usuarioId})-[:SEGUE]->(amigo:Usuario)-[:OUVE]->(artista:Artista)
            WHERE NOT (usuario)-[:OUVE]->(artista)
            RETURN artista.nome as nome, COUNT(amigo) as forcaRecomendacao
            ORDER BY forcaRecomendacao DESC
            LIMIT 5;
            """)
    List<RecomendacaoArtista> recomendacoes(@Param("usuarioId") Long usuarioId);


}
