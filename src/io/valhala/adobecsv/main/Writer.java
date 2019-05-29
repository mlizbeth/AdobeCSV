package io.valhala.adobecsv.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
	
	private static final String DELIMITER = ",";
	private String LINE = "";
	private String inFile = "";
	private String outFile = "C:\\Users\\Madeline Kotara\\Desktop\\Test.csv";
	private BufferedWriter bw;
	private BufferedReader br;
	private Entity e = new Entity();
	
	public Writer(Mode mode) {
		
		if(mode == Mode.STUDENT) {
			e.setProductConfigurations("\"Default Spark with Premium Features for Higher-Ed - 2 GB configuration\"");
		}
		if(mode == Mode.FACSTAFF) {
			e.setProductConfigurations("\"Default All Apps plan - 20 GB configuration\"");
		}
		
		try {
			bw = new BufferedWriter(new FileWriter(outFile, true));
			for(int x = 0; x < Headers.getHeaders.length; x++) {
				if(x != 14) {
					bw.write(Headers.getHeaders[x].toString() + DELIMITER);
					bw.flush();
				}
				else {
					bw.write(Headers.getHeaders[x].toString());
					bw.newLine();
					bw.flush();
				}
			}
		} catch (IOException e) {}
		
	}
	
	public void write() throws IOException {
		
		bw.write(e.getIdentityType() + DELIMITER);
		bw.write(e.getUsername() + DELIMITER);
		bw.write(e.getDomain() + DELIMITER);
		bw.write(e.getUsername() + "@trinity.edu" + DELIMITER);
		bw.write(e.getFirstName() + DELIMITER);
		bw.write(e.getLastName() + DELIMITER);
		bw.write(e.getCountryCode() + DELIMITER);
		bw.write(e.getProductConfigurations() + DELIMITER);
		bw.write(DELIMITER);
		bw.write(DELIMITER);
		bw.write(DELIMITER);
		bw.write(DELIMITER);
		bw.write(DELIMITER);
		bw.write(DELIMITER);
		bw.write("");
		bw.newLine();
		bw.flush();
	}
	
	public void read(String inFile) {
		this.inFile = inFile;
		
		try {
			br = new BufferedReader(new FileReader(inFile));
			while((LINE = br.readLine()) != null ) {
				String[] name = LINE.split(",");
				String[] formattedName = new String[3];
				for(int x = 0; x < name.length; x++) {
					formattedName[x] = name[x].substring(name[x].indexOf("\"") + 1, (name[x].lastIndexOf("\"")));
					if(x == 0) {
						e.setFirstName(formattedName[x]);
					}
					if(x == 1) {
						e.setLastName(formattedName[x]);
					}
					if(x == 2) {
						e.setUsername(formattedName[x]);
						write();
					}
				}
			}
		} catch (IOException e) {}
	}

	public String getInFile() {
		return inFile;
	}

	public void setInFile(String inFile) {
		this.inFile = inFile;
		read(inFile);
	}

	public String getOutFile() {
		return outFile;
	}

	public void setOutFile(String outFile) {
		this.outFile = outFile;
	}
	
	
}
