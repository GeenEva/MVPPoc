package com.eva.MVPPoc.service;

import com.eva.MVPPoc.entity.Certificaat;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CertificaatService {


    public void processAndSafeCertificatenFromCSV(MultipartFile csvFile);

    List<Certificaat> getCertByPersoonId(int persoonId);

    List<Certificaat> getCertificaatRegisterPerOptieplan(int optieplanNaam);
}
