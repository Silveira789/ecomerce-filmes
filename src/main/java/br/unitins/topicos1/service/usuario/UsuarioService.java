package br.unitins.topicos1.service.usuario;

import java.util.List;

import br.unitins.topicos1.dto.usuario.AlterarLoginUsuarioDTO;
import br.unitins.topicos1.dto.usuario.AlterarSenhaUsuarioDTO;
import br.unitins.topicos1.dto.usuario.UsuarioDTO;
import br.unitins.topicos1.dto.usuario.UsuarioResponseDTO;
import jakarta.validation.Valid;


public interface UsuarioService {

    public UsuarioResponseDTO insert(UsuarioDTO dto);

    public UsuarioResponseDTO update(UsuarioDTO dto, Long id);

    public UsuarioResponseDTO alterarSenha(AlterarSenhaUsuarioDTO alterarSenhaUsuarioDTO, String senha);
    public UsuarioResponseDTO alterarLogin(AlterarLoginUsuarioDTO alterarLoginUsuarioDTO, String login);

    public void delete(Long id);

    public UsuarioResponseDTO findById(Long id);

    public List<UsuarioResponseDTO> findByNome(String nome);

    public UsuarioResponseDTO findByLoginAndSenha(String login, String senha);

    public UsuarioResponseDTO findByLogin(String login);

    public List<UsuarioResponseDTO> findByAll();
    
    public UsuarioResponseDTO findMyUser();

}