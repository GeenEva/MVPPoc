package com.eva.MVPPoc.repository;

import com.eva.MVPPoc.entity.Certificaat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificaatRepository extends JpaRepository<Certificaat, Long> {
}
