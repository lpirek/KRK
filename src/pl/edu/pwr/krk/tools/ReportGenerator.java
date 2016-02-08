package pl.edu.pwr.krk.tools;

import java.io.File;
import java.io.FileNotFoundException;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.AbstractSampleApp;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

public class ReportGenerator extends AbstractSampleApp {

	public void test() throws JRException {
		compile();
		fill();
		pdf();
	}

	/**
	 *
	 */
	public void compile() throws JRException {
		JasperCompileManager.compileReportToFile("D:/Studia/Semestr II/PSI/KRK/webapp/resources/reports/StylesReport.jrxml", "D:/Studia/Semestr II/PSI/KRK/webapp/resources/reports/StylesReport.jasper");
	}

	/**
	 *
	 */
	public void fill() throws JRException {
		long start = System.currentTimeMillis();
		JasperFillManager.fillReportToFile("D:/Studia/Semestr II/PSI/KRK/webapp/resources/reports/StylesReport.jasper", null);
		System.err.println("Filling time : " + (System.currentTimeMillis() - start));
	}

	/**
	 *
	 */
	public void pdf() throws JRException {
		long start = System.currentTimeMillis();
		File sourceFile = new File("D:/Studia/Semestr II/PSI/KRK/webapp/resources/reports/StylesReport.jrprint");

		JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(sourceFile);

		File destFile = new File(sourceFile.getParent(), jasperPrint.getName() + ".pdf");

		JRPdfExporter exporter = new JRPdfExporter();

		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(destFile));

		exporter.exportReport();

		System.err.println("PDF creation time : " + (System.currentTimeMillis() - start));
	}

}
