package com.noxstudy.document.impl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.noxstudy.document.DocumentService;
import com.noxstudy.document.exception.FileStorageException;
import com.noxstudy.persistent.entity.DocumentEntity;
import com.noxstudy.persistent.repository.DocumentRepository;
import com.noxstudy.validation.SupportType;
import com.noxstudy.validation.ValidationException;
import com.noxstudy.validation.Validator;
import com.noxstudy.validation.ValidatorProvider;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private List<Validator<?>> validators;

    @Value("${photo.path}")
    private String photoPath;

    @Value("${download.url}")
    private String downloadUrl;

    @Autowired
    private ValidatorProvider validatorProvider;

    @Override
    public DocumentEntity storeImage(MultipartFile file) throws ValidationException {

        validatorProvider.executeValidation(file, SupportType.DOCUMENT);

        DocumentEntity documentEntity = new DocumentEntity();

        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        String uniqueFilename = uniqueFilename(filename);
        documentEntity.setFilename(uniqueFilename);

        documentEntity.setFileType(file.getContentType());
        documentEntity.setFileSize(file.getSize());

        storeFileToDirectory(file, uniqueFilename);

        String fileUri = downloadUrl.concat(uniqueFilename);
        fileUri = fileUri.replace("%3F", "?");
        documentEntity.setFileUri(fileUri);

        return documentRepository.create(documentEntity);
    }

    @Override
    public boolean updateImage(MultipartFile file, String filename) throws ValidationException {

        validatorProvider.executeValidation(file, SupportType.DOCUMENT);

        storeFileToDirectory(file, filename);

        return true;
    }

    @Override
    public byte[] loadFileByName(String filename) throws IOException {

        return Files.readAllBytes(Paths.get(String.format("%s\\%s", photoPath, filename)));
    }

    private String uniqueFilename(String filename) {

        Long timeInMillis = Calendar.getInstance().getTimeInMillis();

        return String.format("%s_%s", timeInMillis, filename);
    }

    private void storeFileToDirectory(MultipartFile file, String filename) {

        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, Paths.get(String.format("%s\\%s", photoPath, filename)), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new FileStorageException(String.format("Error while saving image: [%s]", e.getMessage()));
        }
    }
}
