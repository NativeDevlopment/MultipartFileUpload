package com.rest.Api;

import org.springframework.web.multipart.MultipartFile;

public class FileInfo {
 public MultipartFile file;

public MultipartFile getFile() {
	return file;
}

public void setFile(MultipartFile file) {
	this.file = file;
}
	
}
