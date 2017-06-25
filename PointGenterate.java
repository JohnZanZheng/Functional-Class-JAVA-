import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class PointGenterate {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		try{
		File file = new File("123.txt");
		double[] pointsid = new double[10];
		String[] data = null;
		Element root = new Element("Placemarks");
		Document Doc = new Document(root);
		
		
		/*for(int i = 0; i <10; i++){
			double rn = (int)(Math.random()*120);
			System.out.println(rn);
			pointsid[i] = rn;
		}*/
		//read file
		InputStreamReader rs = new InputStreamReader(new FileInputStream(file));//create input stream reader object
		BufferedReader br = new BufferedReader(rs);
		String line = "";
		line = br.readLine();
		//
		//File write = new File("output.KML");
		//write.createNewFile();
		//BufferedWriter out = new BufferedWriter(new FileWriter(write));
		while(line != null){
			line = br.readLine();
			if(line==null){
				System.out.print("empty");
			}else{
			data = line.split(",|:|[|]");
			}
			for(int i = 0; i < data.length; i++){
				data[i] = data[i].trim();
				System.out.println(data[i] + "num" + i);
			}
			if(data.length > 15){
				//double id = Double.parseDouble(data[4]);
				//for(int i = 0; i <10; i++){
					//if(id == pointsid[i]){
						data[10] = data[10].substring(0, data[10].length()-2);
						data[15] = data[15].substring(1,data[15].length());
						data[16] = data[16].substring(0, data[16].length()-6);
						Element elements = new Element("Placemark");
						elements.addContent(new Element("name").setText(data[8]));
						elements.addContent(new Element("Description").setText(data[10]));
						elements.addContent(new Element("Type").setText(data[13]));
						elements.addContent(new Element("Coordinates").setText(data[15]+ ","+ data[16]));
						root.addContent(elements);
						/*out.write("");
						out.write(data[8]+" "+ data[10]+ " " + data[13] + data[15] + data[16]+ "\r\n");
						
						out.flush();*/
					//}
				//}
				
				Format format = Format.getPrettyFormat();
				XMLOutputter XMLOut = new XMLOutputter(format);
				XMLOut.output(Doc, new FileOutputStream("Point.XML"));
			}
				
				
			
			//System.out.println(line);
		}
		


		//out.close();
		}
		catch(Exception e){
			e.printStackTrace();			
		}
	}

}
