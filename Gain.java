import java.util.ArrayList;  
import java.util.HashMap;  
import java.util.Iterator;  
import java.util.Map;
public class Gain {
	private ArrayList<ArrayList<String>> D=null;
	private ArrayList<String> attrList=null;

	public Gain(ArrayList<ArrayList<String>> datas,ArrayList<String> attrList){
		this.D=datas;
		this.attrList=attrList;
		
	}
	
	public ArrayList<String> getValues(ArrayList<ArrayList<String>> datas,int index){
		ArrayList<String> values=new ArrayList<String>();
		String r="";

		for(int i=0;i<datas.size();i++){
			//if(datas.get(i).size()==(attrList.size()+1))
			r=datas.get(i).get(index);
			if(!values.contains(r)){
				values.add(r);
			}
		}
		return values;
	}
	
	public Map<String,Integer> valueCounts(ArrayList<ArrayList<String>> datas,int index){
		Map<String,Integer> valueCount=new HashMap<String,Integer>();
		String c="";
		ArrayList<String> tuple=null;
		for(int i=0;i<datas.size();i++){
			if(datas.get(i).size()==(attrList.size()+1)){
			tuple=datas.get(i);
			c=tuple.get(index);
			if(valueCount.containsKey(c)){
				valueCount.put(c, valueCount.get(c)+1);
			}
			else{
				valueCount.put(c, 1);
			}
			}
		}
		return valueCount;
	}
	
	public double infoD(ArrayList<ArrayList<String>> datas){
		double info=0.0;
		int total=datas.size();
		Map<String, Integer> classes = valueCounts(datas, attrList.size());  
        Iterator iter = classes.entrySet().iterator();  
        Integer[] counts = new Integer[classes.size()];  
        for(int i = 0; iter.hasNext(); i++)  
        {  
            Map.Entry entry = (Map.Entry) iter.next();   
            Integer val = (Integer) entry.getValue();   
            counts[i] = val;  
        }  
        for (int i = 0; i < counts.length; i++) {  
            double base = counts[i]/(double)total; 
            info += (-1) * base * Math.log(base)/Math.log(2);  
        }  
        return info;  
		
	}
	
	public ArrayList<ArrayList<String>> datasOfValue(int Index, String value){  
        ArrayList<ArrayList<String>> Di = new ArrayList<ArrayList<String>>();  
        ArrayList<String> t = null;  
        for (int i = 0; i < D.size(); i++) { 
        	//for(int j=0;j<D.get(0).size();j++)
           // t .add( D.get(i).get(j));  
        	if(D.get(i).size()==(attrList.size()+1)){
        	t=D.get(i);
        	}
            if((t!=null)&&t.get(Index).equals(value)){  
                Di.add(t);  
            }  
            t=null;
        }  
        return Di;  
    }  
	
	public void removedatasOfValue(int Index, String value){  
		ArrayList<String> t = null;  
        for (int i = 0; i < D.size(); i++) { 
        	//for(int j=0;j<D.get(0).size();j++)
           // t .add( D.get(i).get(j));  
        	if(D.get(i).size()==(attrList.size()+1)){
        	t=D.get(i);
        	}
        	if((t!=null)&&t.get(Index).equals(value)){  
               D.remove(i);  
            }  
        }
            
    }  
	
	public double infoAttr(int index){
		double info=0.0;
		ArrayList<String> values=getValues(D,index);
		for(int i=0;i<values.size();i++){
			ArrayList<ArrayList<String>> dv=datasOfValue(index,values.get(i));
			double base=dv.size()/(double)D.size();
			info +=(-1)*base*infoD(dv);
		}
		return info;
	}
	
	public int bestGainIndex(int outputindex){
		int index=-1;
		double gain=-100000.0;
		double tempgain=0.0;
		for(int i=0;i<attrList.size();i++){
			tempgain=infoD(D)-infoAttr(i);
			if(tempgain>gain){
				gain=tempgain;
				index=i;
			}
		}
		return index;
	}
	
	
}