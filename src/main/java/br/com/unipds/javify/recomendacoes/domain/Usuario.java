package br.com.unipds.javify.recomendacoes.domain;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Node
public record Usuario (
    @Id Long id,

    String nome,

    String email,

    @Relationship(type = "SEGUE", direction = Relationship.Direction.OUTGOING)
    List<Usuario> seguindo,

    @Relationship(type = "OUVE", direction = Relationship.Direction.OUTGOING)
    List<Ouve> artistasOuvidos

) { }
