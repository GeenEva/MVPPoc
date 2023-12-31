package com.eva.MVPPoc.utils;

import com.eva.MVPPoc.entity.Certificaat;
import com.eva.MVPPoc.entity.Optieplan;
import com.eva.MVPPoc.entity.Persoon;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {


    public static boolean hasCsvFormat(MultipartFile csvFile) {
        if(!"text/csv".equals(csvFile.getContentType())){
            System.out.println("this is not a csv file");
            return false;}
        return true;
    }


    public static List<Certificaat> csvToCertificaten(InputStream inputStream) {
        List<Certificaat> certificaten = new ArrayList<>();

        try (BufferedReader fileReader = new BufferedReader(
                new InputStreamReader(inputStream, "UTF-8"));

             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT
                     .builder()
                     .setHeader("certificaatNummer", "persoonId", "optieplanId")
                     .setSkipHeaderRecord(true)
                     .setDelimiter(";")
                     .setIgnoreHeaderCase(true)
                     .build())
        ) {
            List<CSVRecord> records = csvParser.getRecords();
            for (CSVRecord csvRecord : records) {
                Persoon persoon = new Persoon();
                persoon.setPersoonId(Long.parseLong(csvRecord.get("persoonId")));
                Optieplan optieplan = new Optieplan();
                optieplan.setOptieplanId(Long.parseLong(csvRecord.get("optieplanID")));

                Certificaat certificaat =  new Certificaat();
                certificaat.setPersoon(persoon);
                certificaat.setOptieplanBijAankoop(optieplan);
                certificaat.setCertificaatNummer(Integer.parseInt(csvRecord.get("certificaatNummer")));

                certificaten.add(certificaat);
            }

            return certificaten;
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

}
