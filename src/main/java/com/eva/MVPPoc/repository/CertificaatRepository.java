package com.eva.MVPPoc.repository;

import com.eva.MVPPoc.entity.Certificaat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificaatRepository extends JpaRepository<Certificaat, Long> {

    @Query(value = "SELECT * from CERTIFICAAT WHERE persoon_id = ?1", nativeQuery = true)
    List<Certificaat> getCertByPersoonId(int persoonId);



}
