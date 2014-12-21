import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 
 * @author 魏钢鹏
 * @version 创建时间：2011-5-20 下午02:16:52
 */
public class DtoGenarater {
	
	BufferedReader br ;
	PrintStream filePs=null;
	public String desktop="C://Users/imwgp/Desktop/";
	public String temp="temp";
	public void pexecute(String pojoPath){
		String line;
		String fileName;
		String packageName;
		try{
			br=new BufferedReader(new InputStreamReader(new FileInputStream(new File(pojoPath))));
			fileName=pojoPath.substring(pojoPath.lastIndexOf("/")+1,pojoPath.lastIndexOf(".") );
			File df=new File("src/"+temp+"/"+fileName+"Dto.java");
			if(df.exists()){
				df.delete();
			}
			while( (line=br.readLine())!=null){
				File f=new File("src/"+temp+"/");
				if(line.indexOf("package ")>=0){
					packageName=line.substring(line.indexOf("package ")+8,line.indexOf(";"));
					System.out.println(packageName);
					line=line.replace(packageName, temp);
				}
				if(f.exists()==false){
					f.mkdir();
				}
				filePs=new PrintStream(new FileOutputStream(df,true));
				line=line.replace(fileName,fileName+"Dto" );
				filePs.println(line);
				//System.out.println(line);
				filePs.close();
			}
		}catch(Exception e){
		    e.printStackTrace();
		}
	}
	
	public void execute(String pojoPath){
		String line;
		String fileName;
		String packageName;
		try{
			br=new BufferedReader(new InputStreamReader(new FileInputStream(new File(pojoPath))));
			packageName=pojoPath.substring(pojoPath.indexOf("src")+3,pojoPath.indexOf("."));
			packageName=packageName.replace("/", ".");
			fileName=pojoPath.substring(pojoPath.lastIndexOf("/")+1,pojoPath.lastIndexOf(".") );
			File df=new File(desktop+"/"+fileName+"Dto.java");
			if(df.exists()){
				df.delete();
			}
			List<String>  filds =new ArrayList<String>();
			String text="";
			while( (line=br.readLine())!=null){
				String fild=null;
				if(( fild=getFild(line))!=null){
					filds.add(fild);
				}
				if(line.indexOf("package ")!=-1&&line.indexOf(".")!=-1&&line.indexOf(";")!=-1){
					line=line+"\nimport "+packageName+";";
				}
				line=line.replace(fileName,fileName+"Dto" );
				text=text+"\n"+line;
				//System.out.println(line);
			}
			filePs=new PrintStream(new FileOutputStream(df,true));
			text=text.substring(0, text.lastIndexOf("}"));
			text+=getConvertMethod(filds, fileName);
			text+="}";
			System.out.println(text);
			//filePs.println(text);
			filePs.close();
			FileWriter fw = new FileWriter(desktop+"/"+fileName+"Dto.java");   
			fw.write(text);
			fw.close();
		}catch(Exception e){
		    e.printStackTrace();
		}
	}
	
//	public InstructionsConfigDto(InstructionsConfig po) {
//		this.id = po.getId();
//		this.command = po.getCommand();
//		this.attentionField = po.getAttentionField();
//		this.judge = po.getJudge();
//		this.remark = po.getRemark();
//		this.name = po.getName();
//		this.neType = po.getNeType();
//	}
	public String getConvertMethod(List<String> filds,String pojoName ){
		String s="	public "+pojoName+"Dto("+pojoName+" po){\n";
		String methodName=null;
		for (String f : filds) {
			methodName=f.substring(0,1).toUpperCase()+f.substring(1,f.length());
			s=s+"		this."+f+" = po.get"+methodName+"();\n";
		}
		s+="	}\n\n";
		s=s+"	public static "+pojoName+" dtoConvertPo("+pojoName+" po, "+pojoName+"Dto dto){\n		if(po == null)\n		    po=new "+pojoName+"();\n";
		for (String f : filds) {
			methodName=f.substring(0,1).toUpperCase()+f.substring(1,f.length());
			s=s+"		po.set"+methodName+"(dto.get"+methodName+"());\n";
		}
		s+="		return po;\n";
		s+="	}\n";
		//System.out.println(s);
		return  s;
	}
//
//	public static InstructionsConfig dtoConvertPo(InstructionsConfig po, InstructionsConfigDto dto) {
//		if (po == null)
//			po = new InstructionsConfig();
//		po.setId(dto.getId());
//		po.setCommand(dto.getCommand());
//		po.setAttentionField(dto.getAttentionField());
//		po.setJudge(dto.getJudge());
//		po.setRemark(dto.getRemark());
//		po.setNeType(dto.getNeType());
//		po.setName(dto.getName());
//		return po;
//	}

	public String getFild(String line){
		boolean flag=false;
		String fild=line;
		if(line.indexOf("return")>0){
			return null;
		}
		if(line.indexOf(";")<0){
			return null;
		}
		if(line.indexOf("package")>=0){
			return null;
		}
		if(line.indexOf("()")>=0){
			return null;
		}
		if(line.indexOf("public void set")>=0){
			return null;
		}
		if(line.indexOf("import")>=0){
			return null;
		}
		if(line.indexOf("=")>=0){
			return null;
		}
		if(line.indexOf("serialVersionUID")>0){
			return null;
		}
		int index=line.indexOf(";");
		line=line.substring(0,index);
		if(line.charAt(index-1)!=' '){
			line=line.substring(line.lastIndexOf(" ")+1,index);
		}else{
			while(line.charAt(line.length()-1)==' '){
				line=line.substring(0,line.length()-1);
			}
			line=line.substring(line.lastIndexOf(" ")+1,line.length());
		}
		//System.out.println("["+line+"]");
		return line;
	}
	public static void main(String[] args) {
		
		DtoGenarater d=new DtoGenarater();
//		String f=d.getFild("public long getId() ");
//		System.out.println(f);
		d.execute("E:/EclipseWorkspace/DSMA/src/com/nsn/dsma/business/entity/configuration/ComparisonTemplate.java");
	
	}
}
