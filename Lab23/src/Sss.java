import java.io.*;        // исключения ввода/вывода   
import javax.servlet.*;            // интерфейсы и классы общего типа  
import javax.servlet.http.*;       // расширение javax.servlet для http 
import org.apache.commons.httpclient.*; 
import org.apache.commons.httpclient.methods.*;

public class Sss extends HttpServlet implements Servlet {

	public Sss() {
		super();
	}

	protected void doGet(HttpServletRequest rq, HttpServletResponse rs)
			throws ServletException, IOException {
		//Получения  значения параметра инициации
		String filename = rq.getParameter("file");
		System.out.println(filename);
		String docdir = rq.getServletContext().getInitParameter("doc-dir");
		System.out.println(docdir);

		File dir = new File(docdir + "/" + filename);
		System.out.println(docdir + "/" + filename);
		OutputDoc(dir, rs);
	}
	//Функция пересылающая клиенту Word-файл
	protected void OutputDoc(File doc, HttpServletResponse rs) throws IOException {
		rs.setContentType("application/msword");
		rs.addHeader("Content-Disposition", "attachment; filename=" + doc.getName());
		rs.setContentLength((int) doc.length());
		FileInputStream in = new FileInputStream(doc);
		BufferedInputStream buf = new BufferedInputStream(in);
		ServletOutputStream out = rs.getOutputStream();
		int readBytes = 0;
		while ((readBytes = buf.read()) != -1)
			out.write(readBytes);

	}
}