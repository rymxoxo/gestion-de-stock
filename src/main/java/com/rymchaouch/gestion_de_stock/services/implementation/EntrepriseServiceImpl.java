package com.rymchaouch.gestion_de_stock.services.implementation;

import com.rymchaouch.gestion_de_stock.dto.EntrepriseDto;
import com.rymchaouch.gestion_de_stock.exceptions.EntityNotFoundException;
import com.rymchaouch.gestion_de_stock.exceptions.ErrorCodes;
import com.rymchaouch.gestion_de_stock.exceptions.InvalidEntityException;
import com.rymchaouch.gestion_de_stock.mappers.EntrepriseMapper;
import com.rymchaouch.gestion_de_stock.repositories.EntrepriseRepository;
import com.rymchaouch.gestion_de_stock.services.EntrepriseService;
import com.rymchaouch.gestion_de_stock.validators.EntrepriseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {
    private EntrepriseRepository entrepriseRepository ;
    private EntrepriseMapper entrepriseMapper ;

    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository, EntrepriseMapper entrepriseMapper) {
        this.entrepriseRepository = entrepriseRepository;
        this.entrepriseMapper = entrepriseMapper;
    }

    @Override
    public EntrepriseDto save(EntrepriseDto dto) {
        List<String> errors = EntrepriseValidator.validate(dto);
       if(!errors.isEmpty())
       {
           log.error("Entreprise Not Valid", dto);
           throw new InvalidEntityException("Entreprise not valid", ErrorCodes.ENTREPRISE_NOT_VALID);
       }
       return EntrepriseMapper.toEntrepriseDto(
               entrepriseRepository.save(EntrepriseMapper.toEntreprise(dto))

       );

    }

    @Override
    public EntrepriseDto findById(Integer id) {
        if(id==null)
        {
            log.error("id not valid");
        }
        return entrepriseRepository.findById(id)
                .map(EntrepriseMapper::toEntrepriseDto)
                .orElseThrow(() ->new InvalidEntityException(
                        " Aucune entreprise avec l'ID =  "+ id  + " n' ete trouve dans la BDD," ,
                                ErrorCodes.ENTREPRISE_NOT_FOUND));

    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseRepository.findAll()
                .stream()
                .map(EntrepriseMapper::toEntrepriseDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Entreprise ID is null");
            return;
        }
        entrepriseRepository.deleteById(id);    }
}
