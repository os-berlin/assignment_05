package com.coderscampus.salesreport;


import java.time.YearMonth;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TeslaSalesService {
	
	public void SalesReport (List<TeslaSales> inputList, String model) {
		System.out.println(model + " Yearly Sales Report \n---------------------------");
		

//old code		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//		Set<Integer> years = inputList.stream()
//									  .map(TeslaSales -> TeslaSales.getDate().getYear())
//									  .collect(Collectors.toSet());	
//		
//		// I couldn't get my head around doing this with just streams.. so here we are with some ugly for loops :)
//		Integer totalSales = 0;
//		for (Integer year : years) {
//			for (TeslaSales sales : inputList) {
//				 if (sales.getDate().getYear() == year) {
//					 totalSales += sales.getSales();
//				 }
//			 }
//			System.out.println(year + " -> " + totalSales);
//			totalSales = 0;
//		}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		// yearly sales
		Map<Integer, List<TeslaSales>> yearlySales = inputList.stream()
															  .collect(Collectors.groupingBy(x -> x.getDate().getYear()));
		
		String totalSales = yearlySales.entrySet().stream()
											      .map(y -> y.getKey() + ": " + y.getValue().stream()
											    		  									.collect(Collectors.summingInt(TeslaSales -> TeslaSales.getSales())))
											      .collect(Collectors.joining("\n"));			
	
		System.out.println(totalSales + "\n");
		
//old code		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//IntSummaryStatistics minMaxSales = inputList.stream()
//.map(TeslaSales -> TeslaSales.getSales())
//.mapToInt(x -> x.intValue())
//.summaryStatistics();
//
////again, linking the result of the stream above and the actual date wouldn't make sense to me in terms of streams..
//for (TeslaSales bestWorstMonth : inputList) {
//if (minMaxSales.getMax() == bestWorstMonth.getSales()) {
//System.out.println("\nThe best month for " + model + " was: " + bestWorstMonth.getDate());
//}
//
//}
//
//boolean duplicate = false;
//for (TeslaSales bestWorstMonth : inputList) {
//if (minMaxSales.getMin() == bestWorstMonth.getSales() && duplicate == false) {
//System.out.println("The worst month for " + model + " was: " + bestWorstMonth.getDate() + "\n");
//duplicate = true;				
//}
//
//}		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		// best/worst month
		IntSummaryStatistics minMaxSales = inputList.stream()
													.map(TeslaSales -> TeslaSales.getSales())
													.mapToInt(x -> x.intValue())
													.summaryStatistics();
		
		List<YearMonth> bestMonth = inputList.stream()
								.filter(z -> z.getSales() == minMaxSales.getMax())
								.map(TeslaSales -> TeslaSales.getDate())
								.collect(Collectors.toList());
		
		List<YearMonth> worstMonth = inputList.stream()
											 .filter(z -> z.getSales() == minMaxSales.getMin())
											 .map(TeslaSales -> TeslaSales.getDate())
											 .collect(Collectors.toList());
		
		System.out.println("The best month for " + model + " was: " + bestMonth.get(0));
		System.out.println("The worst month for " + model + " was: " + worstMonth.get(0) + "\n");

		
	}

}
