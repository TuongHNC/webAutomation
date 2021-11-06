package helpers;

import driver.DriverManagerFactory;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

/**
 * This class helps to work with javascript. Eg. execute a javascript command, getId, click, blur
 */
public class JavaScriptExecutorHelper {
    private static final Logger LOGGER = Logger.getLogger(JavaScriptExecutorHelper.class);

    private JavaScriptExecutorHelper() {
    }

    private static final String SCROLL_DOWN_CHECK_JS = "var d = document.documentElement;var offset = d.scrollTop" +
            " + window.innerHeight;var height = d.offsetHeight;if(offset === height){ return true;} else {return false;} ";
    private static final String GET_PROPERTY_VALUE_OF_PSEUDO_ELEMENT_JS = "return window.getComputedStyle(" +
            "document.querySelector(\"%s\"), ':%s').getPropertyValue('%s')";
    private static final String GET_VALUE_OF_ELEMENT_BY_ID_JS = "return document.getElementById('%s').value;";
    private static final String GET_INNER_HTML_FOR_ELEMENT_BY_ID_JS = "return document.getElementById('%s').innerHTML;";

    public static String getValueJS(final String id) {
        if (StringUtils.isNotBlank(id)) {
            return String.valueOf(executeJavaScript(String.format(GET_VALUE_OF_ELEMENT_BY_ID_JS, id)));
        } else {
            return null;
        }
    }

    public static String getValueJS(final WebElement webElement) {
        final String id = getId(webElement);
        if (StringUtils.isNotBlank(id)) {
            return String.valueOf(executeJavaScript(String.format(GET_VALUE_OF_ELEMENT_BY_ID_JS, id)));
        } else {
            return null;
        }
    }

    public static void setValueJS(final WebElement webElement, String value) {
        final String id = getId(webElement);
        setValueJS(id, value);
    }

    public static void setValueJS(final String id, String value) {
        if (StringUtils.isNotBlank(id)) {
            String scriptText = XpathHelper.formatXpath("return document.getElementById('%s').value='%s';", value);
            executeJavaScript(String.format(scriptText, id, value));
        } else {
            throw new InvalidElementStateException("The element should have an id to be set with this method");
        }
    }

    public static void setValueAndTab(final WebElement webElement, String value) {
        setValueJS(webElement, value);
        webElement.sendKeys(Keys.TAB);
    }

    public static String getInnerHtmlForElementWithId(final String id) {
        return String.valueOf(executeJavaScript(String.format(GET_INNER_HTML_FOR_ELEMENT_BY_ID_JS, id)));
    }

    public static Object executeJavaScript(final String script) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverManagerFactory.getExistingManager().getDriver();
        return javascriptExecutor.executeScript(script);

    }

    public static String getId(WebElement webElement) {
        return webElement.getAttribute("id");
    }

    public static void blur(WebElement webElement) {
        WebDriver driver = DriverManagerFactory.getExistingManager().getDriver();
        driver.switchTo().window(driver.getWindowHandle());
        final String id = getId(webElement);
        if (StringUtils.isNotBlank(id)) {
            executeJavaScript("return document.getElementById('" + id + "').blur();");
        }
    }

    /**
     * Blur the input element to have fields update using EXT commands
     */
    public static void extBlur(WebElement webElement) {
        final String id = getId(webElement);
        if (StringUtils.isNotBlank(id)) {
            executeJavaScript("Ext.getCmp('" + id + "').fireEvent('blur');");
        }
    }

    public static void click(WebElement webElement) {
        final String id = getId(webElement);
        click(id);
    }

    public static void click(String id) {
        if (StringUtils.isNotBlank(id)) {
            LOGGER.info(String.format("Click by JavaScript on button id [%s]", id));
            executeJavaScript("return document.getElementById('" + id + "').click();");
        }
    }

    public static void doubleClickByJS(final WebElement element) {
        WebDriver driver = DriverManagerFactory.getExistingManager().getDriver();
        try {
            new Actions(driver).doubleClick(element).perform();
        } catch (WebDriverException ex) {
            LOGGER.warn("Element is not clickable. Try to click by Javascript.");
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].ondblclick()", element);
        }
    }

    public static void refreshIframe(final String iframeId) {
        executeJavaScript("document.getElementById('" + iframeId + "').src = document.getElementById('" + iframeId + "').src;");
    }

    public static void fireExtJsEvent(final String elementId, final String eventName, final String value) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverManagerFactory.getExistingManager().getDriver();
        String script = "Ext.getCmp('%s').fireEvent('%s', %s);";
        javascriptExecutor.executeScript(String.format(script, elementId, eventName, value));
    }

    public static void scrollToElement(By locator) {
        WebDriver driver = DriverManagerFactory.getExistingManager().getDriver();
        JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(locator);
        je.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void scrollToElement(WebElement webElement) {
        JavascriptExecutor je = (JavascriptExecutor) DriverManagerFactory.getExistingManager().getDriver();
        je.executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    public static void click(By locator) {
        WebDriver driver = DriverManagerFactory.getExistingManager().getDriver();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", driver.findElement(locator));
    }

    public static void uploadFile(final String fileUploadInputId, final String filePath) {
        LOGGER.info(String.format("Upload file [%s]", filePath));
        executeJavaScript("document.getElementById('" + fileUploadInputId + "').style = 'display:block;';");
        DriverManagerFactory.getExistingManager().getDriver().findElement(By.id(fileUploadInputId)).sendKeys(filePath);
    }

    public static boolean isScrollOnBottom() {
        return (boolean) executeJavaScript(SCROLL_DOWN_CHECK_JS);
    }

    /**
     * Helper that helps to get property value of Pseudo Element in DOM (For example: ::before, ::after...)
     *
     * @param cssLocator        css locator by string
     * @param pseudoElementName name of pseudo element by string
     * @param propertyKey       property key
     * @return String
     */
    public static String getPropertyValueOfPseudoElement(String cssLocator, String pseudoElementName, String propertyKey) {
        return (String) executeJavaScript(String.format(
                GET_PROPERTY_VALUE_OF_PSEUDO_ELEMENT_JS, cssLocator, pseudoElementName, propertyKey));
    }
}
