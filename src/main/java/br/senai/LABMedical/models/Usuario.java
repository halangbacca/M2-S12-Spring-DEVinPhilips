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
        super.setNome(usuarioDTO.getNome());
        super.setGenero(usuarioDTO.getGenero());
        super.setDataNascimento(usuarioDTO.getDataNascimento());
        super.setCpf(usuarioDTO.getCpf());
        super.setRg(usuarioDTO.getRg());
        super.setEstadoCivil(usuarioDTO.getEstadoCivil());
        super.setTelefone(usuarioDTO.getTelefone());
        super.setEmail(usuarioDTO.getEmail());
        super.setNaturalidade(usuarioDTO.getNaturalidade());
        this.crm = usuarioDTO.getCrm();
        this.especialidade = usuarioDTO.getEspecialidade();
        this.senha = usuarioDTO.getSenha();
    }

}
