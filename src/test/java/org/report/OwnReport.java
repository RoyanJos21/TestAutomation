package org.report;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.log4testng.Logger;
import org.testng.xml.XmlSuite;

public class OwnReport implements IReporter {
	private PrintWriter out;
    private int row;
    private Integer testIndex;
    private int methodIndex;
    private Scanner scanner;
	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outdir) {
		final Logger l = Logger.getLogger(OwnReport.class);
		 try {
	            out = createWriter(outdir);
	        } catch (Exception e) {
	            l.error("output file", e);
	            return;
	        }
		 	
		
	}
	protected PrintWriter createWriter(String outdir) {
		new File(outdir).mkdirs();
		return new PrintWriter(new BufferedWriter(new FileWriter(new File(outdir, "reportCustom.html"))))
	}

}
