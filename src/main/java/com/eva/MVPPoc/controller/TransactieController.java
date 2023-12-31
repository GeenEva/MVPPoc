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


    @GetMapping("/alleTransacties")
    private ResponseEntity getAlleTransacties(){

        return new ResponseEntity<>(transactieService.getAllTransacties(), HttpStatus.OK);
    }





   /* @PostMapping("/create")
    public ResponseEntity createTransacties(@RequestBody List<Transactie> transactieData){

        return new ResponseEntity(transactieService.createTransactiesFromTransactieData(transactieData),HttpStatus.OK);
    }

    @RequestMapping("/getByOptieplanNaam")
    public ResponseEntity getTransactiesByOptieplanNaam(@RequestParam int optieplanNaam){
        return new ResponseEntity<>(transactieService.getTransactiesByOptieplanNaam(optieplanNaam), HttpStatus.OK);
    }

    @PutMapping("/updateToegewezen")
    public ResponseEntity updateToegewezenTransacties(@RequestBody List<Transactie> transactieData){

        return new ResponseEntity((transactieService.updateTransacties(transactieData)), HttpStatus.OK);
    }*/


}
