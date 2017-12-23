import java.util.Set;
import model.ReportInput;
import services.GenerateReportImpl;
import services.IGenerateReport;
import utils.ReportInputGenerator;

/**
 * 
 */

/**
 * @author Priya Balan
 *
 */
public class ReportMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// generate dummy inputs
		Set<ReportInput> reportInput = new ReportInputGenerator().generateInputs();

		// method call to generate Trade amount reports an ranking reports
		IGenerateReport generateReport = new GenerateReportImpl();
		generateReport.generateReports(reportInput);

	}
}