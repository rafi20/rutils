package com.rtest.rutils.nifi;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import org.apache.nifi.attribute.expression.language.StandardPropertyValue;
import org.apache.nifi.components.PropertyDescriptor;

public class NifiExprTest {
	
	   private final static String dateFormat = "yyyy/MM/dd";
	   private final static String dateTimeFormat = "yyyy/MM/dd HH:mm:ss";
	   private final static String timeFormat = "HH:mm:ss";
		private static final String ERROR_FIELDS_DELIMITER = "\\";
	   
	public static final PropertyDescriptor ROUTE_STRATEGY = new PropertyDescriptor.Builder()
            .name("Routing Strategy")
            .description("Specifies how to determine which relationship to use when evaluating the Expression Language")
            .required(true)
            .defaultValue("A")
            .build();
	public static BiFunction<String, String, LocalDate> formatDate = (stringDate, dtFormat) -> {		
		return LocalDate.parse(stringDate,DateTimeFormatter.ofPattern(dtFormat));		
	};
	
	public static DateFormat getDateFormat(final String format, final String timezoneID) {
	     if (format == null || timezoneID == null) {
	         return null;
	     }
	     final DateFormat df = new SimpleDateFormat(format);
	     df.setTimeZone(TimeZone.getTimeZone(timezoneID));
	     return df;
	 }
	
