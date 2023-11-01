package com.eva.MVPPoc.controller;

import com.eva.MVPPoc.entity.Transactie;
import com.eva.MVPPoc.service.TransactieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactieController {

    @Autowired
    private TransactieService transactieService;

    @RequestMapping("/transacties")
    public ResponseEntity<Transactie> getAllTransacties(){
        transactieService.getAllTransacties();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
