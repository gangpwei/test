import java.io.FileOutputStream;    
import java.io.File;    
import java.io.ByteArrayOutputStream;    
import java.io.IOException;    
   
import java.awt.image.BufferedImage;    
import javax.imageio.*;    
   
import org.apache.poi.hssf.usermodel.HSSFWorkbook;    
import org.apache.poi.hssf.usermodel.HSSFSheet;    
import org.apache.poi.hssf.usermodel.HSSFPatriarch;    
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;;    
   
public class TestExcelChaTu {    
   
    public static void main(String[] args) {    
            FileOutputStream fileOut = null;    
            BufferedImage bufferImg =null;    
            BufferedImage bufferImg1 = null;    
            try{    
                  
          //先把读进来的图片放到一个ByteArrayOutputStream中，以便产生ByteArray    
          ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();    
          ByteArrayOutputStream byteArrayOut1 = new ByteArrayOutputStream();    
          bufferImg = ImageIO.read(new File("d:/2.png"));    
          bufferImg1 = ImageIO.read(new File("d:/3.png"));  
          System.out.println(bufferImg1.getTileHeight());
          ImageIO.write(bufferImg,"png",byteArrayOut);    
          ImageIO.write(bufferImg1,"png",byteArrayOut1);    
            
        //创建一个工作薄    
       HSSFWorkbook wb = new HSSFWorkbook();    
       HSSFSheet sheet1 = wb.createSheet("new sheet");    
       //HSSFRow row = sheet1.createRow(2);    
       HSSFPatriarch patriarch = sheet1.createDrawingPatriarch();    
       HSSFClientAnchor anchor = new HSSFClientAnchor(0,0,0,0,(short) 1,1,(short)13,20);    
       HSSFClientAnchor anchor1 = new HSSFClientAnchor(0,0,0,0,(short) 1,25,(short)13,45);    
       anchor1.setAnchorType(3);    
       //插入图片    
       patriarch.createPicture(anchor , wb.addPicture(byteArrayOut.toByteArray(),HSSFWorkbook.PICTURE_TYPE_PNG));    
       patriarch.createPicture(anchor1 , wb.addPicture(byteArrayOut1.toByteArray(),HSSFWorkbook.PICTURE_TYPE_JPEG));    
          
           fileOut = new FileOutputStream("d:/workbook.xls");    
           //写入excel文件    
           wb.write(fileOut);    
           fileOut.close();    
          
            }catch(IOException io){    
                    io.printStackTrace();    
                    System.out.println("io erorr : "+ io.getMessage());    
            } finally   
            {    
               if (fileOut != null)    
               {    
                             
                   try {    
                              fileOut.close();    
                         }    
                   catch (IOException e)    
                   {    
                            e.printStackTrace();    
                     }    
               }    
            }    
    }    
} 
 

