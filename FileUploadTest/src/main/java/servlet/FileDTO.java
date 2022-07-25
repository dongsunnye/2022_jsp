package servlet;

import java.io.File;

public class FileDTO {
	private String path;
	private String fileName;
	private String type;
	
	public FileDTO(File file) {
		this.path = file.getAbsolutePath();
		this.fileName = file.getName();
		switch(fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase()) {
		
		}
	}
	
	
	
}
