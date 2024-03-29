package com.rymchaouch.gestion_de_stock.mappers;

import com.rymchaouch.gestion_de_stock.dto.VentesDto;
import com.rymchaouch.gestion_de_stock.models.Ventes;

public class VenteMapper {

    public static VentesDto toVentesDto(Ventes vente) {
        if (vente == null) {
            return null;
        }
        return VentesDto.builder()
                .id(vente.getId())
                .code(vente.getCode())
                .commentaire(vente.getCommentaire())
                .idEntreprise(vente.getIdEntreprise())
                .build();
    }

    public static Ventes toVentes(VentesDto ventesDto) {
        if (ventesDto == null) {
            return null;
        }
        Ventes ventes = new Ventes();
        ventes.setId(ventesDto.id());
        ventes.setCode(ventesDto.code());
        ventes.setCommentaire(ventesDto.commentaire());
        ventes.setIdEntreprise(ventesDto.idEntreprise());
        return ventes;
    }
}
