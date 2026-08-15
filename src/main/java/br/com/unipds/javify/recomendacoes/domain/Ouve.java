package br.com.unipds.javify.recomendacoes.domain;

import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
public record Ouve(
        @RelationshipId String id,
        @TargetNode Artista artista,
        int vezesTocadas
) {
}
