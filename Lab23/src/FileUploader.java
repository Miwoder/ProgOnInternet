import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@WebServlet(name = "FileUploader", urlPatterns = {"/upload"})
@MultipartConfig
public class FileUploader extends HttpServlet {

  private final static String serverPath = "C:/Study/File";

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    Part filePart = request.getPart("file");
    String fileName = getFileName(filePart);
    OutputStream out = null;
    InputStream filecontent = null;
    PrintWriter writer = response.getWriter();

    try {
      out = new FileOutputStream(new File(serverPath + File.separator + fileName));
      filecontent = filePart.getInputStream();
      int read = 0;
      byte[] bytes = new byte[1024];

      while ((read = filecontent.read(bytes)) != -1) {
        out.write(bytes, 0, read);
      }
      writer.println("New file " + fileName + " created at " + serverPath);
    } catch (FileNotFoundException fne) {
      writer.println("Missing file or no insufficient permissions.");
      writer.println(" ERROR: " + fne.getMessage());
    } finally {
      if (out != null) {
        out.close();
      }
      if (filecontent != null) {
        filecontent.close();
      }
      if (writer != null) {
        writer.close();
      }
    }
  }

  private String getFileName(Part filePart) {
    String header = filePart.getHeader("content-disposition");
    String name = header.substring(header.indexOf("filename=\"")+10);
    return name.substring(0, name.indexOf("\""));
  }
}