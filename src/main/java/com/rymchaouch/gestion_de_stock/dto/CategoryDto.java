package com.rymchaouch.gestion_de_stock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;

import java.util.List;
@Builder
public record CategoryDto(
        Integer id ,
        String code ,
        String designation ,
        Integer idEntreprise,
        @JsonIgnore
        List<ArticleDto> articleDtoList
) {

}
