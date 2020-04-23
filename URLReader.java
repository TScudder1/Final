package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * This is the URL reader to read the URL into a string
 * for processing.
 * 
 * The Macbeth file returned a 503 error.  So I sub'd a Poe link instead.
 * 
 * @return FileString
 * @exception IOException on input error 
 * @see IOException
 *
 */

public class URLReader {
	String fileString;

	//public URLReader() {    }
	
	public String main() throws MalformedURLException {

		// create the URL
		URL file = new URL("https://www.eapoe.org/works/poems/annabela.htm");

		// Open the URL stream and create readers convert to string
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(file.openStream()));
			
			// write the output
			StringBuilder response = new StringBuilder();
			String inputLine;
			while ((inputLine = reader.readLine()) != null)
				response.append(inputLine);
			
			// close reader
			reader.close();			
			fileString = response.toString();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error");
		}

		return fileString;

	}


}
