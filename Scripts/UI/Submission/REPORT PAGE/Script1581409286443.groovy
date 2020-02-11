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
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.openBrowser('')

WebUI.navigateToUrl('http://localhost:8000/longevity/report/preraks_katalon_test')

WebUI.click(findTestObject('Object Repository/Page_SNP PORTAL/button_Master Params'))

response = WebUI.getText(findTestObject('Object Repository/Page_SNP PORTAL/p_r0  system model make junipername fv-tags_d6ccdc'))

//KeywordUtil.logInfo(response.toString())
WebUI.closeBrowser()

CustomKeywords.'com.test.demo.TopologyKeywords.check_params_response'(response.toString())

WebUI.openBrowser('')

WebUI.navigateToUrl('http://localhost:8000/longevity/report/preraks_katalon_test')

WebUI.click(findTestObject('Object Repository/Page_SNP PORTAL/button_Resolved Yaml'))

response = WebUI.getText(findTestObject('Object Repository/Page_SNP PORTAL/p_--- jaas   params volumeRBU_SNP_REGLongev_4f3cb2'))
//KeywordUtil.logInfo(response.toString())
WebUI.closeBrowser()
CustomKeywords.'com.test.demo.TopologyKeywords.check_yaml_response'(response.toString())

WebUI.openBrowser('')

WebUI.navigateToUrl('http://localhost:8000/longevity/report/preraks_katalon_test')

WebUI.click(findTestObject('Object Repository/Page_SNP PORTAL/button_Domain Usage'))

WebUI.closeBrowser()

WebUI.openBrowser('')

WebUI.navigateToUrl('http://localhost:8000/longevity/report/preraks_katalon_test')

WebUI.delay(5)

WebUI.verifyElementClickable(findTestObject('Object Repository/Page_SNP PORTAL/button_Start'))

WebUI.click(findTestObject('Object Repository/Page_SNP PORTAL/button_Start'))

WebUI.delay(5)

WebUI.verifyElementClickable(findTestObject('Object Repository/Page_SNP PORTAL/button_Grafana Link'))

WebUI.verifyElementClickable(findTestObject('Object Repository/Page_SNP PORTAL/button_Stop'))

WebUI.click(findTestObject('Object Repository/Page_SNP PORTAL/button_Stop'))

WebUI.closeBrowser()

WebUI.openBrowser('')

WebUI.navigateToUrl('http://localhost:8000/longevity/report/preraks_katalon_test')

WebUI.verifyElementClickable(findTestObject('Object Repository/Page_SNP PORTAL/button_Master Topology'))

WebUI.click(findTestObject('Object Repository/Page_SNP PORTAL/button_Toggle Breakup'))

WebUI.verifyElementClickable(findTestObject('Object Repository/Page_SNP PORTAL/button_REFRESH  refresh'))

WebUI.verifyElementClickable(findTestObject('Object Repository/Page_SNP PORTAL/button_ADD TESTS  add_circle_outline'))

WebUI.verifyElementClickable(findTestObject('Object Repository/Page_SNP PORTAL/button_END RUN  error_outline'))

WebUI.verifyElementClickable(findTestObject('Object Repository/Page_SNP PORTAL/button_EMAIL mail_outline'))

WebUI.click(findTestObject('Object Repository/Page_SNP PORTAL/button_EMAIL mail_outline'))

WebUI.setText(findTestObject('Object Repository/Page_SNP PORTAL/input_To_email_to'), 'preraks@juniper.net')

WebUI.setText(findTestObject('Object Repository/Page_SNP PORTAL/input_Subject_email_sub'), 'test_report')

WebUI.click(findTestObject('Object Repository/Page_SNP PORTAL/button_submit'))

WebUI.closeBrowser()

