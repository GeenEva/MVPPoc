package com.eva.MVPPoc.repository;

import com.eva.MVPPoc.entity.Transactie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactieRepository extends JpaRepository<Transactie, Long> {

    @Query(value = "SELECT transactie_id, a.transactie_moment_id, persoon_id, koopt, verkoopt, zet_om, zet_om_van_optieplan" +
            "" +
            " FROM mvppoc.public.transactie\n" +
            "         AS a LEFT JOIN mvppoc.public.transactie_moment AS b\n" +
            "         ON a.transactie_moment_id=b.transactie_moment_id\n" +
            "\n" +
            "            WHERE b.transactie_moment_id =(\n" +
            "                SELECT transactie_moment_id FROM mvppoc.public.transactie_moment\n" +
            "                         AS c LEFT JOIN mvppoc.public.optieplan AS d\n" +
            "                         ON c.optieplan_id=d.optieplan_id\n" +
            "\n" +
            "                         WHERE d.optieplan_naam=?\n" +
            ");", nativeQuery = true)
        List<Transactie> getTransactiesByOptieplanNaam(int optieplanNaam);
}
