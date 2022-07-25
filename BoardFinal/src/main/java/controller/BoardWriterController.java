package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dto.FileDTO;
import service.BoardService;
import view.ModelAndView;

public class BoardWriterController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = null;
		String content = null;
		String writer = null;
		
		String encoding = "utf-8";
		String root = "c:\\fileupload\\";
		File userRoot = new File(root);
		if(!userRoot.exists())
			userRoot.mkdirs();
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(userRoot);//업로드될 폴더 설정
		factory.setSizeThreshold(1024*1024);//버퍼 메모리
		
		ServletFileUpload upload = new ServletFileUpload(factory);
			
		try {
			List<FileItem> list = upload.parseRequest(request);
			ArrayList<FileDTO> fList = new ArrayList<FileDTO>();
			
			for(FileItem item : list) {
				if(item.isFormField()) {
					switch(item.getFieldName()) {
					case "title":
						title = item.getString(encoding);
						break;
					case "content":
						content = item.getString(encoding);
						break;
					case "writer":
						writer = item.getString(encoding);
						break;
					}
					
				}else {
					if(item.getSize() > 0) {
						int idx = item.getName().lastIndexOf("\\");
						if(idx==-1)
							idx = item.getName().lastIndexOf("/");
						String fileName = item.getName().substring(idx+1);
						//파일 경로 완성
						File uploadFile = new File(root+"\\"+fileName);
						if(!uploadFile.getParentFile().exists())
							uploadFile.getParentFile().mkdirs();
						fList.add(new FileDTO(uploadFile, 0, fList.size()));
					}
				}
			}
			
			
			
			
			int bno = BoardService.getInstance().selectBoardNo();
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		
		
		return new ModelAndView("main.do", true);
	}

}





