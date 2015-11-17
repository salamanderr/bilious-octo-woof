package resources;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ActionPane {
	private String name,message;
	private int def;
	private int result;
	private ArrayList<String> buttons=new ArrayList();
	private ImageIcon image;
public ActionPane(String name,String message){
	this.name=name;
	this.message=message;
}
public ActionPane setName(String name){
	this.name=name;
return this;
}
public ActionPane setMessage(String name){
	this.message=name;
return this;
}
public ActionPane(){
	
}
		public ActionPane addPane(String pane){
	buttons.add(pane);
	return this;
}
public ActionPane setDefault(int i){
	def=i;
	return this;
}
public ActionPane setImage(String url){
	image=new ImageIcon("res/"+url+".jpg");
	return this;
}
public String[] getArray(){
	String[] options; 
	int num=0;
	for (String v: buttons){
		num++;
	}
	if (num>0){
	options=new String[num];
	if (def>=num)
		def=num-1;
	num=0;
	for (String v:buttons){
		options[num]=v;
		num++;
	}
	
	return options;
	}return null;
}
public String getResult(){
	if (result>-1)
		if (getArray()!=null)
	return getArray()[result];
	
	return "Ok";
}
public String getInput(){
	return JOptionPane.showInputDialog(null,message);
}
public void run(){
	
	String[] options=getArray();
	
	
	if (options!=null){
		
		if (image==null){
	int i=  JOptionPane.showOptionDialog(null,
			message,
			name,
			JOptionPane.YES_NO_CANCEL_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			null,//do not use a custom Icon
			options,//the titles of buttons
			options[def]);//default button title
	result=i;
	
		}else{
			int i=  JOptionPane.showOptionDialog(null,
					message,
					name,
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					image,//do not use a custom Icon
					options,//the titles of buttons
					options[def]);//default button title
			result=i;
			
		}
	
	}else{
		if (image==null)
		JOptionPane.showMessageDialog(null, message,name,0);
		else
		JOptionPane.showMessageDialog(null, message,name,0,image);
		result=-1;
	
	}
}
}
