/**
 * 
 */
package co.com.javeriana.SICE2.implement;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.log.SysoCounter;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

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
import co.com.javeriana.SICE2.seguridad.ConfiguracionSeguridad;
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
	
	@Autowired
	private ConfiguracionSeguridad seguridad;
	
	public List<Dominio> listarDominiosNacionales(String tipo) {
		try {
			return dominioRepository.findByActivoAndTipoAndNacional(true, TipoDominioEnum.valueOf(tipo),true, new Sort(Sort.Direction.ASC, "nombre"));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}
	
	public List<Dominio> listarDominiosInternacionales(String tipo) {
		try {
			return dominioRepository.findByActivoAndTipoAndNacional(true, TipoDominioEnum.valueOf(tipo),false, new Sort(Sort.Direction.ASC, "nombre"));
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
	public void uploadImage(final MultipartFile file, Long id) throws IOException {
		final Dominio dominio = dominioRepository.findById(id).get();
		dominio.setImagen(file.getBytes());
		dominioRepository.save(dominio);
	}

	/**
	 * Método que descarga todas las imágenes a cada dominio
	 */
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
	
	/**
	 * Método que crea el archivo de excel
	 * @param id se refiere al id del dominio
	 * @return el archivo
	 * @throws IOException
	 * @throws WriteException
	 */
	public WritableWorkbook exportarExcelInscritos(Long id) throws IOException, WriteException {
		Evento e = eventoRepository.findById(id).get();
		UsuarioJaveriana usuarioJaveriana = seguridad.getCurrentUser();
//		String fileName = "Inscritos " + e.getTitulo();
		String fileName = usuarioJaveriana.getUsername()+"-Inscritos "+eventoRepository.findById(id).get().getTitulo();
		File f = new File ("/var/lib/tomcat8/webapps/"+fileName+".xls");
//		File f = new File ("archivos/"+fileName+".xls");
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
	
	/**
	 * Método que ajusta el ancho de las columnas en el documento de excel
	 * @param sheet
	 */
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
	
	/**
	 * Método que genera el archivo de inscritos a un evento en pdf
	 * @param id se refiere al id del evento
	 * @param response 
	 * @throws IOException
	 * @throws DocumentException
	 * @throws URISyntaxException
	 */
	public void exportarPdfInscritos(Long id, HttpServletResponse response) throws IOException, DocumentException, URISyntaxException {
		Evento e = eventoRepository.findById(id).get();
		UsuarioJaveriana usuarioJaveriana = seguridad.getCurrentUser();
		String fileName = usuarioJaveriana.getUsername()+"-Inscritos "+e.getTitulo();
		
		FileOutputStream fos = new FileOutputStream("/var/lib/tomcat8/webapps/"+fileName+".pdf");
		
		final ClassPathResource resource = new ClassPathResource("imagenes/PUJBogota.png");
		
		Document document = new Document();
		PdfWriter.getInstance(document, fos);
		document.open();
		
		System.out.println("OOOOOOOOOOOOOOOOOOOOOOO        "+resource.toString());
//		BufferedImage imageOnDisk = ImageIO.read(resource.getFile());
//		ByteArrayOutputStream baos = new ByteArrayOutputStream();
//		ImageIO.write(imageOnDisk, "png", baos);
//		baos.flush();
//		Image img = Image.getInstance(baos.toString());
//		img.setAbsolutePosition(15, 735);
//		img.scaleToFit(90, 290);
//		document.add(img);
		
		Paragraph paragraph = new Paragraph();

		Font font = new Font(FontFamily.HELVETICA, 25, Font.UNDERLINE);
		paragraph = new Paragraph(e.getTitulo(), font);
		paragraph.setAlignment(Element.ALIGN_CENTER);
		document.add(paragraph);
		document.add(Chunk.NEWLINE);
		
		font = new Font(FontFamily.HELVETICA, 12);
		paragraph = new Paragraph("Creado por: "+e.getCreador().getNombre()+" "+e.getCreador().getApellidos(), font);
		document.add(paragraph);
		paragraph = new Paragraph("Fecha de inicio: "+e.getInicio(), font);
		document.add(paragraph);
		paragraph = new Paragraph("Fecha en que termina: "+e.getFin(), font);
		document.add(paragraph);
		
		document.add(Chunk.NEWLINE);
		
		PdfPTable table = new PdfPTable(new float[] { 1, 3, 3, 3, 6 });
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table.addCell(UsuarioJaveriana.class.getDeclaredFields()[0].getName());
		table.addCell(UsuarioJaveriana.class.getDeclaredFields()[1].getName());
		table.addCell(UsuarioJaveriana.class.getDeclaredFields()[2].getName());
		table.addCell(UsuarioJaveriana.class.getDeclaredFields()[3].getName());
		table.addCell(UsuarioJaveriana.class.getDeclaredFields()[4].getName());
		  
		PdfPCell[] cells = table.getRow(0).getCells(); 
		for (int j=0;j<cells.length;j++){
		   cells[j].setBackgroundColor(BaseColor.GRAY);
		}
		
		for(UsuarioJaveriana uj:e.getInscritos()) {
			table.addCell(uj.getId()+"");
			table.addCell(uj.getNombre());
			table.addCell(uj.getApellidos());
			table.addCell(uj.getUsername());
			table.addCell(uj.getEmail());
		}
		
		document.add(table);
		 
		document.close();
	}
}
