package run.com;

import java.io.IOException;

public class MainFile 
{
public static void main(String args[]) throws InterruptedException, IOException {
		

	       OpenBrowser open=new OpenBrowser();
			open.setChromeProperty();
			open.Run();	
			open.test();
			
	}
}
