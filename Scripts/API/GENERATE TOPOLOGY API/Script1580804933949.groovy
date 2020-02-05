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

response = WS.sendRequest(findTestObject('API OBJECT/GENERATE TOPOLOGY', [('command') : 'python3 /var/www/html/masterupdate/tools/autobuild_topology.py --params_list /volume/regressions/toby/test-suites/MTS/test-scripts/protocols/MPLS/mpls_mts.vmx.params,/volume/regressions/toby/test-suites/MTS/test-scripts/protocols/VPN/CCC/ccc_mts.vmx.params,/volume/regressions/toby/test-suites/MTS/test-scripts/protocols/VPN/CCC/ccc_mts.vptx.params --user ramkrish --domain snp-service-dut-mx480 --topology_id ramkrish_protocol_all_master_topology --longevity_submission_id ramkrish_protocol_all']))

WS.verifyResponseStatusCode(response, 200)

assertThat(response.getResponseText()).contains('DONE')

