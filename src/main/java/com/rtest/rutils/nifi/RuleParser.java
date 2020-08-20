package com.rtest.rutils.nifi;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RuleParser {
public static void main(String[] args) throws IOException {
		
		//read json file data to String
		//byte[] jsonData = Files.readAllBytes(Paths.get("c:\\tmp\\validation_v3.txt"));
		String jsonData = getJsonString();
		//create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();
		
		//convert json string to object
		RulesWrapper dfn = objectMapper.readValue(jsonData, RulesWrapper.class);
		
		System.out.println("Rule Object\n"+dfn.getRules().get(0).getMessage());
		System.out.println("Rule Object>Group\n"+dfn.getRules().get(0).getCondition().getGroupOperator());
		System.out.println("Rule Object>LHS\n"+dfn.getRules().get(0).getCondition().getConditions().get(0).getParameters().getLhsParam());
		System.out.println("Rule Object>Operator\n"+dfn.getRules().get(0).getCondition().getConditions().get(0).getParameters().getOperatorParam());
		System.out.println("Rule Object>RHS\n"+dfn.getRules().get(0).getCondition().getConditions().get(0).getParameters().getRhsParam());
	}

	private static String getJsonString() {
		return "{\r\n" + 
				"	\"rules\": \r\n" + 
				"	[\r\n" + 
				"		{\r\n" + 
				"			\"message\": \"R1: v1: sku code ${sku code} is isEmpty, v2: sku id ${sku id} < 400\",\r\n" + 
				"			\"condition\":\r\n" + 
				"			{				 \r\n" + 
				"				\"isGroup\":\"true\",				\r\n" + 
				"				\"groupOperator\" : \"AND\",\r\n" + 
				"				\"hasFilterCondition\": false,\r\n" + 
				"				\"parameters\": null,\r\n" + 
				"				\"conditions\":\r\n" + 
				"				[\r\n" + 
				"					{\r\n" + 
				"						\"isGroup\":\"false\",\r\n" + 
				"						\"groupOperator\" : null,						\r\n" + 
				"						\"hasFilterCondition\": false,\r\n" + 
				"						\"conditions\": null,\r\n" + 
				"						\"parameters\": \r\n" + 
				"						{\r\n" + 
				"							\"lhsParam\": \"sku_code1\",\r\n" + 
				"							\"operatorParam\":\"isNotEmpty\",\r\n" + 
				"							\"compareWithParam\": null,\r\n" + 
				"							\"compareWithMasterParam\":null,\r\n" + 
				"							\"rhsParam\": null,			\r\n" + 
				"							\"actionParam\":\"VALIDATE\",\r\n" + 
				"							\"enrichCompareWithParam\":null,\r\n" + 
				"							\"enrichFromMasterParam\":null,\r\n" + 
				"							\"enrichLHSParam\":null,\r\n" + 
				"							\"enrichRHSParam\":null\r\n" + 
				"						},\r\n" + 
				"						\"filterParameters\": null\r\n" + 
				"					},\r\n" + 
				"					{\r\n" + 
				"						\"isGroup\":\"false\",\r\n" + 
				"						\"groupOperator\":null,												\r\n" + 
				"						\"hasFilterCondition\": true,\r\n" + 
				"						\"conditions\": null,\r\n" + 
				"						\"parameters\": \r\n" + 
				"						{\r\n" + 
				"							\"lhsParam\":\"sku_code2\",\r\n" + 
				"							\"operatorParam\":\"isNotEmpty\",\r\n" + 
				"							\"compareWithParam\": null,\r\n" + 
				"							\"compareWithMasterParam\":null,\r\n" + 
				"							\"rhsParam\": null,			\r\n" + 
				"							\"actionParam\":\"VALIDATE\",\r\n" + 
				"							\"enrichCompareWithParam\":null,\r\n" + 
				"							\"enrichFromMasterParam\":null,\r\n" + 
				"							\"enrichLHSParam\":null,\r\n" + 
				"							\"enrichRHSParam\":null\r\n" + 
				"						},\r\n" + 
				"						\"filterParameters\":\r\n" + 
				"						{\r\n" + 
				"							\"filterLHSParam\":\"sku_code3\",\r\n" + 
				"							\"filterOperatorParam\":\"Greater Than\",\r\n" + 
				"							\"filterCompareWithParam\":\"INPUT_RECORD\",\r\n" + 
				"							\"filterRHSParam\":\"sku_id3\"\r\n" + 
				"						}						\r\n" + 
				"					},\r\n" + 
				"					{\r\n" + 
				"						\"isGroup\":\"false\",\r\n" + 
				"						\"groupOperator\" : null,												\r\n" + 
				"						\"hasFilterCondition\": false,\r\n" + 
				"						\"conditions\": null,\r\n" + 
				"						\"parameters\": \r\n" + 
				"						{\r\n" + 
				"							\"lhsParam\": \"sku_code4\",\r\n" + 
				"							\"operatorParam\": \"Greater Than\",\r\n" + 
				"							\"compareWithParam\":\"PROVIDE_VALUE\",\r\n" + 
				"							\"compareWithMasterParam\":null,\r\n" + 
				"							\"rhsParam\":\"400\",			\r\n" + 
				"							\"actionParam\":\"VALIDATE\",\r\n" + 
				"							\"enrichCompareWithParam\":null,\r\n" + 
				"							\"enrichFromMasterParam\":null,\r\n" + 
				"							\"enrichLHSParam\":null,\r\n" + 
				"							\"enrichRHSParam\":null\r\n" + 
				"						},\r\n" + 
				"						\"filterParameters\": null\r\n" + 
				"					},\r\n" + 
				"					{						\r\n" + 
				"						\"isGroup\":\"false\",\r\n" + 
				"						\"groupOperator\" : null,						\r\n" + 
				"						\"hasFilterCondition\": false,\r\n" + 
				"						\"conditions\": null,\r\n" + 
				"						\"parameters\": \r\n" + 
				"						{\r\n" + 
				"							\"lhsParam\":\"sku_code5\",\r\n" + 
				"							\"operatorParam\":\"Greater Than\",\r\n" + 
				"							\"compareWithParam\":\"INPUT_RECORD\",\r\n" + 
				"							\"compareWithMasterParam\":null,\r\n" + 
				"							\"rhsParam\":\"sku_id5\",				\r\n" + 
				"							\"actionParam\":\"VALIDATE\",\r\n" + 
				"							\"enrichCompareWithParam\":null,\r\n" + 
				"							\"enrichFromMasterParam\":null,\r\n" + 
				"							\"enrichLHSParam\":null,\r\n" + 
				"							\"enrichRHSParam\":null							\r\n" + 
				"						},\r\n" + 
				"						\"filterParameters\": null						\r\n" + 
				"					},\r\n" + 
				"					{						\r\n" + 
				"						\"isGroup\":\"false\",\r\n" + 
				"						\"groupOperator\" : null,		\r\n" + 
				"						\"hasFilterCondition\": false,\r\n" + 
				"						\"conditions\": null,\r\n" + 
				"						\"parameters\": \r\n" + 
				"						{\r\n" + 
				"							\"lhsParam\":\"sku_code6\",\r\n" + 
				"							\"operatorParam\":\"Greater Than\",\r\n" + 
				"							\"compareWithParam\":\"OTHER_MASTER\",\r\n" + 
				"							\"compareWithMasterParam\":\"1000200\",\r\n" + 
				"							\"rhsParam\":\"sku_id6\",\r\n" + 
				"							\"actionParam\":\"VALIDATE\",							\r\n" + 
				"							\"enrichCompareWithParam\":null,\r\n" + 
				"							\"enrichFromMasterParam\":null,\r\n" + 
				"							\"enrichLHSParam\":null,\r\n" + 
				"							\"enrichRHSParam\":null\r\n" + 
				"						},\r\n" + 
				"						\"filterParameters\": null						\r\n" + 
				"					},\r\n" + 
				"					{						\r\n" + 
				"						\"isGroup\":\"false\",\r\n" + 
				"						\"groupOperator\" : null,						\r\n" + 
				"						\"hasFilterCondition\": false,\r\n" + 
				"						\"conditions\": null,\r\n" + 
				"						\"parameters\": \r\n" + 
				"						{\r\n" + 
				"							\"lhsParam\":\"sku_code7\",\r\n" + 
				"							\"operatorParam\":\"Greater Than\",\r\n" + 
				"							\"compareWithParam\":\"OTHER_MASTER\",\r\n" + 
				"							\"compareWithMasterParam\":\"1000200\",\r\n" + 
				"							\"rhsParam\":\"sku_id7\",\r\n" + 
				"							\"actionParam\":\"ENRICH\",\r\n" + 
				"							\"enrichCompareWithParam\":\"OTHER_MASTER\",\r\n" + 
				"							\"enrichFromMasterParam\":\"1000400\",\r\n" + 
				"							\"enrichLHSParam\":\"enrich_sku_id7\",\r\n" + 
				"							\"enrichRHSParam\":\"enrich_TO_sku_id7\"\r\n" + 
				"						},\r\n" + 
				"						\"filterParameters\": null						\r\n" + 
				"					},\r\n" + 
				"					{						\r\n" + 
				"						\"isGroup\":\"false\",\r\n" + 
				"						\"groupOperator\" : null,						\r\n" + 
				"						\"hasFilterCondition\": true,\r\n" + 
				"						\"conditions\": null,\r\n" + 
				"						\"parameters\": \r\n" + 
				"						{\r\n" + 
				"							\"lhsParam\":\"sku_code8\",\r\n" + 
				"							\"operatorParam\":\"Greater Than\",\r\n" + 
				"							\"compareWithParam\":\"OTHER_MASTER\",\r\n" + 
				"							\"compareWithMasterParam\":\"1000200\",\r\n" + 
				"							\"rhsParam\":\"sku_id8\",\r\n" + 
				"							\"actionParam\":\"ENRICH\",\r\n" + 
				"							\"enrichCompareWithParam\":\"OTHER_MASTER\",\r\n" + 
				"							\"enrichFromMasterParam\":\"1000400\",\r\n" + 
				"							\"enrichLHSParam\":\"enrich_sku_id8\",\r\n" + 
				"							\"enrichRHSParam\":\"enrich_TO_sku_id7\"\r\n" + 
				"						},\r\n" + 
				"						\"filterParameters\": \r\n" + 
				"						{\r\n" + 
				"							\"filterLHSParam\":\"sku_code8\",\r\n" + 
				"							\"filterOperatorParam\":\"Greater Than\",\r\n" + 
				"							\"filterCompareWithParam\":\"INPUT_RECORD\",\r\n" + 
				"							\"filterRHSParam\":\"sku_id8\"						\r\n" + 
				"						}\r\n" + 
				"					}\r\n" + 
				"				]\r\n" + 
				"			}\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"message\": \"R2: v1: sku code ${sku code} is isEmpty, v2: sku id ${sku id} < 400\",\r\n" + 
				"			\"condition\":\r\n" + 
				"			{\r\n" + 
				"				\r\n" + 
				"				\"isGroup\":\"true\",		\r\n" + 
				"				\"groupOperator\" : \"AND\",\r\n" + 
				"				\"hasFilterCondition\": false,\r\n" + 
				"				\"parameters\": null,\r\n" + 
				"				\"conditions\": null			 \r\n" + 
				"			}\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"message\": \"R3: v1: sku code ${sku code} is isEmpty, v2: sku id ${sku id} < 400\",\r\n" + 
				"			\"condition\":\r\n" + 
				"			{\r\n" + 
				"				\"parameters\": null,\r\n" + 
				"				\"isGroup\":\"true\",\r\n" + 
				"				\"hasFilterCondition\": false,\r\n" + 
				"				\"groupOperator\" : \"AND\",\r\n" + 
				"				\"conditions\": null\r\n" + 
				"			}\r\n" + 
				"		}\r\n" + 
				"	]\r\n" + 
				"}";
	}
				
}
