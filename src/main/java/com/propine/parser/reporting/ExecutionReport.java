package com.propine.parser.reporting;

import com.propine.parser.bo.TestcaseBO;
import com.propine.parser.constants.TestExecutionStatus;
import com.propine.parser.fileCreation.HtmlFile;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class ExecutionReport {

	Logger logger = Logger.getLogger(ExecutionReport.class);

	// testcase list
	public static List<TestcaseBO> testcaseList = new LinkedList<>();

	/**
	 * Create Execution Report
	 */
	public void createReport() {
		logger.info("Creating Report..");

		//get html string
		StringBuilder htmlStringBuilder = parseTestcaseList();

		// create report
		HtmlFile.createFile(htmlStringBuilder.toString());
	}

	/**
	 * Initializes common html string to generate report
	 *
	 * @return htmlString
	 */
	private StringBuilder initializeHTMLString() {
		StringBuilder htmlStringBuilder = new StringBuilder();
		htmlStringBuilder.append("<html><head><h2 align=\"center\">ExecutionReport</h2>");
		htmlStringBuilder.append(
				"<style>table, th, td { border: 1.2px solid black; border-collapse: collapse;font-family:calibri} th, " +
						"td { padding: 5px;}th { text-align: center; background-color: #85C1E9;} h2 {font-family:calibri;}</style></head>");
		htmlStringBuilder.append("<body>");
		htmlStringBuilder.append("<table align='center' border=\"1\" bordercolor=\"#000000\" style=\"width:100%\">");
		htmlStringBuilder.append(
				"<tr><th>TestCase Name</th><th>Invocation Number</th><th>Test Value</th><th>Expected Value" +
						"</th><th>Actual Output</th><th>Test Result</th</tr>");

		return htmlStringBuilder;
	}

	/**
	 * Passe execution info and add to the string
	 *
	 * @return htmlString
	 */
	private StringBuilder parseTestcaseList() {
		StringBuilder htmlStringBuilder = initializeHTMLString();

		for (TestcaseBO testcaseBO : testcaseList) {

			// create new row
			htmlStringBuilder.append("<tr>");

			// add data
			htmlStringBuilder.append("<td>" + testcaseBO.getTestcaseName() + "</td>");
			htmlStringBuilder.append("<td>" + testcaseBO.getInvocationNumber() + "</td>");
			htmlStringBuilder.append("<td>" + testcaseBO.getTestValue() + "</td>");
			htmlStringBuilder.append("<td>" + testcaseBO.getExpectedResult() + "</td>");
			htmlStringBuilder.append("<td>" + testcaseBO.getActualResult() + "</td>");

			if(testcaseBO.getExecutionStatus()== TestExecutionStatus.PASS)
				htmlStringBuilder.append("<td style=\"background-color:#66ffb3\">" + testcaseBO.getExecutionStatus() + "</td>");
			else
				htmlStringBuilder.append("<td style=\"background-color:#ff6666\">" + testcaseBO.getExecutionStatus() + "</td>");

			// end of row
			htmlStringBuilder.append("</tr>");
		}

		// complete html file string
		htmlStringBuilder.append("</table></body></html>");

		return htmlStringBuilder;
	}
}
