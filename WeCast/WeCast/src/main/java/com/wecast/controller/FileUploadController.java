package com.wecast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wecast.helper.FileUploadHelper;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class FileUploadController {

	@Autowired
	private FileUploadHelper fileUploadHelper;

	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
		log.info(file.getOriginalFilename());
		log.info("FileSize " + file.getSize());
		log.info(file.getContentType());
		log.info(file.getName());

		try {
			if (file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain body");
			}

			if (file.getContentType().equals("image/jpeg")) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only jpeg allowed");
			}

			// File upload code

			boolean f = fileUploadHelper.uploadFile(file);
			if (f) {
				return ResponseEntity.ok("File uploaded successfully");
			}

		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong! try again");
	}

	/*
	 * @RequestMapping(value="/upload", method=RequestMethod.POST,
	 * consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	 * 
	 * public String fileUpload(@RequestParam("file") MultipartFile file) throws
	 * IOException{ File convertFile = new File(
	 * "E:\\AllJavaProjects\\RealTimeProject\\WeCast\\WeCast\\src\\main\\resources\\static\\image\\"+
	 * file.getOriginalFilename()); convertFile.createNewFile();
	 * 
	 * try(FileOutputStream fout = new FileOutputStream(convertFile)) {
	 * fout.write(file.getBytes()); } catch(Exception e) { e.printStackTrace(); }
	 * 
	 * return "File has uploaded successfully"; }
	 */
}
