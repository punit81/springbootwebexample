package com.jpa.springbootweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jpa.springbootweb.helper.FileUploadHelper;

@RestController
public class FileUploadController {

	@Autowired
	FileUploadHelper fhelper;
	
	@PostMapping("/file-upload")
	public ResponseEntity<String> uploadMyFile(@RequestParam("file") MultipartFile file){
		try {
			boolean fileUploaded=fhelper.uploadFile(file);
			
			if(file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File to be uploaded must not be empty!");
			}
			
			if(!file.getContentType().equals("image/jpeg")) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only uploading of .jpeg file is allowed....!");
			}
			
			if(fileUploaded)
				return ResponseEntity.ok("Working Fine....!");
			else
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong.....!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong.....!");
	}
}
