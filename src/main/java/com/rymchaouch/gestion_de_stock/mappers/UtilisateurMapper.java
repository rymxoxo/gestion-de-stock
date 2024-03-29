package com.rymchaouch.gestion_de_stock.mappers;

import com.rymchaouch.gestion_de_stock.dto.RolesDto;
import com.rymchaouch.gestion_de_stock.dto.UtilisateurDto;
import com.rymchaouch.gestion_de_stock.models.Utilisateur;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UtilisateurMapper {
    public static UtilisateurDto toUtilisateurDto(Utilisateur utilisateur) {
        if (utilisateur == null) {
            return null;
        }

        return UtilisateurDto.builder()
                .id(utilisateur.getId())
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getPrenom())
                .email(utilisateur.getEmail())
                .motDePasse(utilisateur.getMotDePasse())
                .dateDeNaissance(utilisateur.getDateDeNaissance())
                .adresse(AdresseMapper.toAdresseDto(utilisateur.getAdresse()))
                .photo(utilisateur.getPhoto())
                .roleList(
                        utilisateur.getRoleList() != null ?
                                utilisateur.getRoleList().stream()
                                        .map(RoleMapper::toRolesDto)
                                        .collect(Collectors.toList()) : null
                )
                .build();
    }

    public static Utilisateur toUtilisateur (UtilisateurDto dto) {
        if (dto == null) {
            return null;
        }

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(dto.id());
        utilisateur.setNom(dto.nom());
        utilisateur.setPrenom(dto.prenom());
        utilisateur.setEmail(dto.email());
        utilisateur.setMotDePasse(dto.motDePasse());
        utilisateur.setDateDeNaissance(dto.dateDeNaissance());
        utilisateur.setAdresse(AdresseMapper.toAdresse(dto.adresse()));
        utilisateur.setPhoto(dto.photo());

        return utilisateur;
    }
}
