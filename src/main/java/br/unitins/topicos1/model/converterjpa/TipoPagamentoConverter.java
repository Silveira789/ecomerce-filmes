package br.unitins.topicos1.model.converterjpa;

import br.unitins.topicos1.model.TipoPagamento;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TipoPagamentoConverter implements AttributeConverter<TipoPagamento, Integer> {

    @Override
    public Integer convertToDatabaseColumn(TipoPagamento tp) {
        return (tp == null ? null : tp.getId());
    }

    @Override
    public TipoPagamento convertToEntityAttribute(Integer id) {
        return TipoPagamento.valueOf(id);
    }

}
