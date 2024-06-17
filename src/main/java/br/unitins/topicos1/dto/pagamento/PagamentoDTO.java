package br.unitins.topicos1.dto.pagamento;



import br.unitins.topicos1.model.Pagamento;


public record PagamentoDTO(
        Double valor,
        int idFormaDePagamento,
        long idPedido

) {
    public static PagamentoDTO valueOf(Pagamento pagamento) {
        return new PagamentoDTO(
                pagamento.getValor(),
                pagamento.getFormaDePagamento().getId(),
                pagamento.getPedido().getId());
    }
}
