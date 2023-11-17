package com.eva.MVPPoc.service;

import com.eva.MVPPoc.entity.Transactie;
import com.eva.MVPPoc.repository.TransactieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactieServiceImpl implements TransactieService{

     @Autowired
     private TransactieRepository repository;


     @Override
     public List<Transactie> createTransactiesFromTransactieData(List<Transactie> transactieData) {

         return repository.saveAll(transactieData);
     }


     @Override
     public List<Transactie> getTransactiesByOptieplanNaam(int optieplanNaam) {

        return repository.getTransactiesByOptieplanNaam(optieplanNaam);
     }




}
