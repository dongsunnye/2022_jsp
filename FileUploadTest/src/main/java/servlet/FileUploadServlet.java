package servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/upload.do")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String encoding = "utf-8";
		
		File userRoot = new File(request.getSession().getServletContext().getRealPath("/")
				+"/upload");
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(userRoot);//업로드될 폴더 설정
		factory.setSizeThreshold(1024*1024);//버퍼 메모리
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			List<FileItem> list = upload.parseRequest(request);
			for(FileItem item : list) {
				if(item.isFormField()) {
					System.out.println(item.getFieldName() + "=" + item.getString(encoding));
				}else {
					System.out.println("매개변수명 : " + item.getFieldName());
					System.out.println("파일명 : " + item.getName());
					System.out.println("파일크기 : " + item.getSize());
					System.out.println("파일타입 : " + item.getContentType());
					if(item.getSize() > 0) {
						int idx = item.getName().lastIndexOf("\\");
						if(idx == -1)
							idx = item.getName().lastIndexOf("/");
						
						String fileName = item.getName().substring(idx + 1);
						File uploadFile = new File(userRoot + "\\" + fileName);
						item.write(uploadFile);
						request.setAttribute("file1", request.getContextPath()
								+ "/upload/"+fileName);
					}
				}
				
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		request.getRequestDispatcher("file_result.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
