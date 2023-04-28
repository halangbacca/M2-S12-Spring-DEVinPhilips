package br.senai.LABMedical.controllers;

import br.senai.LABMedical.dtos.AtualizaSenhaUsuario;
import br.senai.LABMedical.dtos.AtualizaUsuario;
import br.senai.LABMedical.dtos.UsuarioDTO;
import br.senai.LABMedical.models.Usuario;
import br.senai.LABMedical.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastra(@RequestBody @Validated UsuarioDTO usuarioDTO, UriComponentsBuilder builder) {
        Usuario usuario = service.cadastra(usuarioDTO);

        URI uri = builder.path("/api/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualiza(@RequestBody @Validated AtualizaUsuario usuarioAtualizado, @PathVariable Long id) {
        return ResponseEntity.ok(service.atualiza(usuarioAtualizado, id));
    }

    @PutMapping("/{id}/senha")
    public ResponseEntity<Usuario> atualizaSenha(@RequestBody @Validated AtualizaSenhaUsuario senhaAtualizada, @PathVariable Long id) {
        return ResponseEntity.ok(service.atualiza(senhaAtualizada, id));
    }

}
