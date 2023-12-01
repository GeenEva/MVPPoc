package com.eva.MVPPoc.service;

import com.eva.MVPPoc.entity.Certificaat;
import com.eva.MVPPoc.entity.Transactie;
import com.eva.MVPPoc.repository.CertificaatRepository;
import com.eva.MVPPoc.utils.CSVUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

@Service
public class CertificaatServiceImpl implements CertificaatService {

    @Autowired
    CertificaatRepository repository;

    @Override
    public void processAndSafeCertificatenFromCSV(MultipartFile csvFile) {
        if(CSVUtils.hasCsvFormat(csvFile)){
            try {
                List<Certificaat> certificaten = CSVUtils.csvToCertificaten(csvFile.getInputStream());

                // ToDo: (if find alle certificaten is niet null)
                // haal de certificaten op en geef de optieplan_bij_verkoop de waarde van de nieuwe optieplaannaam

                // sla de 'nieuwe' certificaten op (dus zelfde cert_nr maar nieuwe eigenaar)


                repository.saveAll(certificaten);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }


    @Override
    public void muteerCertificatenAanDeHandVanToegewezenTransacties(List<Transactie> toegewezenTransactieList){

        //TODO: certificaten mutatie aan de hand van de toegewezen transacties

        //repository.saveAll(transactieList);
    }

    @Override
    public List<Certificaat> getCertByPersoonId(int persoonId) {
        List<Certificaat> certificaten = repository.getCertByPersoonId(persoonId);
        return certificaten;
    }


    @Override
    public List<Certificaat> getCertificaatRegisterPerOptieplan(int optieplanNaam) {
        List<Certificaat> certificaten = repository.getCertificaatRegisterPerOptieplan(optieplanNaam);
        return certificaten;
    }


}
