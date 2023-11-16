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
     public List<Transactie> getAllTransacties() {
         return repository.findAll();
     }

    @Override
    public List<Transactie> getTransactieByTransactieMomentId(int transactieMomentId) {
       // repository.getTransactieByTransactieMomentId(transactieId);
        return null;
    }


}
