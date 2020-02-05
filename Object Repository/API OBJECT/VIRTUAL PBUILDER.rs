<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>VIRTUAL PBUILDER</name>
   <tag></tag>
   <elementGuidId>1d526001-d17b-4940-ab7a-236e5c5830e8</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>https://scale.juniper.net/api/virtualpbuilder?params_path=${params_path}&amp;domain=${domain}&amp;topology_id=${topology_id}&amp;user=${user}&amp;longevity_submission_id=${longevity_submission_id}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>0121dbbe-c473-4a2f-86d2-af4e4c0fdb28</id>
      <masked>false</masked>
      <name>params_path</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>f2882853-7121-4136-9847-e0ac1e6703d6</id>
      <masked>false</masked>
      <name>domain</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>569252df-bdf7-4c0a-955d-6c2994b68b28</id>
      <masked>false</masked>
      <name>topology_id</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>f73f358d-9854-48ff-bcd4-ae9bf39a01c8</id>
      <masked>false</masked>
      <name>user</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>2bff81c3-c2c4-4547-baeb-d4334907d1ed</id>
      <masked>false</masked>
      <name>longevity_submission_id</name>
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
