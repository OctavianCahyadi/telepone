package com.pantirapih.telepone.model.telepone;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class TeleponeRequest {
    @NotBlank(message = "Nama tidak boleh kosong")
    private String nama;
    @NotBlank(message = "Nomor tidak boleh kosong")
    private String no;
}
