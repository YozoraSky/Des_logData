package resources;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
	private Properties props;
	public Properties load() {
		props = new Properties();
        try {
//        	讀取jar包內properties寫法!  注: 須把load()和props的static去掉才行
        	props.load(this.getClass().getResourceAsStream("/config.properties"));
//        	讀取包外properties寫法!
//        	props.load(new FileInputStream("src/config.properties"));
        } catch (FileNotFoundException e) {
        	e.printStackTrace();
        } catch (IOException e) {
        	e.printStackTrace();
        }
        return props;
	}
}
