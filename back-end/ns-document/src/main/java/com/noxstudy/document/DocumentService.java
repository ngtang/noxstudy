package com.noxstudy.document;

import org.springframework.web.multipart.MultipartFile;

import com.noxstudy.persistent.entity.DocumentEntity;

public interface DocumentService
{
    DocumentEntity store(MultipartFile file);

    DocumentEntity findById(Long id);
}