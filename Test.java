import java.io.*;
import java.util.*;
public class Test {
	public static ArrayList<ArrayList<String>> datas=new ArrayList<ArrayList<String>>();
	public static ArrayList<ArrayList<String>> _datas=new ArrayList<ArrayList<String>>();
	public static ArrayList<String> candAttr=new ArrayList<String>();;
	public static Integer num=new Integer(0);
	
	
	 public static String SearchTree(TreeNode root,ArrayList<String> value){
		 String result="";
		 TreeNode next=root;
		 
		 while(next.getChild().size()!=0){
			 TreeNode temp=null;
			 int index=candAttr.indexOf(next.getname());
			 for(int i=0;i<next.getChild().size();i++){
				 temp=next.getChild().get(i);
				 
				 if(value.get(index).equals(temp.getvalue())){
					 next=temp;
					 break;
				 }
			 }
			 
		 }
		 result=next.getname();
		 return result;
	 }
	

	
	
	public static void main(String[] args){
		ArrayList<ArrayList<String>> train=new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>> test=new ArrayList<ArrayList<String>>();
		int correct=0;
		ArrayList<String> value;
		String path="/home/xie/CS6573/data/breast-cancer-wisconsin.data";
		Read rd=new Read(datas,_datas,candAttr);
		rd.readcancer(new File(path));
		for(int i=0;i<=candAttr.size();i=i+1)
		System.out.print(datas.get(0).get(i)+" ");
		System.out.print(datas.get(0).size()+" ");
		List<ArrayList<String>> temp=datas.subList(0, datas.size()*4/5-1);
		for(int i=0;i<temp.size();i++){
			train.add(temp.get(i));
			//train.get(i).remove(0);
		}
		temp=datas.subList(datas.size()*4/5,datas.size());
		for(int i=0;i<temp.size();i++){
			test.add(temp.get(i));
			//test.get(i).remove(0);
		}
		///////////////////////////////////////
		DecisionTree tree=new DecisionTree();
		TreeNode root=tree.buildTree(train, candAttr,_datas);
		//System.out.print(" finished");
		for(int i=0;i<test.size();i++){
			value=test.get(i);
			if(value.get(candAttr.size()).equals(SearchTree(root,value))){
				correct++;
			}
		}
		System.out.print((double)correct/test.size());
		
		
	}
}