	private static String getMessageString(Map<String, ?> primaryValuesFormated) {
		if (primaryValuesFormated == null || primaryValuesFormated.isEmpty()) return "X";
 		StringBuffer message = new StringBuffer("");
 		for(String key: primaryValuesFormated.keySet()) {
 			message.append(key);
 			message.append("=");
 			message.append(primaryValuesFormated.get(key));
 			message.append(ERROR_FIELDS_DELIMITER);
 		} 
 		String s = message.toString();
 		return s.substring(0, s.lastIndexOf(ERROR_FIELDS_DELIMITER));
 		//return (s.isBlank() ? "" : (s.substring(0, s.lastIndexOf("\\"))));
		/*
		 * StringBuffer message = new StringBuffer(""); String mapAsString =
		 * primaryValuesFormated.keySet().stream() .map(key ->
		 * message.append(key).append("=").append(primaryValuesFormated.get(key)).
		 * toString()) .collect(Collectors.joining(", ", "{", "}")); return mapAsString;
		 */
	}

		
	public static void main(String[] args) throws Exception {
		//test();
		espressionTest();
	}
	//"yyyy/MM/dd HH:mm:ss"
	private static void espressionTest() throws Exception {
		Map<String,Object> testMap2 = null;// new HashMap<String,Object>();
		Map<String,Object> testMap = new HashMap<String,Object>();
		//testMap.put("INT_FLD","34");
		//testMap.put("DATE_TIME_FLD","2020/08/12 01:01:01");
		//testMap.put("DATE_FLD","2020/08/12");
		//testMap.put("DATE_FLDx",null);
		System.out.println(getMessageString(testMap));
		System.out.println(testMap);
		
		System.out.println(TimeZone.getTimeZone("UTC").getID());
		long dl1 = getDateFormat(dateTimeFormat, TimeZone.getTimeZone("UTC").getID()).parse("2020/08/12 01:01:01").getTime();
		System.out.println(getDateFormat(dateTimeFormat, TimeZone.getTimeZone("CST6CDT").getID()).format(dl1));
		
		for(String key: testMap.keySet()) {
			System.out.println("XXXXXXXXXXXXX");
		}
		//System.out.println(getDateFormat(dateFormat, TimeZone.getDefault().getID()).format(primaryValuesFormated.get("A")));
		//System.out.println(getDateFormat(timeFormat, TimeZone.getDefault().getID()).format(primaryValuesFormated.get("A")));
		
		
		Date dt = new Date();		
		java.sql.Date dt2 = new java.sql.Date(dt.getTime());
		System.out.println(dt instanceof java.sql.Date);
		System.out.println(dt instanceof java.util.Date);
		System.out.println(dt2 instanceof java.sql.Date);
		System.out.println(dt2 instanceof java.util.Date);
		Map<String, Object> primaryValuesFormated = new HashMap<String, Object>();
		primaryValuesFormated.put("A", dt2);
		System.out.println(getDateFormat(dateTimeFormat, TimeZone.getDefault().getID()).format(primaryValuesFormated.get("A")));
		System.out.println(getDateFormat(dateFormat, TimeZone.getDefault().getID()).format(primaryValuesFormated.get("A")));
		System.out.println(getDateFormat(timeFormat, TimeZone.getDefault().getID()).format(primaryValuesFormated.get("A")));
		
		Time t1 = new Time(dt.getTime());		
		java.sql.Timestamp t2 = new java.sql.Timestamp(dt.getTime());
		
		primaryValuesFormated.put("A", t2);
		System.out.println(getDateFormat(dateTimeFormat, TimeZone.getDefault().getID()).format(primaryValuesFormated.get("A")));
		System.out.println(getDateFormat(dateFormat, TimeZone.getDefault().getID()).format(primaryValuesFormated.get("A")));
		System.out.println(getDateFormat(timeFormat, TimeZone.getDefault().getID()).format(primaryValuesFormated.get("A")));
		
		primaryValuesFormated.put("A", t1);
		System.out.println(getDateFormat(dateTimeFormat, TimeZone.getDefault().getID()).format(primaryValuesFormated.get("A")));
		System.out.println(getDateFormat(dateFormat, TimeZone.getDefault().getID()).format(primaryValuesFormated.get("A")));
		System.out.println(getDateFormat(timeFormat, TimeZone.getDefault().getID()).format(primaryValuesFormated.get("A")));
		
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
		
		flowfile.put("TDECIMAL", null);
		flowfile.put("TDOUBLE", null);
		
		flowfile.put("TSTRING", "ss");
		flowfile.put("TID", "11");
		flowfile.put("FIELD1", "A");
		flowfile.put("FIELD2", "");
		flowfile.put("FIELD3", "abc");
		flowfile.put("SID", "1500");
		/*
		 * Map<VariableDescriptor, String> variables = new
		 * HashMap<VariableDescriptor,String>(); variables.put(new
		 * VariableDescriptor("name"), "test");
		 */
		
		try {
			
			List<String> emptyList = new ArrayList<String>();
			emptyList.add(null);
			
			System.out.println(">> "+ emptyList.size());
			System.out.println(">> "+ emptyList.get(0));
			
			
			//LocalDateTime.parse("2020/03/03 10:04:02",DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
			//LocalDate.parse("10:04:02",DateTimeFormatter.ofPattern("yyyy/MM/dd"));
			//LocalTime.parse("2020/03/03",DateTimeFormatter.ofPattern("HH:mm:ss"));
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
			
			//StandardPropertyValue pv = new StandardPropertyValue("${literal(${TID:isEmpty():not():ifElse(${TSTRING:isEmpty():not()},'true')})}", null, null);//multiple, and
		   		 
	//		StandardPropertyValue pv = new StandardPropertyValue("${literal(${literal(${TDECIMAL:isEmpty():not():and(${TDOUBLE:isEmpty()})})}):or(${literal(${TDOUBLE:isEmpty():not():and(${TDECIMAL:isEmpty()})})})}", null, null);
			
			
			//StandardPropertyValue pv = new StandardPropertyValue("${literal(${literal(${TDECIMAL:isEmpty():not():and(${TDOUBLE:isEmpty()})})}):or(${literal(${TDOUBLE:isEmpty():not():and(${TDECIMAL:isEmpty()})})})}", null, null);
			//${literal(${literal(${TDECIMAL:isEmpty():not():and(${TDOUBLE:isEmpty()})})}):or(${literal(${TDOUBLE:isEmpty():not():and(${TDECIMAL:isEmpty()})})})})}
			//${literal(${literal(${TDECIMAL:isEmpty():not():and(${TDOUBLE:isEmpty()})})}):or(${literal(${TDOUBLE:isEmpty():not():and(${TDECIMAL:isEmpty()})})})}
			
			//StandardPropertyValue pv = new StandardPropertyValue("${literal(${TID:isEmpty():not():ifElse(${TSTRING:isEmpty():not()},'true')})}",null,null);
			//StandardPropertyValue pv = new StandardPropertyValue("${literal(${literal('true')})}",null,null);
			//StandardPropertyValue pv = new StandardPropertyValue("${literal(${FIELD3:equals('abc'):ifElse(${FIELD1:gt('184801')},'true')})}",null,null);

			//StandardPropertyValue pv = new StandardPropertyValue("${literal(${literal(${FIELD1:isEmpty():not():and(${FIELD2:isEmpty()}):and(${FIELD3:equals('abc')})})})}):or(${literal(${FIELD1:isEmpty():and(${FIELD2:isEmpty():not()}):and(${FIELD3:equals('abc'):not()})})})})}",null,null);
			//StandardPropertyValue pv = new StandardPropertyValue("${literal(${literal(${FIELD1:isEmpty():not():and(${FIELD2:isEmpty()}):and(${FIELD3:equals('abc')})})}):or(${literal(${FIELD1:isEmpty():and(${FIELD2:isEmpty():not()}):and(${FIELD3:equals('abc'):not()})})})}",null,null);
			
			//StandardPropertyValue pv = new StandardPropertyValue("${literal(${SID:ge('1000')}):and(${SID:le('5000')})}",null,null);
			
			//StandardPropertyValue pv = new StandardPropertyValue("${literal(${INT_FLD:gt('1000')}):and(${DATE_FLD:equals('18242')})}):and(${DATE_FLD:equals('18242')})}):and(${TIME_FLD:equals('36610000000000')})}):and(${TIMESTAMP_FLD:equals('1576125610')})}):and(${STRING_FLD:equals('RAFI MOHAMMED')})})}",null,null);
			
			//StandardPropertyValue pv = new StandardPropertyValue("${literal(${INT_FLD:gt('1000'):and(${DATE_FLD:equals('18242')}):and(${DATETIME_FLD:equals('1576125610')}):and(${TIME_FLD:equals('36610000000000')}):and(${TIMESTAMP_FLD:equals('1576125610')}):and(${STRING_FLD:equals('RAFI MOHAMMED')})})}",null,null);
			
			String exp   = "${literal(${INT_FLD_FC:equals('0'):ifElse(${INT_FLD:gt('1000')},'true'):and(${literal(${INT_FLD_FC:equals('0'):ifElse(${INT_FLD:gt('1000')},'true'):or(${DATE_FLD:equals('18242')}):or(${DATETIME_FLD:equals('1576125610')}):or(${TIME_FLD:equals('36610000000000')}):or(${TIMESTAMP_FLD:equals('1576125610')}):or(${STRING_FLD:equals('RAFI MOHAMMED')})})})})}";
			
			String exp0  = "${literal(${INT_FLD_FC:equals('0'):ifElse(${INT_FLD:gt('1000')},'true'):and(${literal(${INT_FLD:gt('1000'):or(${DATE_FLD:equals('18242')}):or(${DATETIME_FLD:equals('1576125610')}):or(${TIME_FLD:equals('36610000000000')}):or(${TIMESTAMP_FLD:equals('1576125610')}):or(${STRING_FLD:equals('RAFI MOHAMMED')})})})})}";
			String exp2  = "${literal(${INT_FLD_FC:equals('0'):ifElse(${INT_FLD:gt('1000')},'true')}))}"; //
			String exp3  = "${literal(${INT_FLD_FC:equals('0'):ifElse(${INT_FLD:gt('1000')},'true'):and(${literal(${INT_FLD:gt('1000'))})})}";
			String exp1 = "${literal(${INT_FLD_FC:equals('0'):ifElse(${INT_FLD:gt('1000')},'true')})}";
			
			
			String expc = "${literal()}";
					
			StandardPropertyValue pv = new StandardPropertyValue(exp,null,null);
		//extra }) before :or AND  )} at the end
			System.out.println(">> result "+pv.evaluateAttributeExpressions(flowfile).asBoolean()); //1,0 0,1
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
	
	
	
	
	
	
	private static void test() {
		
		String dbName = "rdm_data_vmware_oem";
		String tid1 = dbName.substring((dbName.lastIndexOf("_")+1));
		String tid2 = dbName.substring((dbName.lastIndexOf("rdm_data_") + "rdm_data_".length()));
		String tid3 = dbName.substring("rdm_data_".length());
		
		/*
		 * String tid2 = dbName.substring("rdm_data_".length()); String tid =
		 * dbName.substring((dbName.lastIndexOf("rdm_data_") + "rdm_data_".length()));
		 * String tid2 = dbName.substring("rdm_data_".length());
		 */
		//String tid = dbName.substring((dbName.lastIndexOf("_")+1));
		System.out.println("1>"+tid1);
		//System.out.println("dbName.lastIndexOf(\"rdm_data_\")"+dbName.lastIndexOf("rdm_data_"));
		//System.out.println(">"+dbName.lastIndexOf("rdm_data_"));
		System.out.println("2>"+tid2);
		System.out.println("3>"+tid3);
		//System.out.println(">"+"rdm_data_".length());
	}
}
