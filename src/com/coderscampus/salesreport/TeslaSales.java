package com.coderscampus.salesreport;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class TeslaSales {

	private YearMonth date;
	private Integer sales;
	
	public TeslaSales(String date, String sales) {
		this.date = YearMonth.parse(date, DateTimeFormatter.ofPattern("MMM-yy"));
		this.sales = Integer.valueOf(sales);
	}

	public YearMonth getDate() {
		return date;
	}
	public void setDate(YearMonth date) {
		this.date = date;
	}
	public Integer getSales() {
		return sales;
	}
	public void setSales(Integer sales) {
		this.sales = sales;
	}
	
	
}
