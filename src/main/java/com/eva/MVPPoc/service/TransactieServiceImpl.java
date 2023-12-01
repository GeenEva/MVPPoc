package com.eva.MVPPoc.service;

import com.eva.MVPPoc.entity.Transactie;
import com.eva.MVPPoc.repository.TransactieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactieServiceImpl implements TransactieService{

     @Autowired
     private TransactieRepository repository;


    @Override
    public List<Transactie> getAllTransacties() {
        return repository.findAll();
    }



    @Override
     public List<Transactie> createTransactiesFromTransactieData(List<Transactie> transactieData) {

         return repository.saveAll(transactieData);
     }


     @Override
     public List<Transactie> getTransactiesByOptieplanNaam(int optieplanNaam) {

        return repository.getTransactiesByOptieplanNaam(optieplanNaam);
     }

    @Override
    public List<Transactie> updateTransacties(List<Transactie> transactieData) {
        //TODO: stoute Optional negerende code aanpassen
        return repository.saveAll(
                 transactieData.stream()
                         .map(transactie -> {
                             Transactie byId = repository.findById(transactie.getTransactieId()).get();
                             byId.setTypeToewijzing(transactie.getTypeToewijzing());
                             byId.setAantal(transactie.getAantal());
                             byId.setOptieplan(transactie.getOptieplan());
                             byId.setPersoon(transactie.getPersoon());
                             byId.setZetOmVanOptieplan(transactie.getZetOmVanOptieplan());
                            return byId;
                         })
                 .collect(Collectors.toList()));
    }

}
