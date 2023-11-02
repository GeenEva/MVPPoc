package com.eva.MVPPoc.service;

import com.eva.MVPPoc.entity.Certificaat;
import com.eva.MVPPoc.repository.CertificaatRepository;
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
    public boolean hasCsvFormat(MultipartFile csvFile) {
        if(!"text/csv".equals(csvFile.getContentType())){
            System.out.println("this is not a csv file");
            return false;}
        return true;
    }

    @Override
    public void processAndSafeData(MultipartFile csvFile) {

        try {
            List<Certificaat> certificaten = csvToCertificaten(csvFile.getInputStream());
            repository.saveAll(certificaten);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private List<Certificaat> csvToCertificaten(InputStream inputStream) {
        List<Certificaat> certificaten = new ArrayList<>();

        try (BufferedReader fileReader = new BufferedReader(
                new InputStreamReader(inputStream, "UTF-8"));

             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT
                     .builder()
                     .setHeader("certificaatNummer", "persoonId")
                     .setSkipHeaderRecord(true)
                     .setDelimiter(";")
                     .setIgnoreHeaderCase(true)
                     .build())
        ) {
            List<CSVRecord> records = csvParser.getRecords();
            for (CSVRecord csvRecord : records) {
                Certificaat certificaat = new Certificaat(
                        Integer.parseInt(csvRecord.get("certificaatNummer")),
                        Long.parseLong(csvRecord.get("persoonId")));
                certificaten.add(certificaat);
            }

            return certificaten;
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
