package com.eva.MVPPoc.service;

import com.eva.MVPPoc.entity.Certificaat;
import com.eva.MVPPoc.entity.Transactie;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CertificaatService {


    void processAndSafeCertificatenFromCSV(MultipartFile csvFile);

    void muteerCertificatenAanDeHandVanToegewezenTransacties(List<Transactie> transactieList);

    List<Certificaat> getCertByPersoonId(int persoonId);

    List<Certificaat> getCertificaatRegisterPerOptieplan(int optieplanNaam);
}
