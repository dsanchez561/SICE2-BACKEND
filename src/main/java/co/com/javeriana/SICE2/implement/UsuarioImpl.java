/**
 * 
 */
package co.com.javeriana.SICE2.implement;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import co.com.javeriana.SICE2.entidades.Evento;
import co.com.javeriana.SICE2.entidades.UsuarioJaveriana;
import co.com.javeriana.SICE2.repositories.EventoRepository;
import jxl.Cell;
import jxl.CellView;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableImage;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


/**
 * @author Javeriana
 *
 */
@Component
public class UsuarioImpl {
	
	@Autowired
	private EventoRepository eventoRepository;

	public Object exportarExcelSuscritos(Long id) throws Exception {
		
		final ClassPathResource resource = new ClassPathResource("imagenes/PUJBogota.png");
	    BufferedImage imageOnDisk = ImageIO.read(resource.getFile());
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(imageOnDisk, "png", baos);
        baos.flush();
        
        Evento e = eventoRepository.findOne(id);
	    

		File f = new File("C:\\Users\\asus\\inscritos "+e.getTitulo()+".xls");
		WritableWorkbook myExcel = Workbook.createWorkbook(f);
		WritableSheet mySheet = myExcel.createSheet("Usuarios Inscritos", 0);
		mySheet.addImage(new WritableImage(0,0,5,
			   11,baos.toByteArray()));
		int i=3;
        
		WritableFont wfontitle = new WritableFont(WritableFont.createFont("Arial Black"), 20, WritableFont.BOLD, false,
	            UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
		WritableCellFormat wcfFCtitle = new WritableCellFormat(wfontitle);
		wcfFCtitle.setAlignment(Alignment.CENTRE);
		wcfFCtitle.setVerticalAlignment(VerticalAlignment.CENTRE);// 对齐方式
		
		WritableFont wfont;
		wfont = new WritableFont(WritableFont.createFont("Arial Black"), 10, WritableFont.BOLD, false,
	            UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
		WritableCellFormat wcfFC = new WritableCellFormat(wfont);
		wcfFC.setBorder(Border.ALL, BorderLineStyle.THIN);
        wcfFC.setAlignment(Alignment.CENTRE);
        wcfFC.setVerticalAlignment(VerticalAlignment.CENTRE);// 对齐方式
        
        WritableCellFormat wcfFCdata = new WritableCellFormat();
        wcfFCdata.setBorder(Border.ALL, BorderLineStyle.THIN);
        
        Label l = new Label(8, i, e.getTitulo(), wcfFCtitle);
		mySheet.addCell(l);
		
		i++;
		
		l = new Label(6, i, UsuarioJaveriana.class.getDeclaredFields()[0].getName(), wcfFC);
		mySheet.addCell(l);
		l = new Label(7, i, UsuarioJaveriana.class.getDeclaredFields()[1].getName(), wcfFC);
		mySheet.addCell(l);
		l = new Label(8, i, UsuarioJaveriana.class.getDeclaredFields()[2].getName(), wcfFC);
		mySheet.addCell(l);
		l = new Label(9, i, UsuarioJaveriana.class.getDeclaredFields()[3].getName(), wcfFC);
		mySheet.addCell(l);
		l = new Label(10, i, UsuarioJaveriana.class.getDeclaredFields()[4].getName(), wcfFC);
		mySheet.addCell(l);
		
		i++;
		for(UsuarioJaveriana u:e.getInscritos()) {
			Label l1 = new Label(6, i, u.getId()+"", wcfFCdata);
			mySheet.addCell(l1);
			Label l2 = new Label(7, i, (u.getNombre()==null) ? "" : u.getNombre(), wcfFCdata);
			mySheet.addCell(l2);
			Label l3 = new Label(8, i, (u.getApellidos()==null) ? "" : u.getApellidos(), wcfFCdata);
			mySheet.addCell(l3);
			Label l4 = new Label(9, i, (u.getUsername()==null) ? "" : u.getUsername(), wcfFCdata);
			mySheet.addCell(l4);
			Label l5 = new Label(10, i, (u.getEmail()==null) ? "" : u.getEmail(), wcfFCdata);
			mySheet.addCell(l5);
			i++;
		}
		sheetAutoFitColumns(mySheet);
		
		myExcel.write();
		myExcel.close();
		return null;
	}
	
	private void sheetAutoFitColumns(WritableSheet sheet) {
	    for (int i = 0; i < sheet.getColumns(); i++) {
	        Cell[] cells = sheet.getColumn(i);
	        int longestStrLen = -1;

	        if (cells.length == 0)
	            continue;

	        /* Find the widest cell in the column. */
	        for (int j = 0; j < cells.length; j++) {
	            if ( cells[j].getContents().length() > longestStrLen ) {
	                String str = cells[j].getContents();
	                if (str == null || str.isEmpty())
	                    continue;
	                longestStrLen = str.trim().length();
	            }
	        }

	        /* If not found, skip the column. */
	        if (longestStrLen == -1) 
	            continue;
	        longestStrLen += 2;
	        /* If wider than the max width, crop width */
	        if (longestStrLen > 255)
	            longestStrLen = 255;

	        CellView cv = sheet.getColumnView(i);
	        cv.setSize(longestStrLen * 256 + 100); /* Every character is 256 units wide, so scale it. */
	        sheet.setColumnView(i, cv);
	    }
	}
	

}
