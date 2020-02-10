import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import static org.assertj.core.api.Assertions.*

response = WS.sendRequest(findTestObject('API OBJECT/JOB SUBMIT', [('topology_id') : 'preraks_katalon_test_master_topology'
            , ('user') : 'preraks', ('longevity_submission_id') : 'preraks_katalon_test', ('fusion_submission_name') : 'preraks_katalon_test_1581329128844'
            , ('domain') : 'rbu-snp-smoke', ('type') : 'auto', ('test_indices') : 'fibv4_ebgp_route_scale']))

WS.verifyResponseStatusCode(response, 200)

CustomKeywords.'com.test.demo.TopologyKeywords.check_autobuild_topology_status'('preraks_katalon_test')

