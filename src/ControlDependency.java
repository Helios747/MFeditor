// Authors: Benjamin Harris and Michael Paradis
// Java class that is the control dependency object for MFeditor
// June 17, 2013

public class ControlDependency {

		public ControlDependency next;
		public String disWidget;
		
		public ControlDependency (String disableWidget){
				disWidget = disableWidget;	
		} // end constructor ControlDependency()
} // end class ControlDependency