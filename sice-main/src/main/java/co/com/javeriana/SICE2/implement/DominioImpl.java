/**
 * 
 */
package co.com.javeriana.SICE2.implement;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import co.com.javeriana.SICE2.comandos.mensaje.Mensaje;
import co.com.javeriana.SICE2.enumeracion.TipoDominioEnum;
import co.com.javeriana.SICE2.log.Log;
import co.com.javeriana.SICE2.model.general.Dominio;
import co.com.javeriana.SICE2.model.general.Evento;
import co.com.javeriana.SICE2.model.general.Servicio;
import co.com.javeriana.SICE2.model.general.UsuarioJaveriana;
import co.com.javeriana.SICE2.repositories.DominioRepository;
import co.com.javeriana.SICE2.repositories.EventoRepository;
import co.com.javeriana.SICE2.repositories.ServicioRepository;
import co.com.javeriana.SICE2.utils.Util;
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
import jxl.write.WriteException;

/**
 * @author Javeriana
 *
 */
@Component
public class DominioImpl {
	
	@Log
	private Logger log;
	
	@Autowired
	private DominioRepository dominioRepository;

	@Autowired
	private ServicioRepository servicioRepository;
	
	@Autowired
	private EventoRepository eventoRepository;
	
	public List<Dominio> listarDominiosNacionales(String tipo) {
		try {
			return dominioRepository.findByActivoAndTipoAndNacional(true, TipoDominioEnum.valueOf(tipo),true);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}
	
	public List<Dominio> listarDominiosInternacionales(String tipo) {
		try {
			return dominioRepository.findByActivoAndTipoAndNacional(true, TipoDominioEnum.valueOf(tipo),false);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}

	public Mensaje validarImagen(MultipartFile file) {
		Mensaje mensaje=null;
		if(!Util.validarTamImagen(file)) {
//			mensaje = new Mensaje(null, null, null, CodigosError.TAMANIO_IMAGEN_NO_SOPORTADO);
		}
		if(!Util.validarTipoImagen(file)) {
//			mensaje =  new Mensaje(null, null, null, CodigosError.TIPO_IMAGEN_NO_SOPORTADO);
		}
		return mensaje;
	}

	/**
	 * Método que guarda en la base de datos una imagen a un dominio
	 * @param file de la imagen
	 * @param id del inventario
	 * @throws IOException
	 */
	public byte[] uploadImage(Long id) throws IOException {
		return dominioRepository.findById(id).get().getImagen();
	}

	public void downloadImage() {
		try {
			for(Dominio dominio:dominioRepository.findAll()) {
				dominio.setImagen(getImagenUniversidad("imagenes/"+dominio.getNombreArchivo()));
				dominioRepository.save(dominio);
			}
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}
	
	/**
	 * Método que crea una imagen por defecto
	 * @param ruta de la imagen
	 * @return la imagen creada
	 * @throws IOException excepcion de la imagen
	 */
	public byte[] getImagenUniversidad(final String ruta) throws IOException {
		final ClassPathResource resource = new ClassPathResource(ruta);
	    BufferedImage imageOnDisk = ImageIO.read(resource.getFile());
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(imageOnDisk, "png", baos);
        baos.flush();
	    return baos.toByteArray();
	}

	public String obtenerURL(Long id, String nombre) {
		Dominio dominio = dominioRepository.findById(Long.valueOf(id)).get();
		Servicio pagina = servicioRepository.findByDominioAndNombre(dominio, nombre);
		return pagina.getUrl();
	}
	
	public WritableWorkbook exportarExcelInscritos(Long id, HttpServletResponse response) throws IOException, WriteException {
		Evento e = eventoRepository.findById(id).get();
		
		String fileName = "Inscritos " + e.getTitulo();
		File f = new File ("C:\\Users\\asus\\"+fileName+".xls");
//		WritableWorkbook myExcel = Workbook.createWorkbook(response.getOutputStream());
		WritableWorkbook myExcel = Workbook.createWorkbook(f);
		WritableSheet excelOutputsheet = myExcel.createSheet(e.getTitulo(), 0);
		
		final ClassPathResource resource = new ClassPathResource("imagenes/PUJBogota.png");
		BufferedImage imageOnDisk = ImageIO.read(resource.getFile());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(imageOnDisk, "png", baos);
		baos.flush();
		excelOutputsheet.addImage(new WritableImage(0,0,5,
			       15,baos.toByteArray()));
		
		WritableFont wfontSubTitle = new WritableFont(WritableFont.createFont("Arial Black"), 10, WritableFont.BOLD, false,
	            UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
		WritableCellFormat wcfFCSubTitle = new WritableCellFormat(wfontSubTitle);
		wcfFCSubTitle.setBorder(Border.ALL, BorderLineStyle.THIN);
		wcfFCSubTitle.setAlignment(Alignment.CENTRE);
		wcfFCSubTitle.setVerticalAlignment(VerticalAlignment.CENTRE);
		
		WritableFont wfontData = new WritableFont(WritableFont.createFont("Arial"), 10, WritableFont.NO_BOLD, false,
	            UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
		WritableCellFormat wcfFCData = new WritableCellFormat(wfontData);
		wcfFCData.setBorder(Border.ALL, BorderLineStyle.THIN);
		
		WritableFont wfontTitle = new WritableFont(WritableFont.createFont("Arial Black"), 20, WritableFont.BOLD, false,
	            UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
		WritableCellFormat wcfFCTitle = new WritableCellFormat(wfontTitle);
		wcfFCTitle.setAlignment(Alignment.CENTRE);
		wcfFCTitle.setVerticalAlignment(VerticalAlignment.CENTRE);
		
		Label l = new Label(6, 0, "Creado por: ", wcfFCSubTitle);
		excelOutputsheet.addCell(l);
		
		l = new Label(7, 0, e.getCreador().getNombre()+" "+e.getCreador().getApellidos(), wcfFCData);
		excelOutputsheet.addCell(l);
		
		l = new Label(6, 1, "Fecha de inicio: ", wcfFCSubTitle);
		excelOutputsheet.addCell(l);
		
		l = new Label(7, 1, e.getInicio().toString(), wcfFCData);
		excelOutputsheet.addCell(l);
		
		l = new Label(6, 2, "Fecha en que termina: ", wcfFCSubTitle);
		excelOutputsheet.addCell(l);
		
		l = new Label(7, 2, e.getFin().toString(), wcfFCData);
		excelOutputsheet.addCell(l);
		
		l = new Label(7, 5, e.getTitulo(), wcfFCTitle);
		excelOutputsheet.addCell(l);
		
		
		l = new Label(6, 6, UsuarioJaveriana.class.getDeclaredFields()[0].getName(), wcfFCSubTitle);
		excelOutputsheet.addCell(l);
		
		l = new Label(7, 6, UsuarioJaveriana.class.getDeclaredFields()[1].getName(), wcfFCSubTitle);
		excelOutputsheet.addCell(l);
		
		l = new Label(8, 6, UsuarioJaveriana.class.getDeclaredFields()[2].getName(), wcfFCSubTitle);
		excelOutputsheet.addCell(l);
		
		l = new Label(9, 6, UsuarioJaveriana.class.getDeclaredFields()[3].getName(), wcfFCSubTitle);
		excelOutputsheet.addCell(l);
		
		l = new Label(10, 6, UsuarioJaveriana.class.getDeclaredFields()[4].getName(), wcfFCSubTitle);
		excelOutputsheet.addCell(l);
		
		int i = 7;
		
		for(UsuarioJaveriana uj:e.getInscritos()) {
			l = new Label(6, i, uj.getId()+"", wcfFCData);
			excelOutputsheet.addCell(l);
			
			l = new Label(7, i, uj.getNombre(), wcfFCData);
			excelOutputsheet.addCell(l);
			
			l = new Label(8, i, uj.getApellidos(), wcfFCData);
			excelOutputsheet.addCell(l);
			
			l = new Label(9, i, uj.getUsername(), wcfFCData);
			excelOutputsheet.addCell(l);
			
			l = new Label(10, i, uj.getEmail(), wcfFCData);
			excelOutputsheet.addCell(l);
			i++;
		}
		
		
		sheetAutoFitColumns(excelOutputsheet);
		
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

	        /* If wider than the max width, crop width */
	        if (longestStrLen > 255)
	            longestStrLen = 255;
	        
	        longestStrLen += 4;

	        CellView cv = sheet.getColumnView(i);
	        cv.setSize(longestStrLen * 256 + 100); /* Every character is 256 units wide, so scale it. */
	        sheet.setColumnView(i, cv);
	    }
	}
	public void exportarPdfInscritos(Long id, HttpServletResponse response) throws IOException {
		Evento e = eventoRepository.findById(id).get();
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\asus\\Inscritos "+e.getTitulo()+".pdf");
		PdfWriter pw = new PdfWriter(fos);
		PdfDocument pdf = new PdfDocument(pw);
		Document document = new Document(pdf);
		
		document.add(new Paragraph("Creado por: "+e.getCreador().getNombre()+" "+e.getCreador().getApellidos()));
		document.add(new Paragraph("Fecha inicio: "+e.getInicio().toString()));
		document.add(new Paragraph("Fecha en que termina: "+e.getFin().toString()));
		document.add(new Paragraph(""));
		document.add(new Paragraph(""));
		document.add(new Paragraph("                                       "+e.getTitulo()));
		document.add(new Paragraph(""));
		document.add(new Paragraph(""));

		for(UsuarioJaveriana uj : e.getInscritos()) {
			document.add(new Paragraph("       "+uj.getNombre()+" "+uj.getApellidos()+", "+uj.getUsername()+", "+uj.getEmail()));
		}
		document.close();
	}
}
