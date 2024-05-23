package br.unitins.topicos1.model.converterjpa;


import br.unitins.topicos1.model.BandeiraCartao;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class BandeiraCartaoConverter implements AttributeConverter<BandeiraCartao, Integer>{

    @Override
    public Integer convertToDatabaseColumn(BandeiraCartao bandeiraCartao) {
        return (bandeiraCartao == null ? null : bandeiraCartao.getId());
    }

    @Override
    public BandeiraCartao convertToEntityAttribute(Integer id) {
        return BandeiraCartao.valueOf(id);
    }
    
}
