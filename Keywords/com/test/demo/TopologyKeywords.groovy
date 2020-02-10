package com.test.demo

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.json.JSONObject;
import com.kms.katalon.core.logging.KeywordLogger
import internal.GlobalVariable
import com.kms.katalon.core.util.KeywordUtil
import java.util.concurrent.TimeUnit;
public class TopologyKeywords {



	@Keyword
	def check_autobuild_topology_status(String a) {
		//KeywordLogger log = new KeywordLogger()
		//log.logInfo("yourMsg")
		def loop_status = true
		def topology_doc = null
		def timeout = false
		def loop_count = 0
		while (loop_status){
			def url = "http://10.216.35.242:9200/longevity_jobs/_search?q=longevity_submission_id:"+a
			def get = new URL(url).openConnection();
			def getRC = get.getResponseCode();
			//log.logInfo(getRC);
			def resp = null;
			if(getRC.equals(200)) {
				resp = get.getInputStream().getText();

			}
			def json_resp = new JSONObject(resp)
			//log.logInfo(json_resp.toString())
			def doc_total = json_resp.get('hits').get('total')
			//KeywordUtil.logInfo('Total Doc: '+doc_total.toString())
			if (doc_total==1){
				def doc = json_resp.get('hits').get('hits').get(0).get('_source')
				if (doc.has("status")){
					def status = doc.get('status')
					if (status == 'done'){
						topology_doc = json_resp.get('hits').get('hits').get(0).get('_source')
						loop_status = false
						timeout = false
					}
				}
				else{
					loop_count += 1
					TimeUnit.SECONDS.sleep(60);
					if (loop_count>30){
						loop_status = false
						timeout = true
					}
				}
			}
			else if(doc_total>1){
				KeywordUtil.markFailed('ERROR: More than one topology with the same name found.')
				loop_status = false
			}
		}
		if (timeout == true){
			KeywordUtil.markFailed('ERROR: Fusion Submission Timeout.')
		}
		else{
			//log.logInfo(topology_doc.toString())
			if(topology_doc.has('params2topology')){
				def params2topology = topology_doc.get('params2topology')
				if (params2topology == 'pass'){
					//KeywordUtil.markPassed('PASS: Params to Topology Status pass.')

					if(topology_doc.has('topology2params')){
						def topology2params = topology_doc.get('topology2params')
						if (topology2params == 'pass'){
							//KeywordUtil.markPassed('PASS: Params to Topology Status pass.')

							if(topology_doc.has('runpbuilder')){
								def runpbuilder = topology_doc.get('runpbuilder')
								if (runpbuilder == 'pass'){
									//KeywordUtil.markPassed('PASS: Params to Topology Status pass.')

									if(topology_doc.has('yamltojson')){
										def yamltojson = topology_doc.get('yamltojson')
										if (yamltojson == 'pass'){
											//KeywordUtil.markPassed('PASS: Params to Topology Status pass.')
											//KeywordUtil.logInfo('Hello')
											if(topology_doc.has('fusion_submission_name')){
												def fusion_submission_name = topology_doc.get('fusion_submission_name')
												if(topology_doc.has('fusionsubmission')){
													def fusionsubmission = topology_doc.get('fusionsubmission')
													for (int i = 0; i < fusionsubmission.length(); i++) {
														def fusion_sub_status = fusionsubmission.get(i)
														def fusion_sub_name = fusion_submission_name.get(i)
														//KeywordUtil.logInfo(fusion_sub_status.indexOf('Hello').toString())
														//KeywordUtil.logInfo(fusion_sub_status.indexOf("=pass").toString())
														if ((fusion_sub_status.indexOf(fusion_sub_name) >= 0) && (fusion_sub_status.indexOf("=pass") >= 0)){
															KeywordUtil.markPassed('PASS: Params to Topology Status pass.')
														}
														else{
															KeywordUtil.markFailed('ERROR: Fusion Submission Failed.')
															break
														}
													}
													//KeywordUtil.markPassed('PASS: Testcases Submitted to Fusion.')
													//KeywordUtil.logInfo('PASS: Testcases Submitted to Fusion.')
												}
												else{
													KeywordUtil.markFailed('ERROR: Fusion Submission Status List Not Found.')
												}


											}
											else{
												KeywordUtil.markFailed('ERROR: Fusion Submission Name List Not Found.')
											}
										}
										else if(yamltojson == 'fail'){
											KeywordUtil.markFailed('ERROR: Yaml To JSON Status fail.')
											if (topology_doc.has('yamltojson_error')){
												KeywordUtil.logInfo("Pbuilder failed with: "+topology_doc.get('yamltojson_error'))
											}
										}
										else{
											KeywordUtil.markFailed('ERROR: Params to Topology Status not set to pass/fail.')
										}
									}
									else{
										KeywordUtil.markFailed('ERROR: Internal Error Occured.')
									}
								}
								else if(runpbuilder == 'fail'){
									KeywordUtil.markFailed('ERROR: Pbuilder Status fail.')
									if (topology_doc.has('runpbuilder_error')){
										KeywordUtil.logInfo("Pbuilder failed with: "+topology_doc.get('runpbuilder_error'))
									}
								}
								else{
									KeywordUtil.markFailed('ERROR: Params to Topology Status not set to pass/fail.')
								}
							}
							else{
								KeywordUtil.markFailed('ERROR: Internal Error Occured.')
							}
						}
						else if(topology2params == 'fail'){
							KeywordUtil.markFailed('ERROR: Topology To Params Status fail.')
							if (topology_doc.has('topology2params_error')){
								KeywordUtil.logInfo("Topology To Params failed with: "+topology_doc.get('topology2params_error'))
							}
						}
						else{
							KeywordUtil.markFailed('ERROR: Params to Topology Status not set to pass/fail.')
						}
					}
					else{
						KeywordUtil.markFailed('ERROR: Internal Error Occured.')
					}
				}
				else if(params2topology == 'fail'){
					KeywordUtil.markFailed('ERROR: Params to Topology Status fail.')
					if (topology_doc.has('params2topology_error')){
						KeywordUtil.logInfo("Params to Topology failed with: "+topology_doc.get('params2topology_error'))
					}
				}
				else{
					KeywordUtil.markFailed('ERROR: Params to Topology Status not set to pass/fail.')
				}
			}
			else{
				KeywordUtil.markFailed('ERROR: Internal Error Occured.')
			}
		}

	}

