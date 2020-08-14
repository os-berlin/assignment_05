package com.coderscampus.salesreport;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileService {

	public List<TeslaSales> readCSV (String file){
		List<TeslaSales> teslaSales = new ArrayList<>();
		try (BufferedReader csvReader = new BufferedReader(new FileReader(file));) {
			String skipFirstLine = csvReader.readLine();
			String line;
			while ((line = csvReader.readLine()) != null) {
				String[] data = line.split(",");
				teslaSales.add(new TeslaSales(data[0], data[1]));
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return teslaSales;
	}
}
