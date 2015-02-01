// Authors: Benjamin Harris and Michael Paradis
// Java class that does dependency functions for MFeditor
// June 17, 2013

public class DisableDependency {

	public DisableDependency next; //next item in the list
	private String controlWidget; //the widget that controls the disabling widget
	private String value; //the value that affects the disabling widget
	private	boolean reverse;

	public DisableDependency (String val, String cw, boolean r) {		
			controlWidget = cw;
			value = val;		
			reverse = r;
	} // end constructor DisableDependency()
	public String getValue () {return value; }
	public String getCtrlWidget () {return controlWidget; }
	public boolean getRev () { return reverse; }
} // end class DisableDependency