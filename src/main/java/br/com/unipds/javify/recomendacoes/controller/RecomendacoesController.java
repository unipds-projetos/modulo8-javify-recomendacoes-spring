package br.com.unipds.javify.recomendacoes.controller;

import br.com.unipds.javify.recomendacoes.dto.RecomendacaoArtista;
import br.com.unipds.javify.recomendacoes.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recomendacoes")
public class RecomendacoesController {

    private final UsuarioRepository repository;

    public RecomendacoesController(UsuarioRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/artistas/{usuarioId}")
    public ResponseEntity<List<RecomendacaoArtista>> obterRadarDeNovidades(@PathVariable Long usuarioId) {
        List<RecomendacaoArtista> recomendacoes = repository.recomendacoes(usuarioId);
        return ResponseEntity.ok(recomendacoes);
    }

}