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

WebUI.navigateToUrl('http://localhost:8000/longevity/Home')

WebUI.click(findTestObject('Page_SNP PORTAL/button_Longevity Assistant'))

WebUI.click(findTestObject('Object Repository/Page_SNP PORTAL/div_library_add ADD TO LONGEVITY RUN  7 Running'))

WebUI.click(findTestObject('Object Repository/Page_SNP PORTAL/div_PRERAK TEST11 Topology   prerak Domain _cf05d5'))

WebUI.click(findTestObject('Page_SNP PORTAL/div_SNP  04 TESTCASES'))

WebUI.click(findTestObject('Page_SNP PORTAL/div_Scale INET60 Routes with 1 EBGP Peer  W_ab334d'))

WebUI.click(findTestObject('Page_SNP PORTAL/button_Done'))

WebUI.click(findTestObject('Page_SNP PORTAL/button_arrow_forward_ios Next'))

WebUI.click(findTestObject('Page_SNP PORTAL/button_Schedule job'))

WebUI.click(findTestObject('Page_SNP PORTAL/button_GO TO HOME TO SEE PROGRESS'))

WebUI.closeBrowser()

CustomKeywords.'com.test.demo.TopologyKeywords.check_autobuild_topology_status'('preraks_prerak_test11_master_topology')

