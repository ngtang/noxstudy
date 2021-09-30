package com.noxstudy.persistent.repository.impl;
import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.noxstudy.persistent.entity.DocumentEntity;
import com.noxstudy.persistent.repository.AbstractGenericDao;
import com.noxstudy.persistent.repository.DocumentRepository;

@Repository
public class DocumentRepositoryImpl extends AbstractGenericDao<DocumentEntity> implements DocumentRepository
{
    @PostConstruct
    public void init()
    {
        super.setClazz(DocumentEntity.class);
    }
}
