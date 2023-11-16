package com.eva.MVPPoc.controller;

import com.eva.MVPPoc.entity.Transactie;
import com.eva.MVPPoc.service.TransactieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactie")
public class TransactieController {

    @Autowired
    private TransactieService transactieService;


    @GetMapping("/transacties")
    public ResponseEntity<List<Transactie>> allTransacties(){
        return new ResponseEntity<>(transactieService.getAllTransacties(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity createTransactie(@RequestParam int persoonId, @RequestBody Transactie transactie){

    //todo implement

        return new ResponseEntity(HttpStatus.OK);
    }

  /*  TODO: IMPLEMENT THIS FUNCTIONALITY
  @RequestMapping("/getByTransactieMomentId")
    public ResponseEntity<List<Transactie>> getTransactiesByTransactieMomentId(@RequestParam int transactieMomentId){
        return new ResponseEntity<>(transactieService.getTransactieByTransactieMomentId(transactieMomentId), HttpStatus.OK);
    }*/


}
