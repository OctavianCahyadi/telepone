package com.pantirapih.telepone.dao;

import java.util.List;

import com.pantirapih.telepone.entity.Telepone;

public interface TeleponeDao {

    Telepone simpanTelepone(Telepone telepone);

    List<Telepone> getAllTelepone();
    
}
