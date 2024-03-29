package com.rymchaouch.gestion_de_stock.mappers;

import com.rymchaouch.gestion_de_stock.dto.EntrepriseDto;
import com.rymchaouch.gestion_de_stock.models.Entreprise;
import lombok.Builder;
import org.springframework.context.annotation.Bean;

@Bean
@Builder
public class EntrepriseMapper {

    public static EntrepriseDto toEntrepriseDto (Entreprise entreprise) {
        if (entreprise == null) {
            return null;
        }
        return EntrepriseDto.builder()
                .id(entreprise.getId())
                .nom(entreprise.getNom())
                .description(entreprise.getDescription())
                .adresse(AdresseMapper.toAdresseDto((entreprise.getAdresse())))
                .codeFiscal(entreprise.getCodeFiscal())
                .photo(entreprise.getPhoto())
                .email(entreprise.getEmail())
                .numTel(entreprise.getNumTel())
                .siteWeb(entreprise.getSiteWeb())
                .build();
    }

    public static Entreprise toEntreprise(EntrepriseDto entrepriseDto) {
        if (entrepriseDto == null) {
            return null;
        }
        Entreprise entreprise = new Entreprise();
        entreprise.setId(entrepriseDto.id());
        entreprise.setNom(entrepriseDto.nom());
        entreprise.setDescription(entrepriseDto.description());
        entreprise.setAdresse(AdresseMapper.toAdresse(entrepriseDto.adresse()));
        entreprise.setCodeFiscal(entrepriseDto.codeFiscal());
        entreprise.setPhoto(entrepriseDto.photo());
        entreprise.setEmail(entrepriseDto.email());
        entreprise.setNumTel(entrepriseDto.numTel());
        entreprise.setSiteWeb(entrepriseDto.siteWeb());
        return entreprise;
    }
}
