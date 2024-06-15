package br.unitins.topicos1.service.cliente;

import java.util.List;

import br.unitins.topicos1.dto.cliente.ClienteDTO;
import br.unitins.topicos1.dto.cliente.ClienteResponseDTO;



public interface ClienteService {
    
    public ClienteResponseDTO insert(ClienteDTO dto);

    public ClienteResponseDTO update(ClienteDTO dto, Long id);

    public void delete(Long id);

    public ClienteResponseDTO findById(Long id);

    public List<ClienteResponseDTO> findByNome(String nome);

    public List<ClienteResponseDTO> findByAll(); 
    

}