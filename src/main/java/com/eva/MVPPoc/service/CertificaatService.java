package com.eva.MVPPoc.service;

import org.springframework.web.multipart.MultipartFile;

public interface CertificaatService {
    boolean hasCsvFormat(MultipartFile csvFile);

    void processAndSafeData(MultipartFile csvFile);
}
