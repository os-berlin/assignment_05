package com.coderscampus.salesreport;

import java.util.List;

public class SalesReportApplication {

	public static void main(String[] args) {
		
		FileService fileService = new FileService();
		
		List<TeslaSales> model3Sales = fileService.readCSV("model3.csv");
		List<TeslaSales> modelSSales = fileService.readCSV("modelS.csv");
		List<TeslaSales> modelXSales = fileService.readCSV("modelX.csv");
		
		TeslaSalesService salesService = new TeslaSalesService();
		
		salesService.SalesReport(model3Sales, "Model 3");
		salesService.SalesReport(modelSSales, "Model S");	
		salesService.SalesReport(modelXSales, "Model X");
	
	}

}
