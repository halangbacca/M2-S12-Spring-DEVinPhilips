package br.senai.LABMedical.services;

import br.senai.LABMedical.dtos.AtualizaSenhaUsuario;
import br.senai.LABMedical.dtos.AtualizaUsuarios;
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

    public void atualiza(AtualizaUsuarios usuarioAtualizado, Long id) {
        Usuario usuario = repository.findById(id).orElseThrow(RuntimeException::new);

        if (usuarioAtualizado.nome() != null && !usuarioAtualizado.nome().isEmpty()) {
            usuario.setNome(usuarioAtualizado.nome());
        }

        if (usuarioAtualizado.genero() != null && !usuarioAtualizado.genero().isEmpty()) {
            usuario.setGenero(usuarioAtualizado.genero());
        }

        if (usuarioAtualizado.dataNascimento() != null) {
            usuario.setDataNascimento(usuarioAtualizado.dataNascimento());
        }

        if (usuarioAtualizado.estadoCivil() != null) {
            usuario.setEstadoCivil(usuarioAtualizado.estadoCivil());
        }

        if (usuarioAtualizado.telefone() != null && !usuarioAtualizado.telefone().isEmpty()) {
            usuario.setTelefone(usuarioAtualizado.telefone());
        }

        if (usuarioAtualizado.email() != null && !usuarioAtualizado.email().isEmpty()) {
            usuario.setEmail(usuarioAtualizado.email());
        }

        if (usuarioAtualizado.naturalidade() != null && !usuarioAtualizado.naturalidade().isEmpty()) {
            usuario.setNaturalidade(usuarioAtualizado.naturalidade());
        }

        if (usuarioAtualizado.crm() != null && !usuarioAtualizado.crm().isEmpty()) {
            usuario.setCrm(usuarioAtualizado.crm());
        }

        if (usuarioAtualizado.especialidade() != null) {
            usuario.setEspecialidade(usuarioAtualizado.especialidade());
        }

        repository.save(usuario);
    }

    public void atualiza(AtualizaSenhaUsuario senhaAtualizada, Long id) {
        Usuario usuario = repository.findById(id).orElseThrow(RuntimeException::new);

        if (senhaAtualizada.senha() != null && !senhaAtualizada.senha().isEmpty()) {
            usuario.setSenha(senhaAtualizada.senha());
        }

        repository.save(usuario);
    }

}
