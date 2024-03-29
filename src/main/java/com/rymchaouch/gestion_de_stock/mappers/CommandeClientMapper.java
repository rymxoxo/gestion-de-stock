package com.rymchaouch.gestion_de_stock.mappers;

import com.rymchaouch.gestion_de_stock.dto.ClientDto;
import com.rymchaouch.gestion_de_stock.dto.CommandeClientDto;
import com.rymchaouch.gestion_de_stock.models.Client;
import com.rymchaouch.gestion_de_stock.models.CommandeClient;
import org.springframework.stereotype.Service;

@Service
public class CommandeClientMapper {
    public CommandeClientDto toCommandeClientDto(CommandeClient commandeClient){
        if (commandeClient ==null){
            throw  new NullPointerException("commandeClient does Not exist") ;
        }
        return CommandeClientDto.builder()
                .id(commandeClient.getId())
                .code(commandeClient.getCode())
                .dateDeCommande(commandeClient.getDateDeCommande())
                .etatCommande(commandeClient.getEtatCommande())
                .client(ClientMapper.toClientDto(commandeClient.getClient()))
                .idEntreprise(commandeClient.getIdEntreprise())
                .build();
    }

    public CommandeClient toCommandeClient (CommandeClientDto commandeClientDto){
        if (commandeClientDto ==null){
            throw  new NullPointerException("commandeClientDto does Not exist") ;
        }
        var commandeClient = new CommandeClient();
        commandeClient.setId(commandeClientDto.id());
        commandeClient.setCode(commandeClientDto.code());
        commandeClient.setDateDeCommande(commandeClientDto.dateDeCommande());
        commandeClient.setEtatCommande(commandeClientDto.etatCommande());
        commandeClient.setIdEntreprise(commandeClientDto.idEntreprise());


        return  commandeClient;
    }
}
