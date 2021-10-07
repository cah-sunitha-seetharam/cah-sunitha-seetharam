<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Login Request API</name>
   <tag></tag>
   <elementGuidId>9d3537bd-8b1d-46a0-9641-ee614080ec59</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>true</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Length</name>
      <type>Main</type>
      <value>0</value>
   </httpHeaderProperties>
   <katalonVersion>8.1.0</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${login-api-host}/forms/RWO/OEDMZLogin.fcc?smauthreason=0&amp;target=${target}/eps/mycah&amp;SMENC=ISO-8859-1&amp;PASSWORD=${password}&amp;smagentname=${smagentname}&amp;postpreservationdata=&amp;smquerydata=&amp;SMLOCALE=US-EN&amp;REMEMBER=on&amp;USER=${user}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>GlobalVariable.loginApiHost</defaultValue>
      <description></description>
      <id>a3373c80-d258-4f53-8f1d-1ed9627023cb</id>
      <masked>false</masked>
      <name>login-api-host</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.target</defaultValue>
      <description></description>
      <id>b42eda69-bb8e-480c-8659-2642a4dd5407</id>
      <masked>false</masked>
      <name>target</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.password</defaultValue>
      <description></description>
      <id>cf344147-395e-40e7-9415-70da5564c5f8</id>
      <masked>false</masked>
      <name>password</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.smagentname</defaultValue>
      <description></description>
      <id>8be254d9-7be3-47a5-97c1-1f31be49fc14</id>
      <masked>false</masked>
      <name>smagentname</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Username</defaultValue>
      <description></description>
      <id>37db0106-3797-41d5-b6a3-5e86b2c8238f</id>
      <masked>false</masked>
      <name>user</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebDriver
import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable



println &quot;Sameple&quot;
RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
println response.getProperties()</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
