package br.unitins.topicos1.dto.cartao;

import java.time.LocalDate;

import br.unitins.topicos1.model.BandeiraCartao;
import br.unitins.topicos1.model.Cartao;
import br.unitins.topicos1.model.TipoCartao;



public record CartaoResponseDTO(
        Long id,
        String banco,
        String numero,
        LocalDate dataVencimento,
        String codVerificacao,
        String nomeTitular,
        TipoCartao tipoCartao,
        BandeiraCartao bandeiraCartao) {
    public static CartaoResponseDTO valueOf(Cartao cartao) {
        return new CartaoResponseDTO(
                cartao.getId(),
                cartao.getBanco(),
                cartao.getNumero(),
                cartao.getDataVencimento(),
                cartao.getCodVerificacao(),
                cartao.getNomeTitular(),
                cartao.getTipoCartao(),
                cartao.getBandeiraCartao());
    }
}