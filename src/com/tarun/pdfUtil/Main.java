/**
 * 
 */
package com.tarun.pdfUtil;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.util.PDFMergerUtility;

/**
 * @author Tarun.Goel
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			String inputFolder = new String("input");
			String outputFolder = new String("output");

			File fileInputFolder = new File(inputFolder);
			String[] inputFileList = fileInputFolder.list();
			System.out.println("File List Size: " + inputFileList.length);
			PDFMergerUtility pdfMergeUtility = new PDFMergerUtility();

			Arrays.sort(inputFileList);
			for (String pdfFile : inputFileList) {
				System.out.println(pdfFile);
				pdfMergeUtility
						.addSource(new File(inputFolder + "/" + pdfFile));
			}

			pdfMergeUtility
					.setDestinationFileName(outputFolder + "/merged_" + System.currentTimeMillis() + ".pdf");

			pdfMergeUtility.mergeDocuments();

		} catch (COSVisitorException e) {
			System.out.println("Exception Happens : " + e.getMessage());
			e.printStackTrace();
		}
		catch (IOException e) {
			System.out.println("Exception Happens : " + e.getMessage());
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("Exception Happens : " + e.getMessage());
			e.printStackTrace();
		}
	}

}
