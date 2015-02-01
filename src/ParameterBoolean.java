// Authors: Benjamin Harris and Michael Paradis
// Class for "boolean parameter type" in the DGGRID metafile front-end
// 
// February 17, 2013

import javax.swing.*;
import java.awt.event.*;

public class ParameterBoolean extends Widget implements ActionListener {
	private static final long serialVersionUID = 1115616835790821847L;
	private JRadioButton tb;
	private JRadioButton fb;
	private boolean realDefau;
	private boolean defau;
	private static final String T = "TRUE";
	private static final String F = "FALSE";
	private ControlDependency ctrDep;
	private DisableDependency disDep;


	public ParameterBoolean (String name, String dscrptn, String passign, boolean defaultR) {
		super(name, dscrptn, passign);
		tb = new JRadioButton(T);
		fb = new JRadioButton(F);
		cornerPane.setLayout(new BoxLayout(cornerPane, BoxLayout.PAGE_AXIS));
		cornerPane.add(tb);
		cornerPane.add(fb);
		defau = realDefau = defaultR;
		ButtonGroup bg = new ButtonGroup();
		bg.add(tb);
		bg.add(fb);
		tb.addActionListener(this);
		fb.addActionListener(this);
		setParaToDefault();
	} // end constructor ParameterBoolean()
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == tb) value = T;
		else if (obj == fb) value = F;
		MFeditor.passActionEvent(e, name);
		MFeditor.everything.checkWidgets(ctrDep);
	} // end implemented actionPerformed()
	public String getDefau () { return "" + defau; }
	public void setParaToDefault () {
		if (defau) {
			tb.setSelected(true);
			value = T;
		} else {
			fb.setSelected(true);
			value = F;
		} // end if-else
	} // end overridden setParaToDefault()
	public boolean setDefau (String fromPreset) {
		boolean ok = true;
		if (fromPreset.equalsIgnoreCase(T)) defau = true;
		else if (fromPreset.equalsIgnoreCase(F)) defau = false;
		else ok = false;
		return ok;
	} // end overridden setDefau()
	
	public void resetDefault () {
		defau = realDefau;
	} // end resetDefault()
	
	public boolean checkIfDefault () { return value.equalsIgnoreCase("" + defau); } // end overridden checkIfDefault()
	public boolean setValueRemotely (String s) {
		boolean ok = true;
		if (s.equalsIgnoreCase(T)) {
			tb.setSelected(true);
			value = T;
		} else if (s.equalsIgnoreCase(F)) {
			fb.setSelected(true);
			value = F;
		} else ok = false;
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
				tb.setEnabled(false);
				fb.setEnabled(false);
				super.nameField.setEnabled(false);
				setEnabled(false);
			}
			
			if(b ==false){
				tb.setEnabled(true);
				fb.setEnabled(true);
				super.nameField.setEnabled(true);
				setEnabled(true);
			}
			
	}//end of disableWidget()

} // end object class ParameterBoolean