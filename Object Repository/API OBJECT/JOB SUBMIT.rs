<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>JOB SUBMIT</name>
   <tag></tag>
   <elementGuidId>3d978f6b-b687-46bf-8d72-17a9eb3e4d6e</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>https://scale.juniper.net/api/longevitysubmission?topology_id=${topology_id}&amp;user=${user}&amp;longevity_submission_id=${longevity_submission_id}&amp;fusion_submission_name=${fusion_submission_name}&amp;domain=${domain}&amp;type=${type}&amp;test_indices=${test_indices}</restUrl>
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
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>6fbc9fb7-22d1-40ab-af44-b25050c0219c</id>
      <masked>false</masked>
      <name>domain</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>17e25335-d72e-45fd-bf82-a0546355711d</id>
      <masked>false</masked>
      <name>type</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>f2e7c223-cd12-4061-bd5d-79281088ec3d</id>
      <masked>false</masked>
      <name>test_indices</name>
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
