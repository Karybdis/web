import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

public class download
{
    public void downloadExcel(XSSFWorkbook workbook, HttpServletResponse response,String filename) throws IOException
    {
        try {
            OutputStream out = response.getOutputStream();
            response.setHeader("Content-disposition", "attachment;filename="+ URLEncoder.encode(filename, "UTF-8"));
            response.setContentType("application/msexcel;charset=UTF-8");
            workbook.write(out);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
