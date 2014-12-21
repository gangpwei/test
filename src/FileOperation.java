
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileOperation {
	
	
	/**
	 * @param src
	 * @param target
	 * 压缩单个文件
	 */
	public static void zipFile(String src,String target){
		File f=new File(src);
		try {
			InputStream in=new FileInputStream(src);
			ZipOutputStream zos=new ZipOutputStream(new FileOutputStream(target));
			zos.putNextEntry(new ZipEntry(f.getName()));
			byte[] buf=new byte[1024];
			int i=-1;
			while((i=in.read(buf))!=-1){
				zos.write(buf,0,i);
			}
			zos.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
	
	/** 
	* 复制整个文件夹内容 
	* @param oldPath String 原文件路径 如：c:/fqf 
	* @param newPath String 复制后路径 如：f:/fqf/ff 
	* @return boolean 
	*/ 
	public static void copyFolder(String oldPath, String newPath) { 
		File a=new File(oldPath); 
		if(a.isDirectory()){
			try { 
				(new File(newPath)).mkdirs(); //如果文件夹不存在 则建立新文件夹 
				
				String[] file=a.list(); 
				File temp=null; 
				for (int i = 0; i < file.length; i++) { 
					if(oldPath.endsWith(File.separator)){ 
						temp=new File(oldPath+file[i]); 
					} 
					else{ 
						temp=new File(oldPath+File.separator+file[i]); 
					} 
					
					if(temp.isFile()){ 
						FileInputStream input = new FileInputStream(temp); 
						FileOutputStream output = new FileOutputStream(newPath + "/" + 
								(temp.getName()).toString()); 
						byte[] b = new byte[1024 * 5]; 
						int len; 
						while ( (len = input.read(b)) != -1) { 
							output.write(b, 0, len); 
						} 
						output.flush(); 
						output.close(); 
						input.close(); 
					} 
					if(temp.isDirectory()){//如果是子文件夹 
						copyFolder(oldPath+"/"+file[i],newPath+"/"+file[i]); 
					} 
				} 
				//copyFolder(oldPath+"/"+file,newPath+"/"+file);
			} 
			catch (Exception e) { 
				System.out.println("复制整个文件夹内容操作出错"); 
				//JOptionPane.showMessageDialog(null,"复制整个文件夹内容操作出错","错误！",JOptionPane.ERROR_MESSAGE,null);
				e.printStackTrace(); 	
			} 			
		}else if(a.isFile()){
			try { 
					int bytesum = 0; 
					int len = 0; 
					File oldfile = new File(oldPath); 
					if (oldfile.exists()) { //文件存在时 
						InputStream inStream = new FileInputStream(oldPath); //读入原文件 
						FileOutputStream fs = new FileOutputStream(newPath); 
						byte[] buffer = new byte[1444]; 
						int length; 
						while ( (len = inStream.read(buffer)) != -1) { 			
						fs.write(buffer, 0, len); 
						} 
						inStream.close(); 
						fs.close();
					} 
				} 
				catch (Exception e) { 
					System.out.println("复制单个文件操作出错"); 
					e.printStackTrace(); 

				} 
		}
	} 
	

	
	/** 
	* 删除文件 
	* @param filePathAndName String 文件路径及名称 如c:/fqf.txt 
	* @param fileContent String 
	* @return boolean 
	*/ 
	public static void delFile(String filePathAndName) { 
		try { 
			File myDelFile = new File(filePathAndName); 
			myDelFile.delete(); 
		} 
		catch (Exception e) { 
			e.printStackTrace(); 
		} 
	} 

	/** 
	* 删除文件夹里面的所有文件 
	* @param path String 文件夹路径 如 c:/fqf 
	*/ 
	public static void delAllFile(String path) { 
		File file = new File(path); 
		if (!file.exists()) { 
		//	JOptionPane.showMessageDialog(null,"文件不存在！","删除文件操作出错",JOptionPane.ERROR_MESSAGE,null);
			return; 
		} 

		if (!file.isDirectory()) { 
			delFile(path);
		} else{
			String[] tempList = file.list(); 
			File temp = null; 
			for (int i = 0; i < tempList.length; i++) { 
				if (path.endsWith(File.separator)) { 
					temp = new File(path + tempList[i]); 
				} 
				else { 
					temp = new File(path + File.separator + tempList[i]); 
				} 
				if (temp.isFile()) { 
					temp.delete(); 
				} 
				if (temp.isDirectory()) { 
					delAllFile(path+"/"+ tempList[i]);//先删除文件夹里面的文件 
					//delFile(path+"/"+ tempList[i]);//再删除空文件夹 
				} 
			} 
			delFile(path);
			
		}
	} 
}
