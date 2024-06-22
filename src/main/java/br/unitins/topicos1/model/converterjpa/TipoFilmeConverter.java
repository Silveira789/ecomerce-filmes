package br.unitins.topicos1.model.converterjpa;

import br.unitins.topicos1.model.TipoFilme;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TipoFilmeConverter implements AttributeConverter<TipoFilme, Integer>{

    @Override
    public Integer convertToDatabaseColumn(TipoFilme ta) {
        return (ta == null ? null : ta.getId());
    }

    @Override
    public TipoFilme convertToEntityAttribute(Integer id) {
        return TipoFilme.valueOf(id);
    }






}
