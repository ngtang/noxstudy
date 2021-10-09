package com.noxstudy.document;

import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

import com.noxstudy.persistent.entity.DocumentEntity;
import com.noxstudy.validation.ValidationException;



public interface DocumentService
{
    DocumentEntity storeImage(MultipartFile file) throws ValidationException;

    boolean updateImage(MultipartFile file, String filename) throws ValidationException;

    byte[] loadFileByName(String filename) throws IOException;
}