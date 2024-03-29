package com.rymchaouch.gestion_de_stock.mappers;

import com.rymchaouch.gestion_de_stock.dto.FournisseurDto;
import com.rymchaouch.gestion_de_stock.models.Fournisseur;
import lombok.Builder;
import org.springframework.stereotype.Service;

@Service
@Builder
public class FournisseurMapper {
    public static FournisseurDto toFournisseurDto(Fournisseur fournisseur) {
        if (fournisseur == null) {
            return null;
        }
        return FournisseurDto.builder()
                .id(fournisseur.getId())
                .nom(fournisseur.getNom())
                .prenom(fournisseur.getPrenom())
                .adresse(AdresseMapper.toAdresseDto(fournisseur.getAdresse()))
                .photo(fournisseur.getPhoto())
                .mail(fournisseur.getMail())
                .numTel(fournisseur.getNumTel())
                .idEntreprise(fournisseur.getIdEntreprise())
                .build();
    }

    public static Fournisseur toFournisseur (FournisseurDto fournisseurDto) {
        if (fournisseurDto == null) {
            return null;
        }
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(fournisseurDto.id());
        fournisseur.setNom(fournisseurDto.nom());
        fournisseur.setPrenom(fournisseurDto.prenom());
        fournisseur.setAdresse(AdresseMapper.toAdresse(fournisseurDto.adresse()));
        fournisseur.setPhoto(fournisseurDto.photo());
        fournisseur.setMail(fournisseurDto.mail());
        fournisseur.setNumTel(fournisseurDto.numTel());
        fournisseur.setIdEntreprise(fournisseurDto.idEntreprise());
        return fournisseur;
    }
}