	@Keyword
	def check_designed_topology_status(String a) {
		def url = "http://10.216.35.242:9200/longevity_topologies/_search?q=topology_id:"+a
		def get = new URL(url).openConnection();
		def getRC = get.getResponseCode();
		//log.logInfo(getRC);
		def resp = null;
		if(getRC.equals(200)) {
			resp = get.getInputStream().getText();

		}
		def json_resp = new JSONObject(resp)
		def doc_total = json_resp.get('hits').get('total')
		//KeywordUtil.logInfo('Total Doc: '+doc_total.toString())
		if (doc_total==1){
			KeywordUtil.markPassed('Pass: Topology Created.')
		}
		else{
			KeywordUtil.markFailed('ERROR: Topology Not Created.')
		}
	}

	@Keyword
	def check_designed_topology_status_irregular(String a) {
		def url = "http://10.216.35.242:9200/longevity_topologies/_search?q=topology_id:"+a
		def get = new URL(url).openConnection();
		def getRC = get.getResponseCode();
		//log.logInfo(getRC);
		def resp = null;
		if(getRC.equals(200)) {
			resp = get.getInputStream().getText();

		}
		def json_resp = new JSONObject(resp)
		def doc_total = json_resp.get('hits').get('total')
		//KeywordUtil.logInfo('Total Doc: '+doc_total.toString())
		if (doc_total==1){
			KeywordUtil.markFailed('ERROR: Topology Created.')
		}
		else{
			KeywordUtil.markPassed('PASS: Topology Not Created.')
		}
	}

	@Keyword
	def check_device_added_for_monitoring(String a, String b, String c) {
		def url = "http://10.216.35.242:9200/longevity_monitor_device/_search?q=device:"+a+"%20AND%20user:"+b+"%20AND%20longevity_submission_id:"+c
		def get = new URL(url).openConnection();
		def getRC = get.getResponseCode();
		//log.logInfo(getRC);
		def resp = null;
		if(getRC.equals(200)) {
			resp = get.getInputStream().getText();

		}
		def json_resp = new JSONObject(resp)
		def doc_total = json_resp.get('hits').get('total')
		//KeywordUtil.logInfo(json_resp.toString())
		if (doc_total>=1){
			KeywordUtil.markPassed('PASS: Device Added.')
		}
		else{
			KeywordUtil.markFailed('ERROR: DEVICE NOT ADDED.')
		}
	}

	@Keyword
	def check_device_delete_for_monitoring(String a, String b, String c) {
		def url = "http://10.216.35.242:9200/longevity_monitor_device/_search?q=device:"+a+"%20AND%20user:"+b+"%20AND%20longevity_submission_id:"+c
		def get = new URL(url).openConnection();
		def getRC = get.getResponseCode();
		//log.logInfo(getRC);
		def resp = null;
		if(getRC.equals(200)) {
			resp = get.getInputStream().getText();
			KeywordUtil.logInfo(resp.toString())
		}
		def json_resp = new JSONObject(resp)
		def doc_total = json_resp.get('hits').get('total')
		//KeywordUtil.logInfo('Total Doc: '+doc_total.toString())
		if (doc_total==0){
			KeywordUtil.markPassed('PASS: Device Removed.')
		}
		else{
			KeywordUtil.markFailed('ERROR: DEVICE NOT Removed.')
		}
	}

