<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Carts API - POST</name>
   <tag></tag>
   <elementGuidId>3589fd85-838f-4c9a-aea4-d6b2d5ad568c</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;[\n    {\n        \&quot;sourceId\&quot;: \&quot;MobileApp\&quot;,\n        \&quot;distributionCenter\&quot;: \&quot;${distributionCenter}\&quot;,\n        \&quot;customerNumber\&quot;: \&quot;${customerNumber}\&quot;,\n        \&quot;purchaseOrderNumber\&quot;: \&quot;${purchaseOrderNumber}\&quot;,\n        \&quot;purchaseOrderMemo\&quot;: \&quot;automationCreation\&quot;,\n        \&quot;autoSubmit\&quot;: \&quot;Y\&quot;,\n        \&quot;cartLines\&quot;: [\n            {\n                \&quot;cin\&quot;: \&quot;${cin1}\&quot;,\n                \&quot;quantity\&quot;: \&quot;${qty1}\&quot;\n            }\n        ]\n    }\n]&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>x-api-key</name>
      <type>Main</type>
      <value>${x-api-key}</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>${Authorization}</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>user</name>
      <type>Main</type>
      <value>${user}</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>UUID</name>
      <type>Main</type>
      <value>${UUID}</value>
   </httpHeaderProperties>
   <katalonVersion>8.1.0</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${carts-api-host}/${env}/pd/ecom/v1/carts</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>b52db3e6-420b-43c4-94e3-04db41e64d2c</id>
      <masked>false</masked>
      <name>carts-api-host</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>2de62544-e9ac-43e7-8b91-4b30bb882f31</id>
      <masked>false</masked>
      <name>env</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>9f54c2e4-2f5b-4665-bd7e-9b42052b8db8</id>
      <masked>false</masked>
      <name>x-api-key</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.accessToken</defaultValue>
      <description></description>
      <id>f5dbcc85-d872-4b36-832d-77606941cc7e</id>
      <masked>false</masked>
      <name>Authorization</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>527c1923-f4d9-4795-b071-e84b7cb5da7f</id>
      <masked>false</masked>
      <name>UUID</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>420c4eb3-d83a-4777-915d-13a814416294</id>
      <masked>false</masked>
      <name>distributionCenter</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>4f38da0b-bf89-4c9f-b41b-d88d1320de9e</id>
      <masked>false</masked>
      <name>customerNumber</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>7fda1df4-997b-4e2f-a94f-5ccfb10c632f</id>
      <masked>false</masked>
      <name>purchaseOrderNumber</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>9e58a184-d976-414f-9bc5-20bb18ffa5a2</id>
      <masked>false</masked>
      <name>cin1</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>7312b0e7-30db-4f23-811e-730e7fc5722a</id>
      <masked>false</masked>
      <name>qty1</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
WS.verifyResponseStatusCode(response, 200)</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
