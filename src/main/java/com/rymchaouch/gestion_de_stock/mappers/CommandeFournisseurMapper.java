package com.rymchaouch.gestion_de_stock.mappers;

import com.rymchaouch.gestion_de_stock.dto.CommandeClientDto;
import com.rymchaouch.gestion_de_stock.dto.CommandeFournisseurDto;
import com.rymchaouch.gestion_de_stock.models.CommandeClient;
import com.rymchaouch.gestion_de_stock.models.CommandeFournisseur;
import org.springframework.stereotype.Service;

@Service
public class CommandeFournisseurMapper {
        public static CommandeFournisseurDto toCommandeFournisseurDto(CommandeFournisseur commandeFournisseur){
            if (commandeFournisseur ==null){
                throw  new NullPointerException("commandeFournisseur does Not exist") ;
            }
            return CommandeFournisseurDto.builder()
                    .id(commandeFournisseur.getId())
                    .code(commandeFournisseur.getCode())
                    .dateDeCommande(commandeFournisseur.getDateDeCommande())
                    .etatCommande(commandeFournisseur.getEtatCommande())
                    .fournisseur(FournisseurMapper.toFournisseurDto(commandeFournisseur.getFournisseur()))
                    .idEntreprise(commandeFournisseur.getIdEntreprise())
                    .build();
        }

        public CommandeFournisseur toCommandeFournisseur (CommandeFournisseurDto commandeFournisseurDto){
            if (commandeFournisseurDto ==null){
                throw  new NullPointerException("commandeFournisseur does Not exist") ;
            }
            var commandeFournisseur = new CommandeFournisseur();
            commandeFournisseur.setId(commandeFournisseurDto.id());
            commandeFournisseur.setCode(commandeFournisseurDto.code());
            commandeFournisseur.setDateDeCommande(commandeFournisseurDto.dateDeCommande());
            commandeFournisseur.setEtatCommande(commandeFournisseurDto.etatCommande());
            commandeFournisseur.setFournisseur(FournisseurMapper.toFournisseur(commandeFournisseurDto.fournisseur()));
            commandeFournisseur.setIdEntreprise(commandeFournisseurDto.idEntreprise());
            return  commandeFournisseur;
        }
}
