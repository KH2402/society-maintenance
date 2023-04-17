package com.example.demo;
import java.io.File;	
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ExcelParserController {
	                                             	   
                                                    	   
    // @GetMapping("/parseFile")                                            
    // public ResponseEntity<List<FlatOwner>> parseExcel(){
     
     @PostMapping("/parseExcel")
     public ResponseEntity<List<FlatOwner>> parseExcel(@RequestParam("file") MultipartFile file,
    		                                            @RequestParam("searchString") String searchString) {
    
        try {
        	//File file=new File("/C:\\Users\\krish\\OneDrive\\Desktop\\parser.xlsx");
            //FileInputStream fis = new FileInputStream(file);
        	//Workbook workbook = new XSSFWorkbook(fis);
        	InputStream inputStream = file.getInputStream();
        	Workbook workbook = new XSSFWorkbook(inputStream);
    
            Sheet sheet = workbook.getSheetAt(0); // Assuming the data is in the first sheet

            List<FlatOwner> flatOwners = new ArrayList<>();

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            	
                Row row = sheet.getRow(i);
                String wing=row.getCell(0).getStringCellValue();
                String flatNumber = row.getCell(1).getStringCellValue();
                String ownerName = row.getCell(2).getStringCellValue();
                String mobileNumber = row.getCell(3).getStringCellValue();
                String whatsappNumber = row.getCell(4).getStringCellValue();
                String emailId = row.getCell(5).getStringCellValue();

                FlatOwner flatOwner = new FlatOwner(wing,flatNumber, ownerName, mobileNumber, whatsappNumber, emailId);
                flatOwners.add(flatOwner);
               
            }

            workbook.close();
            
            // Filter the list based on search string
            List<FlatOwner> filteredFlatOwners = new ArrayList<>();
            for (FlatOwner flatOwner : flatOwners) {
                if (flatOwner.getFlatNumber().contains(searchString) || flatOwner.getOwnerName().contains(searchString) ||
                        flatOwner.getMobileNumber().contains(searchString) || flatOwner.getWhatsappNumber().contains(searchString) ||
                        flatOwner.getEmailId().contains(searchString)) {
                    filteredFlatOwners.add(flatOwner);
                }
            }
            
            return new ResponseEntity<>(filteredFlatOwners, HttpStatus.OK);
            
            //return new ResponseEntity<>(flatOwners, HttpStatus.OK);
        } catch (IOException e) {
        	 e.printStackTrace();
             return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
         }
    }
     
    
}
