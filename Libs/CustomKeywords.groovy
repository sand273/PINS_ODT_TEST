
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String

import com.kms.katalon.core.testobject.TestObject


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
     , 	TestObject object	
     , 	TestObject clickObj	) {
    (new custom.WriteExcel()).waitForObject(
        	timeOut
         , 	object
         , 	clickObj)
}
