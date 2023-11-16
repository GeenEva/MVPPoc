package com.eva.MVPPoc.repository;

import com.eva.MVPPoc.entity.Transactie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactieRepository extends JpaRepository<Transactie, Long> {


//List<Transactie> getTransactieByTransactieMomentId(int transactieMomentId);
}
