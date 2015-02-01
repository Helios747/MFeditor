// Authors: Benjamin Harris and Michael Paradis
// Class for "choice parameter type" in the DGGRID metafile front-end
// 
// February 17, 2013

import java.awt.event.*;
import javax.swing.*;

public class ParameterChoice extends Widget implements ActionListener {
	private static final long serialVersionUID = 8084613145489329630L;
	String[] choices;
	JRadioButton[] buttonChoi;
	
	int numChoi;
	String realDefau;
	String defau;
	private ControlDependency ctrDep;
	private DisableDependency disDep;
	

	public ParameterChoice (String name, String dscrptn, String passign, boolean isHoriz, boolean targetIsTop, String[] choices, int ind) {
		super(name, dscrptn, passign);
		this.choices = choices;
		JPanel target;
		//if (targetIsTop) target = cornerPane;
		//else target = bottomPane;
		target = cornerPane;
		//if (isHoriz) target.setLayout(new BoxLayout(target, BoxLayout.LINE_AXIS));
		//else target.setLayout(new BoxLayout(target, BoxLayout.PAGE_AXIS));
		target.setLayout(new BoxLayout(target, BoxLayout.PAGE_AXIS));
		defau = realDefau = choices[ind];
		numChoi = choices.length;
		buttonChoi = new JRadioButton[numChoi];
		ButtonGroup bg = new ButtonGroup();
		for (int i = 0; i < numChoi; i++) {
			buttonChoi[i] = new JRadioButton(choices[i]);
			target.add(buttonChoi[i]);
			bg.add(buttonChoi[i]);
			buttonChoi[i].addActionListener(this);
		} // end for
		setParaToDefault();
	} // end constructor ParameterChoice()
	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		for (int i = 0; i < numChoi; i++) if (obj == buttonChoi[i]) value = choices[i];
		MFeditor.everything.checkWidgets(ctrDep);
		MFeditor.passActionEvent(e, name);
		
	} // end implemented actionPerformed()
	public String getDefau () { return defau; }
	public void setParaToDefault () {
		for (int i = 0; i < numChoi; i++)
			if (choices[i].equalsIgnoreCase(defau)) {
				value = choices[i];
				buttonChoi[i].setSelected(true);
				break;
			} // end if
	} // end overridden setParaToDefault()
	public boolean setDefau (String fromPreset) {
		boolean ok = false;
		for (int i = 0; i < numChoi; i++)
			if (fromPreset.equalsIgnoreCase(choices[i])) {
				defau = choices[i];
				ok = true;
			} // end if
		return ok;
	} // end overridden setDefau()
	public void resetDefault () {
		defau = realDefau;
	} // end resetDefault()
	public boolean checkIfDefault () { return value.equalsIgnoreCase("" + defau); } // end overridden checkIfDefault
	public boolean setValueRemotely (String s) {
		boolean ok = false;
		for (int i = 0; i < numChoi; i++)
			if (s.equalsIgnoreCase(choices[i])) {
				value = choices[i];
				buttonChoi[i].setSelected(true);
				ok = true;
			} // end if
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
	
			if(b == true){
				super.nameField.setEnabled(false);
				for (int i = 0; i < buttonChoi.length; i ++){
					buttonChoi[i].setEnabled(false);
				}
				setEnabled(false);
			}
			if(b == false){
				super.nameField.setEnabled(true);
				for (int i = 0; i < buttonChoi.length; i ++){
					buttonChoi[i].setEnabled(true);
				}
				setEnabled(true);
			}
	}//end of disableWidget

} // end object class ParameterChoice