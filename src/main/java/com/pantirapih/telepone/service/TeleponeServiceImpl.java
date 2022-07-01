package com.pantirapih.telepone.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pantirapih.telepone.dao.TeleponeDao;
import com.pantirapih.telepone.entity.Telepone;
import com.pantirapih.telepone.model.ResponseDto;
import com.pantirapih.telepone.model.SayaResponse;
import com.pantirapih.telepone.model.telepone.TeleponeRequest;
import com.pantirapih.telepone.model.telepone.TeleponeResponse;

@Service
public class TeleponeServiceImpl implements TeleponeService{

    @Autowired
    private TeleponeDao teleponeDao;

    @Override
    public SayaResponse findSiapaSaya() {
        SayaResponse sayaResponse = new SayaResponse();
        sayaResponse.setNama("cahya");
        sayaResponse.setNik("123545669874");
        return sayaResponse;
    }

    @Override
    public ResponseEntity<ResponseDto<Boolean>> simpanTelepone(TeleponeRequest teleponeRequest) {
        ResponseDto<Boolean> responseDto = new ResponseDto<>();
        Telepone telepone = new Telepone();
        telepone.setNama(teleponeRequest.getNama());
        telepone.setNo(teleponeRequest.getNo());
        telepone = teleponeDao.simpanTelepone(telepone);
        responseDto.setStatus(true);
        responseDto.setMessage("Berhasil menyimpan telepone");
        responseDto.setPayload(true);
        return ResponseEntity.ok(responseDto);
    }

    @Override
    public ResponseEntity<ResponseDto<List<TeleponeResponse>>> getAllTelepone() {
        ResponseDto<List<TeleponeResponse>> responseDto = new ResponseDto<>();
        List<Telepone> telepones = teleponeDao.getAllTelepone();
        if (telepones.isEmpty()) {
            responseDto.setStatus(false);
            responseDto.setMessage("Data Tidak Ditemukan");
            responseDto.getErrorMessage().add("Data Telepone tidak ditemukan di basis data");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto);
        }
        List<TeleponeResponse> teleponeResponses = new ArrayList<>();
        for (Telepone telepone : telepones) {
            TeleponeResponse teleponeResponse = new TeleponeResponse();
            teleponeResponse.setId(telepone.getId());
            teleponeResponse.setNama(telepone.getNama());
            teleponeResponse.setNo(telepone.getNo());
            teleponeResponses.add(teleponeResponse);
        }
        responseDto.setStatus(true);
        responseDto.setMessage("Data Telepone berhasil ditemukan");
        responseDto.setPayload(teleponeResponses);
        return ResponseEntity.ok(responseDto);
    }
    
}
