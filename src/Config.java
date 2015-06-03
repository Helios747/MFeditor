import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;


public class Config {

	private String strConfigPath;
	public String strLoadPath;
	public boolean bShowDefaults;
	public boolean bLastImportHeader;

	public Config() throws IOException
	{
		if (System.getProperty("os.name").contains("Windows"))
		{
			File theDir = new File(System.getProperty("user.home") + "\\AppData\\Roaming\\MFEditor\\");
			// if the directory does not exist, create it
			if (!theDir.exists())
			{
				theDir.mkdir();
			}
			strConfigPath = System.getProperty("user.home") + "\\AppData\\Roaming\\MFEditor\\" + "config.txt";

		}
		else
		{
			File theDir = new File(System.getProperty("user.home") + "//.mfeditor");
			// if the directory does not exist, create it
			if (!theDir.exists())
			{
				theDir.mkdir();
			}
			strConfigPath = System.getProperty("user.home") + "/.mfeditor" + "/config.txt";		

		}

		File f = new File(strConfigPath);
		if(f.exists() && !f.isDirectory()) 
		{
			BufferedReader br = new BufferedReader(new FileReader(strConfigPath));
			String line;
			while ((line = br.readLine()) != null) 
			{
				String[] arParsed = line.split("="); 
				if (arParsed[0].equals("LoadPath"))
				{
					strLoadPath = arParsed[1];
				}
				else if (arParsed[0].equals("ShowDefaults"))
				{
					//bShowDefaults = Boolean.getBoolean(arParsed[1]);

					if (arParsed[1].equals("true"))
					{
						bShowDefaults = true;
					}
					else
					{
						bShowDefaults = false;
					}
				}
				else if (arParsed[0].equals("LastImportHeader"))
				{
					if (arParsed[1].equals("true"))
					{
						bLastImportHeader = true;
					}
					else
					{
						bLastImportHeader = false;
					}				
				}
			}
			br.close();
		}
		else
		{
			PrintWriter writer = new PrintWriter(strConfigPath, "UTF-8");
			writer.println("LoadPath=null");
			writer.println("ShowDefaults=false");
			writer.println("LastImportHeader=true");
			writer.close();
			strLoadPath = null;
			bShowDefaults = false;
			bLastImportHeader = true;
		}
	}

	public void loadConfig() throws IOException
	{

	}

	//	strString valid values:
	//	LoadPath (String path)
	//	ShowDefaults (Boolean string)
	//	ShowLastImportHeader (Boolean string)
	//	THIS NEEDS IMPROVING FOR NEXT VERSION.

	public void saveConfig(String strSetting, String strValue) throws IOException
	{

		if (strSetting.equals("LoadPath"))
		{
			updateLine("LoadPath" + "=" + strLoadPath,"LoadPath" + "=" + strValue);
			strLoadPath = strValue;
		}
		else if (strSetting.equals("ShowDefaults"))
		{
			updateLine("ShowDefaults" + "=" + Boolean.toString(bShowDefaults),"ShowDefaults" + "=" + strValue);
			bShowDefaults = Boolean.getBoolean(strValue);
		}
		else if (strSetting.equals("ShowLastImportHeader"))
		{
			updateLine("LastImportHeader" + "=" + Boolean.toString(bLastImportHeader),"LastImportHeader" + "=" + strValue);
			bLastImportHeader = Boolean.getBoolean(strValue);
		}



	}

	private void updateLine(String toUpdate, String updated) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader(strConfigPath));
		String line;
		String input = "";

		while ((line = file.readLine()) != null)
			input += line + System.lineSeparator();

		input = input.replace(toUpdate, updated);

		FileOutputStream os = new FileOutputStream(strConfigPath);
		os.write(input.getBytes());

		file.close();
		os.close();
	}
}