	@Keyword
	def check_user_response(String a,String b) {
		if (a.contains(b)){
			KeywordUtil.markPassed('PASS: User Data Successfully Checked')
		}
		else{
			KeywordUtil.markFailed('ERROR: Sser Data Not Checked.')
		}
	}

	@Keyword
	def generate_params_response(String a,String b) {
		if (a.contains(b)){
			KeywordUtil.markPassed('PASS: Generate Params API function successfull')
		}
		else{
			KeywordUtil.markFailed('ERROR: Generate Params API function unsuccessfull')
		}
	}

	@Keyword
	def generate_topology_response(String a,String b) {
		if (a.contains(b)){
			KeywordUtil.markPassed('PASS: Generate Topology API function successfull')
		}
		else{
			KeywordUtil.markFailed('ERROR: Generate Topology API function unsuccessfull')
		}
	}

	@Keyword
	def destroy_response(String a,String b) {
		if (a.contains(b)){
			KeywordUtil.markPassed('PASS: Destroy API function successfull')
		}
		else{
			KeywordUtil.markFailed('ERROR: Destroy API function unsuccessfull')
		}
	}

	@Keyword
	def read_log_response(String a,String b) {
		if (a.contains(b)){
			KeywordUtil.markPassed('PASS: Read Log API function successfull')
		}
		else{
			KeywordUtil.markFailed('ERROR: Read Log API function unsuccessfull')
		}
	}

	@Keyword
	def check_fusion_submit_status(String a) {
		//KeywordLogger log = new KeywordLogger()
		//log.logInfo("yourMsg")
		def loop_status = true
		def topology_doc = null
		def timeout = false
		def loop_count = 0
		while (loop_status){
			def url = "http://10.216.35.242:9200/longevity_jobs/_search?q=longevity_submission_id:"+a
			def get = new URL(url).openConnection();
			def getRC = get.getResponseCode();
			//log.logInfo(getRC);
			def resp = null;
			if(getRC.equals(200)) {
				resp = get.getInputStream().getText();

			}
			def json_resp = new JSONObject(resp)
			//log.logInfo(json_resp.toString())
			def doc_total = json_resp.get('hits').get('total')
			//KeywordUtil.logInfo('Total Doc: '+doc_total.toString())
			if (doc_total==1){
				def doc = json_resp.get('hits').get('hits').get(0).get('_source')
				if (doc.has("status")){
					def status = doc.get('status')
					if (status == 'done'){
						topology_doc = json_resp.get('hits').get('hits').get(0).get('_source')
						loop_status = false
						timeout = false
					}
				}
				else{
					loop_count += 1
					TimeUnit.SECONDS.sleep(60);
					if (loop_count>30){
						loop_status = false
						timeout = true
					}
				}
			}
			else if(doc_total>1){
				KeywordUtil.markFailed('ERROR: More than one topology with the same name found.')
				loop_status = false
			}
		}
		if (timeout == true){
			KeywordUtil.markFailed('ERROR: Fusion Submission Timeout.')
		}
		else{
			if(topology_doc.has('fusion_submission_name')){
				def fusion_submission_name = topology_doc.get('fusion_submission_name')
				if(topology_doc.has('fusionsubmission')){
					def fusionsubmission = topology_doc.get('fusionsubmission')
					for (int i = 0; i < fusion_submission_name.length(); i++) {
						def fusion_sub_status = fusionsubmission.get(i)
						def fusion_sub_name = fusion_submission_name.get(i)
						//KeywordUtil.logInfo(fusion_sub_status.indexOf('Hello').toString())
						//KeywordUtil.logInfo(fusion_sub_status.indexOf("=pass").toString())
						if ((fusion_sub_status.indexOf(fusion_sub_name) >= 0) && (fusion_sub_status.indexOf("=pass") >= 0)){
							KeywordUtil.markPassed('PASS: Params to Topology Status pass.')
						}
						else{
							KeywordUtil.markFailed('ERROR: Fusion Submission Failed.')
							break
						}
					}
					//KeywordUtil.markPassed('PASS: Testcases Submitted to Fusion.')
					//KeywordUtil.logInfo('PASS: Testcases Submitted to Fusion.')
				}
				else{
					KeywordUtil.markFailed('ERROR: Fusion Submission Status List Not Found.')
				}


			}
			else{
				KeywordUtil.markFailed('ERROR: Fusion Submission Name List Not Found.')
			}


		}

	}

}
