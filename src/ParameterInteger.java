// Authors: Benjamin Harris and Michael Paradis
// Class for "integer parameter type" in the DGGRID metafile front-end
// 
// February 17, 2013

import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ParameterInteger extends Widget implements ActionListener, ChangeListener {
	private static final long serialVersionUID = 1997499320341688873L;
	private int val;
	private JTextField tf;
	private JSlider js;
	private int realDefau, defau;
	private int min;
	private int max;
	private boolean ws;
	
	//dependency objects
	private ControlDependency ctrDep;
	private DisableDependency disDep;


	public ParameterInteger (String name, String dscrptn, String passign, boolean withSlide, int min, int defaultR, int max) {
		super(name, dscrptn, passign);
		ws = withSlide;
		defau = realDefau = defaultR;
		this.min = min;
		this.max = max;
		tf = new JTextField();
		tf.addActionListener(this);
		//Dimension tfDim = new Dimension(100, 30);
		tf.setMinimumSize(tfDim);
		tf.setMaximumSize(tfDim);
		tf.setPreferredSize(tfDim);
		cornerPane.add(tf);
		if (withSlide) {
			js = new JSlider(min, max, defau);
			if (max - min > 12) js.setMajorTickSpacing((max - min) / 10);
			else js.setMajorTickSpacing(1);
			js.setPaintTicks(true);
			js.setPaintLabels(true);
			js.addChangeListener(this);
			bottomPane.setLayout(new BoxLayout(bottomPane, BoxLayout.LINE_AXIS));
			bottomPane.add(Box.createRigidArea(new Dimension(20, 1)));
			bottomPane.add(js);
			bottomPane.add(Box.createRigidArea(new Dimension(20, 1)));
		} // end if	
		setParaToDefault();
	} // end constructor ParameterInteger()
	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		int v;
		String s;
		if (obj == tf) {
			s = tf.getText();
			try {
				v = Integer.parseInt(s);
				if (v >= min && v <= max) {
					val = v;
					if (ws) js.setValue(val);
					value = s;
				} else {
					tf.setText(value);
					tf.selectAll();
					MFeditor.passNote("<font color=red>Input NOT accepted. Value for '" + name + "' must be between " + min + " and " + max + "</font><br>");
				} // end if-else
			} catch (NumberFormatException ex) {
				tf.setText(value);
				tf.selectAll();
				MFeditor.passNote("<font color=red>Input NOT accepted. Value for '" + name + "' must be an integer</font><br>");
			} // end try-catch
		} // end if
		MFeditor.passActionEvent(e, name);
		MFeditor.everything.checkWidgets(ctrDep);
	} // end implemented actionPerformed()
	public void stateChanged(ChangeEvent e) {
		Object obj = e.getSource();
		if (ws) {
			if (obj == js) {
				val = js.getValue();
				value = "" + val;
				tf.setText(value);
			} // end if
		} // end if
		ActionEvent ae = new ActionEvent(this, 1234567, "");
		MFeditor.passActionEvent(ae, name);
	} // end implemented stateChanged()
	public String getDefau () { return "" + defau; } // end overridden getDefau()
	public void setParaToDefault () {
		val = defau;
		value = "" + val;
		tf.setText(value);
		if (ws) js.setValue(val);
	} // end overridden setParaToDefault()
	public boolean setDefau (String fromPreset) {
		int fp;
		boolean ok = false;
		try {
			fp = Integer.parseInt(fromPreset);
			if (fp >= min && fp <= max) {
				defau = fp;
				ok = true;
			} // end if
		} catch (NumberFormatException ex) {
		} // end try-catch
		return ok;
	} // end overridden setDefau()
	public void resetDefault () {
		defau = realDefau;
	} // end resetDefault()
	public boolean checkIfDefault () { return (val == defau); } // end overridden checkIfDefault()
	public boolean setValueRemotely (String s) {
		boolean ok = false;
		int v;
		try {
			v = Integer.parseInt(s);
			if (v >= min && v <= max) {
				val = v;
				value = "" + val;
				//value = s;
				tf.setText(value);
				if (ws) js.setValue(val);
				ok = true;
			} // end if
		} catch (NumberFormatException ex) {
		} // end try-catch
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
				if(ws == true)js.setEnabled(false);
				setEnabled(false);
			}
						//enable the widget
			if(b ==false){
				tf.setEnabled(true);
				super.nameField.setEnabled(true);
				if(ws ==true)js.setEnabled(true);
				setEnabled(true);
			}
	}//end of disableWidget
	//newly added method
	public void setSlider(int l, int h){
		this.min = l;
		this.max = h;
		
		bottomPane.remove(js);
		
		js = new JSlider(min, max, defau);
		js.setMajorTickSpacing(max - min);
		if(h == 10){js.setMajorTickSpacing((max - min) / 10);}
	
		
		js.setPaintTicks(true);
		js.setPaintLabels(true);
		js.addChangeListener(this);
		bottomPane.add(js);
	}//end of setSlider	
} // end object class ParameterInteger