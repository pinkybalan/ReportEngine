package services;

import java.util.Set;

import model.ReportInput;

/**
 * @author Priya Balan
 *
 */
public interface IGenerateReport {
	void generateReports(Set<ReportInput> reportInputs);
}
