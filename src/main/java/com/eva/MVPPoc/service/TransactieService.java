package com.eva.MVPPoc.service;

import com.eva.MVPPoc.entity.Transactie;

import java.util.List;

public interface TransactieService {

    List<Transactie> getAllTransacties();


    List<Transactie> getTransactieByTransactieMomentId(int transactieMomentId);
}
