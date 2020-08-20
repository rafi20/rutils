package com.rtest.rutils.nifi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

import org.apache.nifi.attribute.expression.language.StandardPropertyValue;

public class NifiExprTest2 {
	public static BiFunction<String, String, LocalDate> formatDate = (stringDate, dtFormat) -> {		
		return LocalDate.parse(stringDate,DateTimeFormatter.ofPattern(dtFormat));		
	};
		
	public static void main(String[] args) {
		espressionTest();
	}
	//"yyyy/MM/dd HH:mm:ss"
	private static void espressionTest() {
		//Initialize the map with values for the attributes defined expression
		Map<String, String> flowfile = new HashMap<String,String>();
		flowfile.put("aKey1", "2020/03/03 06:06:06");
		flowfile.put("aKey2", "2020/04/04 06:06:06");
		flowfile.put("aKey3", "aValue3");
		flowfile.put("aKey4", "100");
		flowfile.put("aKey5", "$ 400");
		flowfile.put("aKey6", "$ 400");
		flowfile.put("aKey7", "400");
		flowfile.put("aKey9", "10.444");
		flowfile.put("aKey10", "10.445");
		flowfile.put("TDECIMAL", "10.5");
		flowfile.put("TDOUBLE", "10.4");
		flowfile.put("TSTRING", "ss");
		flowfile.put("TID", "11");
			
		try {
			//Add the expression to StandardPropertyValue and evaluate
						
			
			//LocalDateTime.parse("2020/03/03 10:04:02",DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
			//LocalDate.parse("10:04:02",DateTimeFormatter.ofPattern("yyyy/MM/dd"));
			//LocalTime.parse("2020/03/03",DateTimeFormatter.ofPattern("HH:mm:ss"));
			/*
			LocalDateTime ldt = LocalDateTime.parse("2020/03/03 10:04:02",DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
			System.out.println("ldt> "+ldt);
			Long millis = ldt.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
			System.out.println(">> "+ millis);
			
			Instant ints = Instant.ofEpochMilli(millis);
			System.out.println("ints>> "+ ints);
			
			LocalDateTime nldt =  LocalDateTime.ofInstant(ints,ZoneId.systemDefault());
			System.out.println("nldt>>"+ nldt);
			System.out.println("<<"+nldt.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));
			
			System.out.println(">>");
			String dtStrValue1 = String.valueOf(LocalDate.parse("2020/03/03",DateTimeFormatter.ofPattern("yyyy/MM/dd")).toEpochDay());
			String dtStrValue2 = String.valueOf(LocalDate.parse("2020/04/04",DateTimeFormatter.ofPattern("yyyy/MM/dd")).toEpochDay());
			flowfile.put("aKey8", dtStrValue1);
			
			*/
			//StandardPropertyValue pv = new StandardPropertyValue("${aKey8:lt("+dtStrValue2+")}", null, null);//toDate function
			//StandardPropertyValue pv = new StandardPropertyValue("${aKey1:equalsIgnoreCase('aValue1'):and(${aKey2:equalsIgnoreCase('aValue2')})}", null, null);
			//StandardPropertyValue pv = new StandardPropertyValue("${literal('200'):gt(10)}", null, null);
			//StandardPropertyValue pv = new StandardPropertyValue("${aKey1:toDate('yyyy/MM/dd HH:mm:ss'):lt(${aKey2:toDate('yyyy/MM/dd HH:mm:ss')})}", null, null);//toDate function
			//StandardPropertyValue pv = new StandardPropertyValue("${aKey1:toDate('yyyy/MM/dd HH:mm:ss'):lt(${aKey2:toDate('yyyy/MM/dd HH:mm:ss')})}", null, null);//toDate function
			//StandardPropertyValue pv = new StandardPropertyValue("${literal("+dtStrValue1+"):lt("+dtStrValue2+")}", null, null);//toDate function			
			//StandardPropertyValue pv = new StandardPropertyValue("${aKey1:lt(literal('2020/04/04 06:06:06'):todate('yyyy/MM/dd HH:mm:ss'))}", null, null);//without toDate function
			//StandardPropertyValue pv = new StandardPropertyValue("${aKey1:lt('2020/04/04 06:06:06')}", null, null);//without toDate function
			//StandardPropertyValue pv = new StandardPropertyValue("${aKey1:lt(${aKey2})}", null, null);//invalid
			//StandardPropertyValue pv = new StandardPropertyValue("${aKey5:equals(${aKey6})}", null, null);
			//StandardPropertyValue pv = new StandardPropertyValue("${literal('400'):gt(20)}", null, null);//without flowfile lookup
			//StandardPropertyValue pv = new StandardPropertyValue("${aKey7:gt(20)}", null, null);//with flowfile lookup
			
			//StandardPropertyValue pv = new StandardPropertyValue("${aKey9:lt(${aKey10})}", null, null);//with flowfile lookup
			//StandardPropertyValue pv = new StandardPropertyValue("${aKey9:lt('10.448')}", null, null);//with flowfile lookup
			
			
			//StandardPropertyValue pv = new StandardPropertyValue("${literal(${literal(${TDECIMAL:isEmpty():not():and(${TDOUBLE:isEmpty()})})}):and(${literal(${TDOUBLE:isEmpty():not():and(${TDECIMAL:isEmpty()})})})}", null, null);//multiple, and
			
			//StandardPropertyValue pv = new StandardPropertyValue("${literal(${literal(${TDECIMAL:isEmpty():not():and(${TDOUBLE:isEmpty()})})}):or(${literal(${TDOUBLE:isEmpty():not():and(${TDECIMAL:isEmpty()})})})})}", null, null);//multiple, and
			
			StandardPropertyValue pv = new StandardPropertyValue("${literal(${TID:isEmpty():not():ifElse(${TSTRING:isEmpty():not()},'true')})}", null, null);//multiple, and		   		 
			System.out.println(">> result "+pv.evaluateAttributeExpressions(flowfile).getValue()); //1,0 0,1
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
/*	
	"${literal("
		+ "${literal("
				+ "${TDECIMAL:isEmpty():not()"
					+ ":and("
						+ "${TDOUBLE:isEmpty()}"
					+ ")"
				+ "}"
			+ ")"
		+ "}"
	+ ")"
	+ ":or("
		+ "${literal("
				+ "${TDOUBLE:isEmpty():not()"
					+ ":and("
						+ "${TDECIMAL:isEmpty()}"
					+ ")"
			  	+"}"
			+ ")"
		+ "}"
	+ ")"
+ "}"
+ ")"
+ "}
*/	
	//${aKey1:equalsIgnoreCase('aValue1'):and(${aKey2:equalsIgnoreCase('aValue3')})}	
}
