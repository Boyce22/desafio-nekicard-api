package br.com.nekicard.api.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {

	@Value("${nekicard.directory.image-save}")
	String imagePath;

	public String saveImage(MultipartFile imageFile) {
	    LocalDateTime dateTimePublished = LocalDateTime.now();

	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss")
	            .withResolverStyle(ResolverStyle.STRICT);

	    String fileNameToSave = "_image_profile" + dateTimePublished.format(formatter)
	            + imageFile.getOriginalFilename();

	    try {
	        Path uploadPath = Paths.get(imagePath);
	        Path filePath = uploadPath.resolve(fileNameToSave);

	        Files.createDirectories(uploadPath);
	        Files.write(filePath, imageFile.getBytes());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return imagePath.replace(File.separator, "/") + "/" + fileNameToSave;
	}
}
