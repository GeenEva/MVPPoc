package com.eva.MVPPoc.service;

import com.eva.MVPPoc.entity.Certificaat;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CertificaatService {
    boolean hasCsvFormat(MultipartFile csvFile);

    void processAndSafeData(MultipartFile csvFile);

    List<Certificaat> getCertByPersoonId(int persoonId);
}
