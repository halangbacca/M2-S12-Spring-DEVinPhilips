package br.senai.LABMedical.services;

import br.senai.LABMedical.dtos.UsuarioDTO;
import br.senai.LABMedical.models.Usuario;
import br.senai.LABMedical.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void cadastra(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario(usuarioDTO);
        repository.save(usuario);
    }

}
