<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>READ LOG</name>
   <tag></tag>
   <elementGuidId>2ef549f7-0659-4968-b2b1-5974088e835c</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>https://scale.juniper.net/api/checkuser?file=${file}&amp;user=${user}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>'/volume/RBU_SNP_REG/Longevity_Storage/jsonToParam/preraks/preraks_sample_run_2/preraks_sample_run_2.params'</defaultValue>
      <description></description>
      <id>d9c9493f-efb9-4f98-b444-a0fa083980c3</id>
      <masked>false</masked>
      <name>file</name>
   </variables>
   <variables>
      <defaultValue>'preraks'</defaultValue>
      <description></description>
      <id>d7407ade-64e0-4b9a-b84b-4d99743b1688</id>
      <masked>false</masked>
      <name>user</name>
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
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
