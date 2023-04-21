package br.senai.LABMedical.models;

import br.senai.LABMedical.dtos.UsuarioDTO;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario extends Pessoa {
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    private String senha;

    public Usuario(UsuarioDTO usuarioDTO) {
        super.setNome(usuarioDTO.nome());
        super.setGenero(usuarioDTO.genero());
        super.setDataNascimento(usuarioDTO.dataNascimento());
        super.setCpf(usuarioDTO.cpf());
        super.setRg(usuarioDTO.rg());
        super.setEstadoCivil(usuarioDTO.estadoCivil());
        super.setTelefone(usuarioDTO.telefone());
        super.setEmail(usuarioDTO.email());
        super.setNaturalidade(usuarioDTO.naturalidade());
        this.crm = usuarioDTO.crm();
        this.especialidade = usuarioDTO.especialidade();
        this.senha = usuarioDTO.senha();
    }

    public Usuario(Long usuarioId) {
        super.setId(usuarioId);
    }
}
