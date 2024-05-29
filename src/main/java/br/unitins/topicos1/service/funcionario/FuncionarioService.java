package br.unitins.topicos1.service.funcionario;

import java.util.List;

import br.unitins.topicos1.dto.funcionario.FuncionarioDTO;
import br.unitins.topicos1.dto.funcionario.FuncionarioResponseDTO;




public interface FuncionarioService {
        public FuncionarioResponseDTO insert(FuncionarioDTO dto);

    public FuncionarioResponseDTO update(FuncionarioDTO dto, Long id);

    public void delete(Long id);

    public FuncionarioResponseDTO findById(Long id);

    public List<FuncionarioResponseDTO> findByNome(String nome);

    public List<FuncionarioResponseDTO> findByAll(); 

    public List<FuncionarioResponseDTO> findByMatricula(String matricula);
}
