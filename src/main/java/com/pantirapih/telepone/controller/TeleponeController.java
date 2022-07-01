package com.pantirapih.telepone.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.pantirapih.telepone.model.ResponseDto;
import com.pantirapih.telepone.model.SayaResponse;
import com.pantirapih.telepone.model.telepone.TeleponeRequest;
import com.pantirapih.telepone.model.telepone.TeleponeResponse;
import com.pantirapih.telepone.service.TeleponeService;

@RestController
@RequestMapping("/data-pegawai/telepone")
public class TeleponeController {

    @Autowired
    private TeleponeService teleponeService;


    @GetMapping("/helo-word")
    public ResponseEntity<String> name() {
        return ResponseEntity.ok("HELLO WORD AAAAAAAAAAAAA");
    }
    
    @GetMapping("/siapa-saya")
    public ResponseEntity<SayaResponse> siapaSaya() {
        SayaResponse sayaResponse = teleponeService.findSiapaSaya();
        return ResponseEntity.ok().body(sayaResponse);
    }
    


    //-------------------------------------------------------------------------
    
    //localhost:8080/data-pegawai/telepone/10
    
    //localhost:8080/data-pegawai/telepone?nama=cahya
    
    //-------------------------------------------------------------------------



    //endpoint: baseUrl/data-pegawai/telepone   -> POST
    @PostMapping()
    public ResponseEntity<ResponseDto<Boolean>> simpanTelepone(@RequestBody @Valid TeleponeRequest teleponeRequest,  final Errors errors, final UriComponentsBuilder uriComponentsBuilder) {
        ResponseDto<Boolean> responseDto =  new ResponseDto<>();
        if (errors.hasErrors()) {
			responseDto.setStatus(true);
			responseDto.setMessage("Gagal simpan Telepone");
			for (ObjectError error : errors.getAllErrors()) {
				responseDto.getErrorMessage().add(error.getDefaultMessage());
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDto);
		}
        return teleponeService.simpanTelepone(teleponeRequest);
    }

    @GetMapping()
    public ResponseEntity<ResponseDto<List<TeleponeResponse>>> getAllTelepone() {
        return teleponeService.getAllTelepone();
    }
    

}
