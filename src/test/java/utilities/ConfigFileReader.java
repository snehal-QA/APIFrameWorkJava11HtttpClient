package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	private Properties prop;
	private final String propertyFilePath=(System.getProperty("user.dir")+"/src/test/resources/configuration/ExpectedErrors_SignUppage.properties");
	
	public ConfigFileReader() throws IOException
	{
		prop =new Properties();
		FileInputStream fis =new FileInputStream(propertyFilePath);

		prop.load(fis);
	}
	
	public String readProperty(String key)
	{	
		 return (String) prop.get(key);
	}
	
}
