package com.jpmc;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.util.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import javax.imageio.ImageIO;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

class PDFRead{
	void ReadPdf()
	{  // String data = new String();
		String[][] mapping={{"Credit Support Agreement Industry Version",
							"Paragraph 13 – Elections & Variables",
							"1994 ISDA Credit Support Annex (Security Interest-New York Law)","1"},
				           {"Security Interest for Obligation Exists","includes no additional obligations with respect to either party",
							"No","1"},
						   {"Delivery Amount Meaning","(A) “Delivery amount” has the meaning specified in ",
								"ISDA-CSA Standard","1"},
							{"Credit Support Amount Returnable","“Credit Support Amount” has the meaning specified", 
								"Yes","1"}
							};
		//System.out.print(mapping[2][1] + ": ");
		
							
	

		PDDocument pd;
		// BufferedWriter wr;
		 try {
			 Boolean check=true;
	         File input = new File("C://Users//Jishnu Surendran//Desktop//JPMC//Lisa CSA_1.pdf");  // The PDF file from where you would like to extract
	        // File output = new File("D://workspace//SampleText.txt"); // The text file where you are going to store the extracted data
	         pd = PDDocument.load(input);
	         int page_count=pd.getNumberOfPages();
	         String[] page_wise_string = new String[page_count+1];
	         System.out.println("Total number of pages " +pd.getNumberOfPages());
	         System.out.println(pd.isEncrypted());
	         pd.save("THE_AES_CORPORATION_Proxy_Statement_14_A.pdf"); // Creates a copy called "CopyOfInvoice.pdf"
	         PDFTextStripper stripper = new PDFTextStripper();
	         //System.out.println(stripper.getText(pd));
	        // data=new String(stripper.getText(pd));
	        // System.out.println(data);
	         for(int i=0;i<page_count+1;i++)
	         {   
	        	 stripper.setStartPage(i); //Start extracting from page 3
		         stripper.setEndPage(i); //Extract till page 5
	        	 page_wise_string[i]= stripper.getText(pd);
	         }
	        System.out.println("done here");
	         //Finding out based on mapping
	         for(int j=0;j<mapping.length;j++)
	         {
	        	int page_number=Integer.parseInt(mapping[j][3]);
	        	
	        	String key_word=mapping[j][1];
	        	//System.out.println(page_wise_string[page_number]);
	        	check=findMe(key_word.replace(" ", "").toLowerCase(), page_wise_string[page_number].replace(" ", "").replace("\n", "").replace("\r", "").toLowerCase());
	        	//System.out.println(check);
	        	
	        	  
	         }
	        
	 } catch (Exception e){
	         e.printStackTrace();
	        }
		// return data;
		 
	}
	public static boolean findMe(String subString, String mainString) {
        boolean foundme = false;
        @SuppressWarnings("unused")
		int max = mainString.length() - subString.length();
 
        // Java's Default "contains()" Method
        System.out.println(mainString.contains(subString) ? "mainString.contains(subString) Check Passed.."
                : "mainString.contains(subString) Check Failed..");
        //System.out.println(mainString+"     "+subString);
		return foundme;
	}
}

public class MatchProcess {
    public static void main(String[] args) throws IOException  {  	
    	PDFRead pdfread=new PDFRead();
    	pdfread.ReadPdf();   	
    	System.out.println("Executed both");
        }
}
    

