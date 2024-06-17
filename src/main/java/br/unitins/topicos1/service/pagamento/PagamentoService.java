package br.unitins.topicos1.service.pagamento;

import java.util.List;

import br.unitins.topicos1.dto.pagamento.PagamentoDTO;
import br.unitins.topicos1.dto.pagamento.PagamentoResponseDTO;

public interface PagamentoService {

    public PagamentoResponseDTO insert(PagamentoDTO dto);

    public List<PagamentoResponseDTO> findByAll();

    public PagamentoResponseDTO findById(Long id);
}