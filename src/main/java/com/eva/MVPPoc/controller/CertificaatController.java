package com.eva.MVPPoc.controller;

import com.eva.MVPPoc.entity.Certificaat;
import com.eva.MVPPoc.service.CertificaatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/certificaten")
public class CertificaatController {


    @Autowired
    private CertificaatService certificaatService;

    @GetMapping("/byPersoonId")
    public ResponseEntity<List<Certificaat>> getCertificaatByPersoonId(@RequestParam int persoonId){
        List<Certificaat> allCertificatenVanPersoon = certificaatService.getCertByPersoonId(persoonId);
        return new ResponseEntity<>(allCertificatenVanPersoon, HttpStatus.OK);
    }


    @RequestMapping("/uploadCertificaten")
    public ResponseEntity<HttpEntity> uploadCertificatenRegister(
            @RequestParam("csvFile")MultipartFile csvFile){
        if(certificaatService.hasCsvFormat(csvFile)){

            certificaatService.processAndSafeData(csvFile);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(new HttpEntity<>("Certificaten opgeslagen in de database"));
        }
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                .body(new HttpEntity("Failed to save certificaten to the database"));
    }




}
