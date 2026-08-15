package br.com.unipds.javify.recomendacoes.domain;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public record Artista (

        @Id String id,

        String nome

) { }
