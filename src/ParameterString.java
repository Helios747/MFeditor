// Authors: Benjamin Harris and Michael Paradis
// Class for "String parameter type" in the DGGRID metafile front-end
// 
// February 17, 2013

//import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;

public class ParameterString extends Widget implements ActionListener {
	private static final long serialVersionUID = 8351048124313484784L;
	private JTextField tf;
	private String realDefau;
	private String defau = "";
	
	
	private ControlDependency ctrDep;
	private DisableDependency disDep;


	public ParameterString (String name, String dscrptn, String passign, String defaultR) {
		super(name, dscrptn, passign);
		defau = realDefau = defaultR;
		tf = new JTextField();
		tf.addActionListener(this);
		//Dimension tfDim = new Dimension(100, 30);
		tf.setMinimumSize(tfDim);
		tf.setMaximumSize(tfDim);
		tf.setPreferredSize(tfDim);
		cornerPane.add(tf);
		setParaToDefault();
	} // end constructor ParameterString()
	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		if(obj == tf) value = tf.getText();
		MFeditor.passActionEvent(e, name);
		MFeditor.everything.checkWidgets(ctrDep);
	} // end implemented actionPerformed()
	public String getDefau () { return defau; } // end overridden getDefau()
	public void setParaToDefault () {
		value = defau;
		tf.setText(value);
		
	} // end overridden setParaToDefault()
	public boolean setDefau (String fromPreset) {
		defau = fromPreset;
		return true;
	} // end overridden setDefau()
	public void resetDefault () {
		defau = realDefau;
	} // end resetDefault()
	public boolean checkIfDefault () { return (value.equals(defau)); } // end overridden checkIfDefault()
	public boolean setValueRemotely (String s) {
		value = s;
		tf.setText(value);
		return true;
	} // end overridden setValueRemotely()
	 
	public DisableDependency getDisDep()	{return this.disDep; }
	public ControlDependency getCtrDep()	{return this.ctrDep;}
	
	public void insertDisableDependency(DisableDependency dD){
		this.disDep = dD;
	} // end insertDisableDependency()
	
	
	public void insertControlList (String cl) {
			ControlDependency check;  //temp for checking repeats
			check = this.ctrDep; //assign the current list
			boolean flag = false;
			
			while (check != null && flag != true) {
				if (check.disWidget == cl) flag = true; //if there are repeats exit
				else check = check.next;
				
			} // end while
			if (flag == false) {
				ControlDependency temp = new ControlDependency(cl); //make new link
				temp.next = this.ctrDep; //newlink --> old first
				ctrDep = temp; //old link gets new with newly added node
			} // end if
	} // end insertControlList()
	
	public void disableWidget(boolean b){
			
			if(b == true ){					
				tf.setEnabled(false);
				super.nameField.setEnabled(false);
				setEnabled(false);
			}
			
			if(b ==false){
				tf.setEnabled(true);
				super.nameField.setEnabled(true);
				setEnabled(true);
			}
	} // end disableWidget()
	
} // end class ParameterString
