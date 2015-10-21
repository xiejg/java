import java.io.*;
import java.util.ArrayList;
public class Read {
	public static  ArrayList<ArrayList<String>> datas;
	public static  ArrayList<ArrayList<String>> _datas;
	public static ArrayList<String> candAttr;
	public static Integer num=new Integer(0);
	public Read(ArrayList<ArrayList<String>> datas,ArrayList<ArrayList<String>> _datas,
			ArrayList<String> candAttr	){
		this.datas=datas;
		this._datas=_datas;
		this.candAttr=candAttr;
	}
	public  void read(File file){
		try{
			FileReader fr=new FileReader(file);
			BufferedReader br=new BufferedReader(fr);
			String line;
			while((line=br.readLine())!=null){
				String[] values=line.split(",");
				ArrayList<String> al = new ArrayList<String>();
				ArrayList<String> ak = new ArrayList<String>();
				for(int i=0;i<values.length;i++){
					String value=values[i];
					
					al.add(value);
					ak.add(value);
				}
				datas.add(al);
				_datas.add(ak);
			}
			br.close();
			for(num=0;num<datas.get(0).size()-1;num=num+1){
				candAttr.add(num.toString());
			}
		} catch (IOException e1){
			e1.printStackTrace();
		}
	}
	
	public  void readmushroom(File file){
		try{
			FileReader fr=new FileReader(file);
			BufferedReader br=new BufferedReader(fr);
			String line;
			while((line=br.readLine())!=null){
				String[] values=line.split(",");
				ArrayList<String> al = new ArrayList<String>();
				ArrayList<String> ak = new ArrayList<String>();
				for(int i=1;i<values.length;i++){
					String value=values[i];
					
					al.add(value);
					ak.add(value);
				}
				al.add(values[0]);
				ak.add(values[0]);
				datas.add(al);
				_datas.add(ak);
			}
			br.close();
			for(num=0;num<datas.get(0).size()-1;num=num+1){
				candAttr.add(num.toString());
			}
		} catch (IOException e1){
			e1.printStackTrace();
		}
	}
	
	public  void readletter(File file){
		try{
			FileReader fr=new FileReader(file);
			BufferedReader br=new BufferedReader(fr);
			String line;
			while((line=br.readLine())!=null){
				String[] values=line.split(",");
				ArrayList<String> al = new ArrayList<String>();
				ArrayList<String> ak = new ArrayList<String>();
				for(int i=1;i<values.length;i++){
					String value=values[i];
					
					al.add(value);
					ak.add(value);
				}
				al.add(values[0]);
				ak.add(values[0]);
				datas.add(al);
				_datas.add(ak);
			}
			br.close();
			for(num=0;num<datas.get(0).size()-1;num=num+1){
				candAttr.add(num.toString());
			}
		} catch (IOException e1){
			e1.printStackTrace();
		}
	}
	
	public  void readcar(File file){
		try{
			FileReader fr=new FileReader(file);
			BufferedReader br=new BufferedReader(fr);
			String line;
			while((line=br.readLine())!=null){
				String[] values=line.split(",");
				ArrayList<String> al = new ArrayList<String>();
				ArrayList<String> ak = new ArrayList<String>();
				for(int i=0;i<values.length;i++){
					String value=values[i];
					
					al.add(value);
					ak.add(value);
				}
				datas.add(al);
				_datas.add(ak);
			}
			br.close();
			for(num=0;num<datas.get(0).size()-1;num=num+1){
				candAttr.add(num.toString());
			}
		} catch (IOException e1){
			e1.printStackTrace();
		}
	}
	
	public  void readecoli(File file){
		try{
			FileReader fr=new FileReader(file);
			BufferedReader br=new BufferedReader(fr);
			String line;
			while((line=br.readLine())!=null){
				String[] values=line.split("  ");
				ArrayList<String> al = new ArrayList<String>();
				ArrayList<String> ak = new ArrayList<String>();
				for(int i=1;i<values.length;i++){
					String value=values[i];
					
					al.add(value);
					ak.add(value);
				}
				datas.add(al);
				_datas.add(ak);
			}
			br.close();
			for(num=0;num<datas.get(0).size()-1;num=num+1){
				candAttr.add(num.toString());
			}
		} catch (IOException e1){
			e1.printStackTrace();
		}
	}
	
	public  void readcancer(File file){
		try{
			FileReader fr=new FileReader(file);
			BufferedReader br=new BufferedReader(fr);
			String line;
			while((line=br.readLine())!=null){
				String[] values=line.split(",");
				ArrayList<String> al = new ArrayList<String>();
				ArrayList<String> ak = new ArrayList<String>();
				for(int i=1;i<values.length;i++){
					String value=values[i];
					
					al.add(value);
					ak.add(value);
				}
				datas.add(al);
				_datas.add(ak);
			}
			br.close();
			for(num=0;num<datas.get(0).size()-1;num=num+1){
				candAttr.add(num.toString());
			}
		} catch (IOException e1){
			e1.printStackTrace();
		}
	}
}
