package com.eva.MVPPoc.repository;

import com.eva.MVPPoc.entity.Certificaat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificaatRepository extends JpaRepository<Certificaat, Long> {

    @Query(value = "SELECT * from mvppoc.public.certificaat WHERE persoon_id = ?1", nativeQuery = true)
    List<Certificaat> getCertByPersoonId(int persoonId);


    @Query(value =
            "SELECT DISTINCT ON(a.certificaat_nummer) certificaat_id, certificaat_nummer, persoon_id, a.optieplan_bij_aankoop  From mvppoc.public.certificaat\n" +
                    "AS a\n" +
                    " LEFT JOIN mvppoc.public.optieplan AS b\n" +
                    " ON a.optieplan_bij_aankoop=b.optieplan_id\n" +
                    "\n" +
                    "WHERE b.optieplan_naam<=?1\n" +
                    "\n" +
                    "group by certificaat_id, certificaat_nummer, a.optieplan_bij_aankoop, persoon_id, b.optieplan_id, optieplan_naam\n" +
                    "order by certificaat_nummer, optieplan_naam desc ;", nativeQuery = true)
    List<Certificaat> getCertificaatRegisterPerOptieplan(int optieplanNaam);
}
