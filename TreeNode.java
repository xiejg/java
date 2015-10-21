import java.util.*;
public class TreeNode {
	private String name;
	private String value;
	private ArrayList<String> rule;
	public ArrayList<TreeNode> child;
	private ArrayList<ArrayList<String>> datas;
	private ArrayList<String> candAttr;
	
	public TreeNode(){
		this.name="";
		this.rule=new ArrayList<String>();
		this.child=new ArrayList<TreeNode>();
		this.datas=null;
		this.candAttr=null;
		this.value="";
	}
	
	public ArrayList<TreeNode> getChild(){
		return child;
	}
	
	public void setChild(ArrayList<TreeNode> child){
		this.child=child;
	}
	
	public ArrayList<String> getrule(){
		return rule;
	}
	
	public void setrule(ArrayList<String> rule){
		this.rule=rule;
	}
	
	public String getname(){
		return name;
	}
	
	public void setname(String name){
		this.name=name;
	}
	
	public ArrayList<ArrayList<String>>getdatas(){
		return datas;
	}
	
	public void setdatas(ArrayList<ArrayList<String>> datas){
		this.datas=datas;
	}
	
	public ArrayList<String> getcandAttr(){
		return candAttr;
	}
	
	public void setcandAttr(ArrayList<String> candAttr){
		this.candAttr=candAttr;
	}
	
	public void setvalue(String value){
		this.value=value;
	}
	
	public String getvalue(){
		return value;
	}
}