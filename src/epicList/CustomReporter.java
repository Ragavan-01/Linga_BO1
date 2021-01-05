package epicList;

import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

public class CustomReporter implements IReporter{

    @Override

    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,String outputDirectory) {
        // Second parameter of this method ISuite will contain all the suite executed.
    	//Iterating over each suite included in the test
        for (ISuite iSuite : suites) {
        	//Following the code gets suite name
        	String suiteName = iSuite.getName();
            //Get a map of result of a single suite at a time
            Map<String,ISuiteResult> results =    iSuite.getResults();
        //Go to each map value one by one
            for (ISuiteResult sr : results.values()) {
             //The Context object of current result
            ITestContext tc = sr.getTestContext();
            System.out.println("Passed tests for suite '"+ suiteName + "' is:" + tc.getPassedTests().getAllMethods().size());
            System.out.println("Failed tests for suite '"+ suiteName + "' is:" + tc.getFailedTests().getAllMethods().size());
            System.out.println("Skipped tests for suite '"+ suiteName + "' is:" + tc.getSkippedTests().getAllMethods().size());
            }
}
}
}