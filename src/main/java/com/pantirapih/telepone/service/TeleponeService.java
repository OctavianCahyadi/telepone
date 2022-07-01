package com.pantirapih.telepone.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.pantirapih.telepone.model.ResponseDto;
import com.pantirapih.telepone.model.SayaResponse;
import com.pantirapih.telepone.model.telepone.TeleponeRequest;
import com.pantirapih.telepone.model.telepone.TeleponeResponse;

public interface TeleponeService {

    SayaResponse findSiapaSaya();

    ResponseEntity<ResponseDto<Boolean>> simpanTelepone(TeleponeRequest teleponeRequest);

    ResponseEntity<ResponseDto<List<TeleponeResponse>>> getAllTelepone();
    
}
