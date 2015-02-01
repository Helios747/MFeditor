// Authors: Benjamin Harris and Michael Paradis
// Java class that handles functioning of preset parameters for MFeditor
// June 17, 2013

public class Preset {
	private String name;
	private String[] paraName;
	private String[] paraVal;
	public Preset (String name, String[] paraName, String[] paraVal) {
		this.name = name;
		this.paraName = paraName;
		this.paraVal = paraVal;
	} // end constructor Preset()
	public String getName () { return name; }
	public String toString () { return "preset " + name; }
	public String[] getParaName () { return paraName; }
	public String[] getParaVal () { return paraVal; }
	public static Preset[] makePresets () {
				
		Preset[] pres = {

				
			new Preset("CUSTOM",		new String[]{"dggs_topology",	"dggs_proj",	"dggs_res_spec",	"dggs_aperture_type",	"dggs_aperture",	"dggs_num_aperture_4_res",	"dggs_orient_specify_type",	"dggs_num_placements",	"dggs_vert0_lon",	"dggs_vert0_lat",	"dggs_vert0_azimuth",	"dggs_res_specify_type"}, 
										new String[]{"HEXAGON",			"ISEA",			"10",				"PURE",					"4",				"0",						"SPECIFIED",				"1",					"11.25",			"58.28252559",		"0.0",					"SPECIFIED"}),
			
			new Preset("SUPERFUND",		new String[]{"dggs_topology",	"dggs_proj",	"dggs_res_spec",	"dggs_aperture_type",	"dggs_aperture",	"dggs_num_aperture_4_res",	"dggs_orient_specify_type", "dggs_num_placements",	"dggs_vert0_lon",	"dggs_vert0_lat",	"dggs_vert0_azimuth",	"dggs_res_specify_type",	"output_cell_label_type"}, 
										new String[]{"HEXAGON",			"FULLER",		"9",				"MIXED43",				"4",				"2",						"SPECIFIED",				"1",					"11.25",			"58.28252559",		"0.0",					"SPECIFIED",				"SUPERFUND"}),
			
			new Preset("ISEA3H",		new String[]{"dggs_topology",	"dggs_proj",	"dggs_res_spec",	"dggs_aperture_type",	"dggs_aperture",	"dggs_num_aperture_4_res",	"dggs_orient_specify_type",	"dggs_num_placements",	"dggs_vert0_lon",	"dggs_vert0_lat",	"dggs_vert0_azimuth",	"dggs_res_specify_type"}, 
										new String[]{"HEXAGON",			"ISEA",			"10",				"PURE",					"3",				"0",						"SPECIFIED",				"1",					"11.25",			"58.28252559",		"0.0",					"SPECIFIED"}),
			
			new Preset("ISEA4H",		new String[]{"dggs_topology",	"dggs_proj",	"dggs_res_spec",	"dggs_aperture_type",	"dggs_aperture",	"dggs_num_aperture_4_res",	"dggs_orient_specify_type",	"dggs_num_placements",	"dggs_vert0_lon",	"dggs_vert0_lat",	"dggs_vert0_azimuth",	"dggs_res_specify_type"}, 
										new String[]{"HEXAGON",			"ISEA",			"10",				"PURE",					"4",				"0",						"SPECIFIED",				"1",					"11.25",			"58.28252559",		"0.0",					"SPECIFIED"}),
			
			new Preset("ISEA43H",		new String[]{"dggs_topology",	"dggs_proj",	"dggs_res_spec",	"dggs_aperture_type",	"dggs_aperture",	"dggs_num_aperture_4_res",	"dggs_orient_specify_type",	"dggs_num_placements",	"dggs_vert0_lon",	"dggs_vert0_lat",	"dggs_vert0_azimuth",	"dggs_res_specify_type"}, 
										new String[]{"HEXAGON",			"ISEA",			"10",				"MIXED43",				"4",				"0",						"SPECIFIED",				"1",					"11.25",			"58.28252559",		"0.0",					"SPECIFIED"}),
			
			new Preset("ISEA4T",		new String[]{"dggs_topology",	"dggs_proj",	"dggs_res_spec",	"dggs_aperture_type",	"dggs_aperture",	"dggs_num_aperture_4_res",	"dggs_orient_specify_type",	"dggs_num_placements",	"dggs_vert0_lon",	"dggs_vert0_lat",	"dggs_vert0_azimuth",	"dggs_res_specify_type"}, 
										new String[]{"TRIANGLE",		"ISEA",			"10",				"PURE",					"4",				"0",						"SPECIFIED",				"1",					"11.25",			"58.28252559",		"0.0",					"SPECIFIED"}),
			
			new Preset("ISEA4D",		new String[]{"dggs_topology",	"dggs_proj",	"dggs_res_spec",	"dggs_aperture_type",	"dggs_aperture",	"dggs_num_aperture_4_res",	"dggs_orient_specify_type",	"dggs_num_placements",	"dggs_vert0_lon",	"dggs_vert0_lat",	"dggs_vert0_azimuth",	"dggs_res_specify_type"}, 
										new String[]{"DIAMOND",			"ISEA",			"10",				"PURE",					"4",				"0",						"SPECIFIED",				"1",					"11.25",			"58.28252559",		"0.0",					"SPECIFIED"}),
			
			new Preset("FULLER3H",		new String[]{"dggs_topology",	"dggs_proj",	"dggs_res_spec",	"dggs_aperture_type",	"dggs_aperture",	"dggs_num_aperture_4_res",	"dggs_orient_specify_type",	"dggs_num_placements",	"dggs_vert0_lon",	"dggs_vert0_lat",	"dggs_vert0_azimuth",	"dggs_res_specify_type"}, 
										new String[]{"HEXAGON",			"FULLER",		"10",				"PURE",					"3",				"0",						"SPECIFIED",				"1",					"11.25",			"58.28252559",		"0.0",					"SPECIFIED"}),
			
			new Preset("FULLER4H",		new String[]{"dggs_topology",	"dggs_proj",	"dggs_res_spec",	"dggs_aperture_type",	"dggs_aperture",	"dggs_num_aperture_4_res",	"dggs_orient_specify_type",	"dggs_num_placements",	"dggs_vert0_lon",	"dggs_vert0_lat",	"dggs_vert0_azimuth",	"dggs_res_specify_type"}, 
										new String[]{"HEXAGON",			"FULLER",		"10",				"PURE",					"4",				"0",						"SPECIFIED",				"1",					"11.25",			"58.28252559",		"0.0",					"SPECIFIED"}),
			
			new Preset("FULLER43H",		new String[]{"dggs_topology",	"dggs_proj",	"dggs_res_spec",	"dggs_aperture_type",	"dggs_aperture",	"dggs_num_aperture_4_res",	"dggs_orient_specify_type",	"dggs_num_placements",	"dggs_vert0_lon",	"dggs_vert0_lat",	"dggs_vert0_azimuth",	"dggs_res_specify_type"}, 
										new String[]{"HEXAGON",			"FULLER",		"10",				"MIXED43",				"4",				"0",						"SPECIFIED",				"1",					"11.25",			"58.28252559",		"0.0",					"SPECIFIED"}),
			
			new Preset("FULLER4T",		new String[]{"dggs_topology",	"dggs_proj",	"dggs_res_spec",	"dggs_aperture_type",	"dggs_aperture",	"dggs_num_aperture_4_res",	"dggs_orient_specify_type",	"dggs_num_placements",	"dggs_vert0_lon",	"dggs_vert0_lat",	"dggs_vert0_azimuth",	"dggs_res_specify_type"}, 
										new String[]{"TRIANGLE",		"FULLER",		"10",				"PURE",					"4",				"0",						"SPECIFIED",				"1",					"11.25",			"58.28252559",		"0.0",					"SPECIFIED"}),
			
			new Preset("FULLER4D",		new String[]{"dggs_topology",	"dggs_proj",	"dggs_res_spec",	"dggs_aperture_type",	"dggs_aperture",	"dggs_num_aperture_4_res",	"dggs_orient_specify_type",	"dggs_num_placements",	"dggs_vert0_lon",	"dggs_vert0_lat",	"dggs_vert0_azimuth",	"dggs_res_specify_type"}, 
										new String[]{"DIAMOND",			"FULLER",		"10",				"PURE",					"4",				"0",						"SPECIFIED",				"1",					"11.25",			"58.28252559",		"0.0",					"SPECIFIED"}),
		
			
			
			
		};
		return pres;
	} // makePresets()
} // end object class Preset