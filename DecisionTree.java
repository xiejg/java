import java.util.ArrayList;  
import java.util.HashMap;  
import java.util.Iterator;  
import java.util.Map;  

public class DecisionTree {
	//public int outputindex;
	
	public DecisionTree(){
	//	outputindex=index;
	}
	
	public Map<String,Integer> classOfDatas(ArrayList<ArrayList<String>> datas,
			ArrayList<String> attrList){
		Map<String, Integer> classes = new HashMap<String, Integer>();  
        String c = "";  
        ArrayList<String> tuple = null;  
        for (int i = 0; i < datas.size(); i++) {  
        	if(datas.get(i).size()==(attrList.size()+1)){
            tuple = datas.get(i);  
            c = tuple.get(tuple.size()-1);  
            if (classes.containsKey(c)) {  
                classes.put(c, classes.get(c) + 1);  
            } else {  
                classes.put(c, 1);  
            }  
        	}
        }  
        return classes;  
	}
	
	 public String maxClass(Map<String, Integer> classes){  
	        String maxC = "";  
	        int max = -1;  
	        Iterator iter = classes.entrySet().iterator();  
	        for(int i = 0; iter.hasNext(); i++)  
	        {  
	            Map.Entry entry = (Map.Entry) iter.next();   
	            String key = (String)entry.getKey();  
	            Integer val = (Integer) entry.getValue();   
	            if(val > max){  
	                max = val;  
	                maxC = key;  
	            }  
	        }  
	        return maxC;  
	    }  
	 public TreeNode buildTree(ArrayList<ArrayList<String>> datas, ArrayList<String> attrList
			 ,ArrayList<ArrayList<String>> _datas){
		 TreeNode node = new TreeNode();
		 node.setdatas(datas);
		 node.setcandAttr(attrList); 
		 Map<String, Integer> classes = classOfDatas(datas, attrList);
		 String maxC = maxClass(classes); 
		 if (classes.size() == 1 || attrList.size() == 0) {  
	            node.setname(maxC);  
	            return node;  
	        }  
		 Gain gain = new Gain(datas, attrList);
		 int bestAttrIndex = gain.bestGainIndex(attrList.size()-1);
		 int tmp=Integer.valueOf(attrList.get(bestAttrIndex));
		 ArrayList<String> rules = gain.getValues(_datas,tmp);
		 node.setrule(rules);  
	     node.setname(attrList.get(bestAttrIndex));
	     
	     //if(rules.size() > 2){  
	     ArrayList<String> tempattr= new ArrayList<String>() ;
	     for (int i=0;i<attrList.size();i++)
	    	 tempattr.add(attrList.get(i));
	     tempattr.remove(bestAttrIndex);  
	    	//attrList.remove(bestAttrIndex); 
	    //   }  
	     
	     
	     for (int i = 0; i < rules.size(); i++) {  
	            String rule = rules.get(i);  
	            ArrayList<ArrayList<String>> di = gain.datasOfValue(bestAttrIndex, rule); 
	            gain.removedatasOfValue(bestAttrIndex, rule);
	            for (int j = 0; j < di.size(); j++) {  
	                di.get(j).remove(bestAttrIndex); 
	                if(di.get(j).size()<=1)di.remove(j);
	                
	            }  
	            if (di.size() == 0) {  
	                TreeNode leafNode = new TreeNode();  
	                leafNode.setname(maxC);  
	                leafNode.setdatas(di);  
	                leafNode.setcandAttr(tempattr); 
	                leafNode.setvalue(rule);
	                node.getChild().add(leafNode);  
	                
	            } else {  
	                TreeNode newNode = buildTree(di,  tempattr,_datas);  
	                node.getChild().add(newNode); 
	                newNode.setvalue(rule);
	         
	                
	            }  
	              
	        }  
		 
		 return node;
	 }
	 
	
}