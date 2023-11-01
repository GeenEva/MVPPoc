package com.eva.MVPPoc.service;

import com.eva.MVPPoc.entity.Certificaat;
import com.eva.MVPPoc.repository.CertificaatRepository;
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
            return false;}
        return false;
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
        try { BufferedReader fileReader =
            new BufferedReader( new InputStreamReader(inputStream, "UTF-8") );


            //todo implement

            /*
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT
                     .builder().setSkipHeaderRecord(true)
                     .setHeader("Index","Jaar","Maand","Optieplan")
                     .setSkipHeaderRecord(true)
                     .setDelimiter(";")
                     .setIgnoreHeaderCase(true)
                     .build())) {
            List<MaandCijfer> maandCijfers = new ArrayList<>();
            List<CSVRecord> records = csvParser.getRecords();
            for (CSVRecord csvRecord : records){
                MaandCijfer maandCijfer =
                        new MaandCijfer(Long.parseLong(csvRecord.get("Index")),
                                csvRecord.get("Jaar"), csvRecord.get("Maand"),
                                csvRecord.get("Optieplan"));
                maandCijfers.add(maandCijfer);
            }
            return maandCijfers;
             */




        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }


        return certificaten;
    }
}
