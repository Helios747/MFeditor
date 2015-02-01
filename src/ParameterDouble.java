// Authors: Benjamin Harris and Michael Paradis
// Class for "double parameter type" in the DGGRID metafile front-end
// 
// February 17, 2013

//import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ParameterDouble extends Widget implements ActionListener {
	private static final long serialVersionUID = -1182655220948154010L;
	private double val;
	private JTextField tf;
	
	private double defau, realDefau;
	private double min;
	private double max;
	
	//dependency objects
	private ControlDependency ctrDep;
	private DisableDependency disDep;


	//private Color defC;
	//private Color warC = new Color(255, 0, 0, 90);
	public ParameterDouble (String name, String dscrptn, String passign, double min, double defaultR, double max) {
		super(name, dscrptn, passign);
		defau = realDefau = defaultR;
		this.min = min;
		this.max = max;
		tf = new JTextField(value);
		//defC = tf.getSelectionColor();
		tf.addActionListener(this);
		//Dimension tfDim = new Dimension(100, 30);
		tf.setMinimumSize(tfDim);
		tf.setMaximumSize(tfDim);
		tf.setPreferredSize(tfDim);		
		cornerPane.add(tf);
		setParaToDefault();
	} // end constructor ParameterDouble()
	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		double v;
		String s;
		if (obj == tf) {
			s = tf.getText();
			try {
				v = Double.parseDouble(s);
				if (v >= min && v <= max) {
					val = v;
					//js.setValue(val);
					value = s;
				} else {
					tf.setText(value);
					
					
					tf.selectAll();
					//tf.setSelectionColor(defC);
					//tf.setSelectionColor(warC);
					MFeditor.passNote("<font color=red>Input NOT accepted. Value for '" + name + "' must be between " + min + " and " + max + "</font><br>");
				} // end if-else
			} catch (NumberFormatException ex) {
				tf.setText(value);
				
			
				tf.selectAll();
				//tf.setSelectionColor(defC);
				//tf.setSelectionColor(warC);
				MFeditor.passNote("<font color=red>Input NOT accepted. Value for '" + name + "' must be a number (double)</font><br>");
			} // end try-catch
		} // end if
		MFeditor.passActionEvent(e, name);
		MFeditor.everything.checkWidgets(ctrDep);
	} // end implemented actionPerformed()
	public String getDefau () { return "" + defau; }
	public void setParaToDefault () {
		val = defau;
		value = "" + val;
		tf.setText(value);
		//js.setValue(val);
	} // end overridden setParaToDefault()
	public boolean setDefau (String fromPreset) {
		double fp;
		boolean ok = false;
		try {
			fp = Double.parseDouble(fromPreset);
			if (fp >= min && fp <= max) {
				defau = fp;
				ok = true;
			} // end if
		} catch (NumberFormatException ex) {}
		return ok;
	} // end overridden setTmpDefaultValue()
	public void resetDefault () {
		defau = realDefau;
	} // end resetDefault()
	public boolean checkIfDefault () { return (val == defau); } // end overridden checkIfDefault()
	public boolean setValueRemotely (String s) {
		double v;
		boolean ok = false;		
		try {
			v = Double.parseDouble(s);
			if (v >= min && v <= max) {
				val = v;
				value = "" + val;
				//value = s;
				tf.setText(value);
				ok = true;
			} // end if
		} catch (NumberFormatException ex) {}
		return ok;
	} // end overridden setValueRemotely()

	//to get the disable Dependency list. 
	public DisableDependency getDisDep()	{return this.disDep; }
	public ControlDependency getCtrDep()	{return this.ctrDep;}
	//inserts the Values and the corresponding Widget that this widget is dependent upon.
		public void insertDisableDependency(DisableDependency dD){
		this.disDep = dD;
	}	
	
	//insert Dependency List - Hold all of the names of the widgets this particular widget affects.
	public void insertControlList(String cl){
			ControlDependency check;						//temp for checking repeats
			check = this.ctrDep;								//assign the current list
			boolean flag = false;
			
			while( check != null && flag != true){
				if(check.disWidget == cl){flag = true;}	//if there are repeats exit
				else
					check = check.next;
			}
			if(flag == false){
			ControlDependency temp = new ControlDependency(cl);//make new link
			temp.next = this.ctrDep;									//newlink --> old first
			ctrDep = temp;													//old link gets new with newly added node
			}	
	}
	
	//this Method disables the widget depending on the boolean variable
	public void disableWidget(boolean b){
			//disable the widget
			if(b == true ){					
				tf.setEnabled(false);
				super.nameField.setEnabled(false);
				setEnabled(false);
			}
						//enable the widget
			if(b ==false){
				tf.setEnabled(true);
				super.nameField.setEnabled(true);
				setEnabled(true);
			}
	}//end of disableWidget
} // end object class ParameterDouble
