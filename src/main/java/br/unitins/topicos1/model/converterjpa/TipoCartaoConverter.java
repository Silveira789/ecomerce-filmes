package br.unitins.topicos1.model.converterjpa;

import br.unitins.topicos1.model.TipoCartao;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TipoCartaoConverter  implements AttributeConverter<TipoCartao, Integer>{

    @Override
    public Integer convertToDatabaseColumn(TipoCartao tc) {
        return (tc == null ? null : tc.getId());
    }

    @Override
    public TipoCartao convertToEntityAttribute(Integer id) {
        return TipoCartao.valueOf(id);
    }
    
}
