<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>FUSION SUBMIT</name>
   <tag></tag>
   <elementGuidId>b24e361c-b244-4e48-bef9-e13f6a2eebd8</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>https://scale.juniper.net/api/longevityfusionsubmit?topology_id=${topology_id}&amp;user=${user}&amp;longevity_submission_id=${longevity_submission_id}&amp;fusion_submission_name=${fusion_submission_name}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>8759a8dd-bc20-44db-a230-af1892cd85fb</id>
      <masked>false</masked>
      <name>topology_id</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>d9c9493f-efb9-4f98-b444-a0fa083980c3</id>
      <masked>false</masked>
      <name>user</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>25333ead-e23b-412b-bd79-39c0c65fe07e</id>
      <masked>false</masked>
      <name>longevity_submission_id</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>377d7854-f39f-4fde-869c-c9c27c71c164</id>
      <masked>false</masked>
      <name>fusion_submission_name</name>
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
