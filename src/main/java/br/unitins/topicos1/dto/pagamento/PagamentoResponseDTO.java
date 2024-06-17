package br.unitins.topicos1.dto.pagamento;

import br.unitins.topicos1.model.Pagamento;

public record PagamentoResponseDTO(
        long id,
        Double valor,
        String idFormaDePagamento,
        long idPedido,
        String finalizado

) {
    public static PagamentoResponseDTO valueOf(Pagamento pagamento) {

        return new PagamentoResponseDTO(
                pagamento.getId(),
                pagamento.getValor(),
                pagamento.getFormaDePagamento().getLabel(),
                pagamento.getPedido().getId(),
                pagamento.getPedido().isFinalizado() ? "Finalizado" : "Em Aberto");
    }
}