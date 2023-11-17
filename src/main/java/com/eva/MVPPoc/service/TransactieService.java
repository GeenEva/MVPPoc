package com.eva.MVPPoc.service;

import com.eva.MVPPoc.entity.Transactie;

import java.util.List;

public interface TransactieService {

    List<Transactie> createTransactiesFromTransactieData(List<Transactie> transactieData);

    List<Transactie> getTransactiesByOptieplanNaam(int transactieMomentId);


}
