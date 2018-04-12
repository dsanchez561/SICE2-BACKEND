/**
 * 
 */
package co.com.javeriana.SICE2.implement;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.javeriana.SICE2.entidades.Evento;
import co.com.javeriana.SICE2.entidades.UsuarioJaveriana;
import co.com.javeriana.SICE2.repositories.EventoRepository;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;


/**
 * @author Javeriana
 *
 */
@Component
public class UsuarioImpl {
	
	@Autowired
	private EventoRepository eventoRepository;

	public Object exportarExcelSuscritos(Long id) throws Exception {
//		if(dataList != null && !dataList.isEmpty()){
//            HSSFWorkbook workBook = new HSSFWorkbook();
//            HSSFSheet sheet = workBook.createSheet();
//            HSSFRow headingRow = sheet.createRow(0);
//            headingRow.createCell((short)0).setCellValue("ID");
//            headingRow.createCell((short)1).setCellValue("ROLL_NO");
//            headingRow.createCell((short)2).setCellValue("NAME");
//            headingRow.createCell((short)3).setCellValue("GENDER");
//            short rowNo = 1;
//            for (Object[] objects : dataList) {
//                HSSFRow row = sheet.createRow(rowNo);
//                row.createCell((short)0).setCellValue(objects[0].toString());
//                row.createCell((short)1).setCellValue(objects[1].toString());
//                row.createCell((short)2).setCellValue(objects[2].toString());
//                row.createCell((short)3).setCellValue(objects[3].toString());
//                rowNo++;
//            }
//             
//            String file = "D:/Student_detais.xls";
//            try{
//                FileOutputStream fos = new FileOutputStream(file);
//                workBook.write(fos);
//                fos.flush();
//            }catch(FileNotFoundException e){
//                e.printStackTrace();
//                System.out.println("Invalid directory or file not found");
//            }catch(IOException e){
//                e.printStackTrace();
//                System.out.println("Error occurred while writting excel file to directory");
//            }
//        }
		Evento e = eventoRepository.findOne(id);
		File f = new File("C:\\Users\\Inscritos"+e.getTitulo()+".xls");
		WritableWorkbook myExcel = Workbook.createWorkbook(f);
		WritableSheet mySheet = myExcel.createSheet("mySheet", 0);
		int i=0;
		int j=0;
		for(Field field:UsuarioJaveriana.class.getFields()) {
			Label l = new Label(0, i, field.toString());
			mySheet.addCell(l);
			i++;
		}
//		Evento e = eventoRepository.findOne(id);
//		i=0;
//		for(UsuarioJaveriana u:e.getInscritos()) {
//			Label l1 = new Label(i, 1, u.getId()+"");
//			Label l2 = new Label(i, 2, u.getNombre()+"");
//			Label l3 = new Label(i, 3, u.getApellidos()+"");
//			Label l4 = new Label(i, 4, u.getUsername()+"");
//			Label l5 = new Label(i, 5, u.getEmail()+"");
//			i++;
//		}
		myExcel.write();
		myExcel.close();
		return null;
	}
	
	

}
