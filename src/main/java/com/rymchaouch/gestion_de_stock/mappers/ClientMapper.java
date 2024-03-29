package com.rymchaouch.gestion_de_stock.mappers;

import com.rymchaouch.gestion_de_stock.dto.ArticleDto;
import com.rymchaouch.gestion_de_stock.dto.ClientDto;
import com.rymchaouch.gestion_de_stock.models.Article;
import com.rymchaouch.gestion_de_stock.models.Client;
import lombok.Builder;

@Builder
public class ClientMapper {

    public static ClientDto toClientDto(Client client){
        if (client ==null){
            throw  new NullPointerException("Client does Not exist") ;
        }
        return ClientDto.builder()
                .id(client.getId())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .mail(client.getMail())
                .photo(client.getPhoto())
                .numTel(client.getNumTel())
                .adresse(AdresseMapper.toAdresseDto(client.getAdresse()))
                .build();
    }

    public Client toClient (ClientDto clientDto){
        if (clientDto ==null){
            throw  new NullPointerException("clientDto does Not exist") ;
        }
        var client = new Client();
        client.setId(clientDto.id());
        client.setNom(clientDto.nom());
        client.setPrenom(clientDto.prenom());
        client.setMail(clientDto.mail());
        client.setPhoto(clientDto.photo());
        client.setNumTel(clientDto.numTel());
        client.setAdresse(AdresseMapper.toAdresse(clientDto.adresse()));
        return  client;
    }

}
