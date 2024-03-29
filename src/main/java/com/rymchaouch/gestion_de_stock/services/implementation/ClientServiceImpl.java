package com.rymchaouch.gestion_de_stock.services.implementation;

import ch.qos.logback.core.net.server.Client;
import com.rymchaouch.gestion_de_stock.dto.CategoryDto;
import com.rymchaouch.gestion_de_stock.dto.ClientDto;
import com.rymchaouch.gestion_de_stock.exceptions.EntityNotFoundException;
import com.rymchaouch.gestion_de_stock.exceptions.ErrorCodes;
import com.rymchaouch.gestion_de_stock.exceptions.InvalidEntityException;
import com.rymchaouch.gestion_de_stock.mappers.ClientMapper;
import com.rymchaouch.gestion_de_stock.repositories.ClientRepository;
import com.rymchaouch.gestion_de_stock.services.CategoryService;
import com.rymchaouch.gestion_de_stock.services.ClientService;
import com.rymchaouch.gestion_de_stock.validators.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;
    private ClientMapper clientMapper;

    @Override
    public ClientDto save(ClientDto dto) {
        List<String> errors = ClientValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Client is not valid {}", dto);
            throw new InvalidEntityException("Le client n'est pas valide", ErrorCodes.CLIENT_NOT_VALID, errors);
        }

        return ClientMapper.toClientDto(
                clientRepository.save(
                        clientMapper.toClient(dto)
                )
        );
    }


    @Override
    public ClientDto findById(Integer id) {
        if (id == null) {
            log.error("Client ID is null");
            return null;
        }
        return clientRepository.findById(id)
                .map(ClientMapper::toClientDto)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun Client avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.CLIENT_NOT_FOUND)
                );
    }



    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream()
                .map(ClientMapper::toClientDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Client ID is null");
            return;
        }
        clientRepository.deleteById(id);
}
}

