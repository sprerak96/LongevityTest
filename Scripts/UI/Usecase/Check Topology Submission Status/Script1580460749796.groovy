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

