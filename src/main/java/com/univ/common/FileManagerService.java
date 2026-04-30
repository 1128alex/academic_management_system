package com.univ.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManagerService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${app.upload.path:/app/images/}")
	private String fileUploadPath;

	public String getFileUploadPath() {
		return fileUploadPath;
	}

	public String saveFile(String email, MultipartFile file) {
		String directoryName = email + "_" + System.currentTimeMillis() + "/";
		String filePath = fileUploadPath + directoryName;

		File directory = new File(filePath);
		if (directory.mkdir() == false) {
			return null;
		}

		// file upload: in bytes
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(filePath + file.getOriginalFilename().replace(" ", "_"));
			Files.write(path, bytes);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

		// http://localhost/images/aaaa_1630213213/sun.png
		return "/images/" + directoryName + file.getOriginalFilename().replace(" ", "_");
	}

	public void deleteFile(String filePath) { // filePath
		Path path = Paths.get(fileUploadPath + filePath.replace("/images/", ""));
		if (Files.exists(path)) {
			// delete file
			try {
				Files.delete(path);
			} catch (IOException e) {
				logger.error("[Image delete] Failed to delete image. imagePath:{}", filePath);
			}
			// delete directory folder
			path = path.getParent();
			if (Files.exists(path)) {
				try {
					Files.delete(path);
				} catch (IOException e) {
					logger.error("[Image delete] Failed to delete directory folder. imagePath:{}", filePath);
				}
			}
		}
	}
}
