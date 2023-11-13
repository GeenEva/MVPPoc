package com.eva.MVPPoc.service;

import com.eva.MVPPoc.entity.Certificaat;
import com.eva.MVPPoc.entity.Optieplan;
import com.eva.MVPPoc.entity.Persoon;
import com.eva.MVPPoc.repository.CertificaatRepository;
import com.eva.MVPPoc.utils.CSVUtils;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
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
                repository.saveAll(certificaten);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
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
