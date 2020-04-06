
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import com.kms.katalon.core.testobject.TestObject

import com.kms.katalon.core.model.FailureHandling

import java.lang.String


def static "com.katalon.plugin.keyword.calendar.SetDateCalendarKeyword.setDate"(
    	TestObject to	
     , 	int day	
     , 	int month	
     , 	int year	
     , 	int slideTimeOut	
     , 	FailureHandling flowControl	) {
    (new com.katalon.plugin.keyword.calendar.SetDateCalendarKeyword()).setDate(
        	to
         , 	day
         , 	month
         , 	year
         , 	slideTimeOut
         , 	flowControl)
}

def static "custom.WriteExcel.enterValues"(
    	String value	
     , 	String fileName	
     , 	String sheetName	) {
    (new custom.WriteExcel()).enterValues(
        	value
         , 	fileName
         , 	sheetName)
}

def static "custom.WriteExcel.readValues"(
    	String fileName	
     , 	String sheetName	
     , 	String[] values	) {
    (new custom.WriteExcel()).readValues(
        	fileName
         , 	sheetName
         , 	values)
}

def static "custom.WriteExcel.clearValues"(
    	String fileName	
     , 	String sheetName	) {
    (new custom.WriteExcel()).clearValues(
        	fileName
         , 	sheetName)
}

def static "custom.WriteExcel.waitForObject"(
    	int timeOut	
     , 	String object	
     , 	String clickObj	) {
    (new custom.WriteExcel()).waitForObject(
        	timeOut
         , 	object
         , 	clickObj)
}
