package com.jpa.springbootweb.helper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	public boolean uploadFile(MultipartFile file) {
		String destinationPath="C:\\Users\\punit\\OneDrive\\Desktop\\SpringBoot\\MyWorkSpace\\bootwebexample\\src\\main\\resources\\static\\uploadedFile"+File.separator+file.getOriginalFilename();
		try(InputStream fin=file.getInputStream();
				OutputStream fout=Files.newOutputStream(Paths.get(destinationPath))){
			byte[] buffer = new byte[8192]; // Buffer size can be adjusted
			int bytesRead; 
			while ((bytesRead = fin.read(buffer)) != -1) 
			{
				fout.write(buffer, 0, bytesRead);
			}
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
