package utilities;

import driver.DriverManagerFactory;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.net.ssl.HttpsURLConnection;
import java.awt.*;
import java.awt.datatransfer.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.*;
import java.util.zip.GZIPInputStream;

/**
 * Refactor late
 */
public class ActionWebUtils {
    private final static String USER_AGENT = "Mozilla/5.0";
    
    public static ClipboardOwner clipboardOwner;

    private static WebDriver driver = DriverManagerFactory.getExistingManager().getDriver();
    
    public static void submit(WebElement element) {
        waitForElement(element, 15);
        element.submit();
        waitForPageLoad(5);
    }

    /**
     * Wait for an element to be loaded
     *
     * @param element
     * @param maxWaitTimeInSeconds
     */
    public static void waitForElement(WebElement element, int maxWaitTimeInSeconds) {
        try {
            int i = 0;
            while (!(element.isEnabled() & !element.isEnabled() & element.isDisplayed())
                    && i < maxWaitTimeInSeconds * 1000) {
                Thread.sleep(10);
                i += 10;
            }
        } catch (Exception e) {
            return;
        }
    }


    /**
     * Wait for the page fully loaded
     *
     * @param maxWaitTimeInSeconds
     */
    public static void waitForPageLoad(int maxWaitTimeInSeconds) {
        Long now = System.currentTimeMillis();
        String readyState;
        do {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            readyState = jsExecutor.executeScript("if (document.readyState) return document.readyState;").toString();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if ((System.currentTimeMillis() - now) > (maxWaitTimeInSeconds * 1000))
                break;
        } while (readyState.toLowerCase() != "complete");
    }
    
    /**
     * Set a checkbox On/Off
     */
    public static void set(WebElement element, String value) {
        waitForElement(element, 15);
        Boolean isChecked = element.isSelected();
        switch (isChecked.toString().toLowerCase()) {
            case "true":
                if (value == "on" || value == "On") {
                    return;
                } else {
                    if (value == "off" || value == "Off") {
                        element.click();
                    }
                }
                break;
            case "false":
                if (value == "on" || value == "On") {
                    element.click();
                } else {
                    if (value == "off" || value == "Off") {
                        return;
                    }
                }
                break;
        }
    }

    public static Boolean doesElementExist(By elementBy) {
        return true;
    }

    /**
     * Return the value of the first selected item of a DropDown list
     **/
    public static String getDdlFirstSelectedItem(WebElement element) {
        Select dropdown = new Select(element);
        return dropdown.getFirstSelectedOption().getAttribute("value");
    }

    /**
     * Wait for an element to be disappeared
     **/
    public static void waitForElementToDisappear(By byElement, int maxWaitTimeInSeconds) {
        Boolean elementExisting = doesElementExist(byElement);
        if (!elementExisting) {
            return;
        } else {
            int i = 0;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            while (elementExisting && (i < maxWaitTimeInSeconds * 1000)) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                i += 10;
                elementExisting = doesElementExist(byElement);
            }
        }
    }

    public static String captureScreenshot() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date date = new Date();
        String takenDate = dateFormat.format(date);
        // take the screenshot at the end of every test
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String fileLocation = "";
        // now save the screenshot to a file some place
        try {
            fileLocation = "screenshots//" + takenDate + ".png";
            FileUtils.copyFile(scrFile, new File(fileLocation));
            System.out.println("***SCREENSHOT***: " + fileLocation);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return fileLocation;
    }

    public static String captureScreenshot(String filePath, String imgName) {
        File directory = new File(filePath);
        // take the screenshot at the end of every test
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String fileLocation = "";
        // now save the screenshot to a file some place
        try {
            fileLocation = directory.getAbsolutePath() + "\\" + imgName + ".png";
            FileUtils.copyFile(scrFile, new File(fileLocation));
            System.out.println("***SCREENSHOT***: " + fileLocation);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return fileLocation;
    }

    public static String captureScreenshot(String log) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date date = new Date();
        String takenDate = dateFormat.format(date);
        // take the screenshot at the end of every test
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String fileLocation = "";
        // now save the screenshot to a file some place
        try {
            fileLocation = "screenshots//" + takenDate + ".png";
            FileUtils.copyFile(scrFile, new File(fileLocation));
            System.out.println(log + " : " + fileLocation);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return fileLocation;
    }

    public static String generateUniqueString() {
        String string = "";
        DateFormat dateFormat = new SimpleDateFormat("MMddyy_HHmmssSSS");
        Date date = new Date();

        string = dateFormat.format(date) + randomStringAndDigits(2);
        return string;
    }

    public static String getPropertyFileValue(String filename, String key) {
        Properties prop = new Properties();
        InputStream input = null;
        String value = "";
        try {
            input = new FileInputStream(filename);
            // load a properties file
            prop.load(input);

            // get the property value and print it out
            value = prop.getProperty(key);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }

    /**
     * public static void init(WebDriver driver) { // Delete all cookies before
     * testing driver.manage().deleteAllCookies(); Driver.SetElementWait(90);
     * setPageWait(90); }
     **/

    public static String randomStringAndDigits(int len) {
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static String randomNumber(int len) {
        String AB = "0123456789";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));

        String value = sb.toString();
        for (int j = 0; j <= value.length(); j++) {
            if (String.valueOf(value.charAt(0)).equals("0")) {
                value = value.substring(1);
            }
        }
        return value;
    }

    public static String randomString(int min, int max) {
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        // Random length of the string
        int randomNumber = rnd.nextInt(max - min) + min;
        StringBuilder sb = new StringBuilder(randomNumber);
        for (int i = 0; i < randomNumber; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));

        return sb.toString();
    }

    public static String randomNumber(int min, int max) {
        String AB = "1234567890";
        Random rnd = new Random();
        // Random length of the string
        int randomNumber = rnd.nextInt(max - min) + min;
        StringBuilder sb = new StringBuilder(randomNumber);
        for (int i = 0; i < randomNumber; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        String value = sb.toString();

        for (int j = 0; j <= value.length(); j++) {
            if (String.valueOf(value.charAt(0)).equals("0")) {
                value = value.substring(1);
            }
        }
        return value;
    }

    public static int randomInRange(int min, int max) {
        if (max - min == 0) {
            return 0;
        }

        Random rnd = new Random();
        int randomNumber = rnd.nextInt(max - min) + min;
        return randomNumber;
    }

    public static void setClipboardData(String string) {
        StringSelection stringSelection = new StringSelection(string);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, clipboardOwner);
    }

    public static void sleep(int miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getResponseData(String URL) {
        StringBuilder sb = new StringBuilder();
        URLConnection urlConn = null;
        InputStreamReader in = null;
        try {
            URL url = new URL(URL);
            urlConn = url.openConnection();
            if (urlConn != null) {
                urlConn.setReadTimeout(60 * 1000);
            }
            if (urlConn != null && urlConn.getInputStream() != null) {
                in = new InputStreamReader(urlConn.getInputStream(), Charset.defaultCharset());
                BufferedReader bufferedReader = new BufferedReader(in);
                if (bufferedReader != null) {
                    int cp;
                    while ((cp = bufferedReader.read()) != -1) {
                        sb.append((char) cp);
                    }
                    bufferedReader.close();
                }
            }
            in.close();
        } catch (Exception e) {
            throw new RuntimeException("Exception while calling URL: " + URL, e);
        }
        return sb.toString();
    }

    /**
     * This action is used to get response from POST request
     *
     * @param URL
     * @param parameter : parameter string (ex:
     *                  {\"country\":\"VietNam\",\"zipcode\":8000})
     */
    public static String getResponseData(String URL, String parameter) {
        String url = URL;
        StringBuffer result = new StringBuffer();
        try {
            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost(url);
            post.setHeader("Accept-Encoding", "gzip, deflate");

            StringEntity input = new StringEntity(parameter);
            input.setContentType("application/json");
            post.setEntity(input);

            HttpResponse response = client.execute(post);

            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(new GZIPInputStream(response.getEntity().getContent())));

            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {
        }
        return result.toString();
    }

    public static String getPlatformVersion(String udid) {
        String version = ActionWebUtils.executeCommand("adb -s " + udid + " shell getprop ro.build.version.release")
                .toString();
        return version;
    }

    public static OutputStream executeCommand(String strCommand) {
        OutputStream outputStream = null;
        CommandLine command = new CommandLine("cmd");
        command.addArgument("/c " + strCommand);
        DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
        DefaultExecutor executor = new DefaultExecutor();
        executor.setExitValue(1);
        outputStream = new ByteArrayOutputStream();
        PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);
        try {
            executor.setStreamHandler(streamHandler);
            executor.execute(command, resultHandler);
            ActionWebUtils.sleep(5000);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        return outputStream;
    }

    // Implementation of getTestDataPath method
    public static String getFilesPath(String dataPath) {
        /** HANDLE RUNNING TESTS WITH MAVEN **/
        String dataPath_Maven = "../src/main/java/files/";
        File mavenPath = new File(dataPath_Maven);
        if ((mavenPath.exists()) && (mavenPath.isDirectory())) {
            dataPath = dataPath_Maven;
        }
        return dataPath;
    }

    public static String removeHTMLTag(String text, String replaceBy) {
        return text.replaceAll("\\<[^>]*>", replaceBy);
    }

    // Long updated on 12/28/2015
    public static String randomString(int len) {
        String AB = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static String randomStringDigitsAndSpecial(int len) {
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ~!@#$%^&*()";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static String randomSpecial(int len) {
        String AB = "~!@#$%^&*()_+{}[]:<>,.";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static String convertListToString(String[] list, String delimeter) {
        String sResult = "";
        int i = 0;
        for (i = 0; i <= list.length - 2; i++) {
            sResult += list[i] + delimeter;
        }
        sResult += list[list.length - 1];

        return sResult;
    }

    public static Integer generateRandomNumber(int length) {
        String numbers = "0123456789";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(numbers.charAt(rnd.nextInt(numbers.length())));
        return Integer.parseInt(sb.toString());
    }

    public static double randomDouble() {
        Random rnd = new Random();
        return rnd.nextDouble();
    }

    public static String getCurrentTime() {
        String currentTime = "";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        GregorianCalendar calendar = new GregorianCalendar();
        currentTime = format.format(calendar.getTime());
        return currentTime;
    }

    public static String randomAlpha(int len) {
        String AB = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static String randomCurrency() {
        String[] currencies = {"AED", "AFN", "ALL", "AMD", "ANG", "AOA", "ARS", "AUD", "AWG", "AZN", "BAM", "BBD",
                "BDT", "BGN", "BHD", "BIF", "BMD", "BND", "BOB", "BRL", "BSD", "BTN", "BWP", "BYR", "BZD", "CAD", "CDF",
                "CHF", "CLP", "CNY", "COP", "CRC", "CUC", "CVE", "CZK", "DJF", "DKK", "DOP", "DZD", "EEK", "EGP", "ERN",
                "ETB", "EUR", "FJD", "FKP", "GBP", "GEL", "GHS", "GIP", "GMD", "GNF", "GQE", "GTQ", "GYD", "HKD", "HNL",
                "HRK", "HTG", "HUF", "IDR", "ILS", "INR", "IQD", "IRR", "ISK", "JMD", "JOD", "JPY", "KES", "KGS", "KHR",
                "KMF", "KPW", "KRW", "KWD", "KYD", "KZT", "LAK", "LBP", "LKR", "LRD", "LSL", "LTL", "LVL", "LYD", "MAD",
                "MDL", "MGA", "MKD", "MMK", "MNT", "MOP", "MRO", "MUR", "MVR", "MWK", "MXN", "MYR", "MZM", "NAD", "NGN",
                "NIO", "NOK", "NPR", "NZD", "OMR", "PAB", "PEN", "PGK", "PHP", "PKR", "PLN", "PYG", "QAR", "RON", "RSD",
                "RUB", "SAR", "SBD", "SCR", "SDG", "SEK", "SGD", "SHP", "SLL", "SOS", "SRD", "SYP", "SZL", "THB", "TJS",
                "TMT", "TND", "TRY", "TTD", "TWD", "TZS", "UAH", "UGX", "USD", "UYU", "UZS", "VEB", "VND", "VUV", "WST",
                "XAF", "XCD", "XDR", "XOF", "XPF", "YER", "ZAR", "ZMK", "ZWR"};
        Random r = new Random();
        String currency = currencies[r.nextInt(currencies.length)];
        return currency;
    }

    /**
     * Get the String residing on the clipboard.
     * Return any text found on the Clipboard; if none found, return an empty String.
     */

    public static String getClipboardContents() {
        String result = "";
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        // odd: the Object param of getContents is not currently used
        Transferable contents = clipboard.getContents(null);
        boolean hasTransferableText = (contents != null) && contents.isDataFlavorSupported(DataFlavor.stringFlavor);
        if (hasTransferableText) {
            try {
                result = (String) contents.getTransferData(DataFlavor.stringFlavor);
            } catch (UnsupportedFlavorException | IOException ex) {
                System.out.println(ex);
                ex.printStackTrace();
            }
        }
        return result;
    }

    public static void enter(WebElement element, String text, int waitTime) {
        if (element != null) {
            element.click();
            element.clear();
            char[] t = text.toCharArray();
            for (char c : t) {
                element.sendKeys(Character.toString(c));
                sleep(waitTime);
            }
        }
    }

    public static WebElement getElement(WebDriver driver, By by) {
        // Store a string as element name for reporting on failure

        WebElement element = null;
        try {
            element = driver.findElement(by);
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException: " + by + " is not found.");
            ActionWebUtils.captureScreenshot("NoSuchElementException");
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: " + by + " is null.");
            ActionWebUtils.captureScreenshot("NullPointerException");
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            System.out.println("StaleElementReferenceException: " + by + " is not attached to the page document.");
            ActionWebUtils.captureScreenshot("StaleElementReferenceException");
        }
        return element;
    }

    public static WebElement getElement(WebDriver driver, By by, int seconds) {

        WebElement element = null;
        try {
            element = driver.findElement(by);
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException: " + by + " is not found.");
            ActionWebUtils.captureScreenshot("NoSuchElementException");
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: " + by + " is null.");
            ActionWebUtils.captureScreenshot("NullPointerException");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException: " + e);
            ActionWebUtils.captureScreenshot("NullPointerException");
        }

        return element;
    }

    public static WebElement getElement(By by) {
        // Store a string as element name for reporting on failure

        WebElement element = null;
        try {
            element = driver.findElement(by);
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException: " + by + " is not found.");
            ActionWebUtils.captureScreenshot("NoSuchElementException");
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: " + by + " is null.");
            ActionWebUtils.captureScreenshot("NullPointerException");
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            System.out.println("StaleElementReferenceException: " + by + " is not attached to the page document.");
            ActionWebUtils.captureScreenshot("StaleElementReferenceException");
        }
        return element;
    }

    public static WebElement getElement(By by, int seconds) {

        WebElement element = null;
        try {
            element = driver.findElement(by);
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException: " + by + " is not found.");
            ActionWebUtils.captureScreenshot("NoSuchElementException");
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: " + by + " is null.");
            ActionWebUtils.captureScreenshot("NullPointerException");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException: " + e);
            ActionWebUtils.captureScreenshot("NullPointerException");
        }

        return element;
    }

    public boolean isAttributePresent(WebElement element, String attribute) {
        boolean result = false;

        String _temp = element.getAttribute(attribute);
        if (_temp != null) {
            result = true;
        }
        return result;
    }

    public static String getPropertyValue(WebElement element, String property) {
        String actual = element.getAttribute(property);
        return actual;
    }

    public static void selectItem(WebElement element, String item) {
        Select cboType = new Select(element);
        cboType.selectByVisibleText(item);
    }

    public static void selectItem(By by, String item) {
        WebElement element = getElement(by);
        Select cboType = new Select(element);
        cboType.selectByVisibleText(item);
    }

    public static void waitInvisible(By by, int seconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, seconds);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        } catch (Exception e) {
        }
    }

    public static void waitInvisible(WebElement element, int seconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, seconds);
            String xpath = element.toString();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
        } catch (Exception e) {
        }
    }

    public static void waitVisible(WebElement element, int seconds) {
        if (element != null) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, seconds);
                // wait.until(ExpectedConditions.elementToBeClickable(element));
                wait.until(ExpectedConditions.visibilityOf(element));
                double i = 0;
                while (!element.isEnabled() && i <= seconds) {
                    i = i + 0.5;
                }
            } catch (Exception e) {
            }
        }
    }

    public static void waitVisible2(WebElement element, int seconds) {
        if (element != null) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, seconds);
                // wait.until(ExpectedConditions.elementToBeClickable(element));
                wait.until(ExpectedConditions.elementToBeClickable(element));

            } catch (Exception e) {
            }
        }
    }

    public static void waitDisplay(WebElement element, int seconds) {
        if (element != null) {
            Boolean flag;
            long start = System.currentTimeMillis();
            long maxtime = start + seconds;
            for (int i = (int) start; i < maxtime; i++) {
                flag = element.isDisplayed();
                if (flag) {
                    break;
                }
            }
        }
    }

    public static void waitAttribute(WebElement element, String attribute, String value, int seconds) {
        int i = 0;
        if (element != null) {
            if (attribute.equalsIgnoreCase("text")) {
                while (!element.getText().contains(value) && i < seconds) {
                    ActionWebUtils.sleep(1000);
                    i++;
                }
            } else {
                System.out.println("Wait attribute: " + element.getAttribute(attribute));
                while (!element.getAttribute(attribute).contains(value) && i < seconds) {
                    ActionWebUtils.sleep(1000);
                    i++;
                }
            }
        }
    }

    /**
     * This action is used to handle error ElementNotVisible when trying to click on
     */
    public static void click(WebElement element) {
        if (element != null) {
            try {
                element.click();
            } catch (Exception e) {
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].click();", element);
            }
        }
    }

    /**
     * This action is used to type text to text box, it is handled some issue on Safari and special characters
     */
    public static void type(WebElement textbox, String text) {
        String property = "";
        try {
            if (text.contains("&")) {
                String[] inputStrings = text.split("&");
                text = inputStrings[0];
                for (int i = 1; i < inputStrings.length; i++) {
                    text = text + Keys.chord(Keys.SHIFT, "7") + inputStrings[i];
                }
            }
            textbox.sendKeys(text);
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            System.out.println("Title: " + driver.getTitle());
            if (!textbox.getAttribute("name").equalsIgnoreCase("")) {
                property = textbox.getAttribute("name");
                System.out.println(property);
                js.executeScript(
                        "document.getElementsByName('" + property + "')[1].setAttribute('value', '" + text + "')");
            } else if (!textbox.getAttribute("id").equalsIgnoreCase("")) {
                property = textbox.getAttribute("id");
                js.executeScript("document.getElementById('" + property + "').setAttribute('value', '" + text + "')");
            }
        }
    }

    public static void drapAndDrop(WebElement drapElement, WebElement targetElement) {
        Actions action = new Actions(driver);
        action.dragAndDrop(drapElement, targetElement).perform();
    }

    public static void mouseHover(WebElement element) {
        Actions action = new Actions(driver);

        if (element != null) {
            try {
                action.moveToElement(element).perform();
                ;
            } catch (Exception e) {
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].click();", element);
            }
        }
    }

    /**
     * Firefox zoom In/Out actions
     */
    public static void FirefoxZoomIn() {
        driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));
    }

    public static void FirefoxZoomOut() {
        driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
    }

    public static void FirefoxDefaultZoom() {
        driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "0"));
    }

    public static void sendkeys(WebElement element, String text, int delayTime) {
        if (element != null) {
            char[] t = text.toCharArray();

            for (char c : t) {

                element.sendKeys(Character.toString(c));
                ActionWebUtils.sleep(delayTime);
            }
        }

    }

    /**
     * Switch to the iframe to interact
     */
    public static void switchFrame(By locator, int seconds) {
        WebElement iframe = getElement(locator);
        if (iframe != null) {
            try {
                System.out.println("wait the iFrame " + iframe.getAttribute("id") + " displays");
                WebDriverWait wait = new WebDriverWait(driver, seconds);
                wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
                driver.switchTo().frame(iframe);

                System.out.println("Frame load complete");
            } catch (Exception e) {
            }
        }
    }

    public static void waitFrameVisible(By locator, int seconds) {
        WebElement iframe = getElement(locator);
        if (iframe != null) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, seconds);
                System.out.println("Found the iFrame: " + iframe.getAttribute("id"));
                wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));

                driver.switchTo().defaultContent();
                System.out.println("Return to the default working frame");
            } catch (Exception e) {
            }
        }
    }

    public static List<WebElement> getElements(By by) {

        List<WebElement> element = null;
        try {
            element = driver.findElements(by);
        } catch (NoSuchElementException e) {
            // System.out.println("Caught exception: " + by + " is not found.");
            // exec.captureScreenshot("NoSuchElementException");
        } catch (NullPointerException e) {
            // exec.captureScreenshot("NullPointerException");
        }
        return element;
    }

    public static List<String> getCookies(String url, String urlParameters) throws Exception {

        // String url = "https://selfsolve.apple.com/wcResults.do";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        // add request header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        // System.out.println("\nSending 'POST' request to URL : " + url);
        // System.out.println("Post parameters : " + urlParameters);
        // System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        List<String> cookies = con.getHeaderFields().get("Set-Cookie");
        obj.openConnection();

        in.close();

        // print result
        // System.out.println(response.toString());
        return cookies;

    }

    public static void launch(String url) {
        if (!driver.getCurrentUrl().equalsIgnoreCase(url)) {
            driver.get(url);
        }
        driver.manage().window().maximize();
        ActionWebUtils.waitForPageLoad(10);
    }

    public static void switchToWindow(String name) {
        ActionWebUtils.sleep(5000);
        WebDriver popup = null;
        Iterator<String> windowIterator = driver.getWindowHandles().iterator();
        while (windowIterator.hasNext()) {
            String windowHandle = windowIterator.next();
            // System.out.println(windowHandle);
            popup = driver.switchTo().window(windowHandle);
            if (popup.getTitle().contains(name)) {
                break;
            }
        }
    }

    /**
     * Javascript Executor. Scroll page actions. Scroll by given pixel offset
     */
    public static void jsExecutor_ScrollActions() {
        JavascriptExecutor javascript = (JavascriptExecutor) driver;

//		To scroll down web page by 600 pixels in x(vertical)
        javascript.executeScript("window.scrollBy(0,600)", "");

//		To scroll up web page by 300 pixels In x(vertical) direction.
        javascript.executeScript("window.scrollBy(0,-300)", "");

//		Scroll by lines
        javascript.executeScript("window.scrollByLines(2)");

//		Scroll down to bottom of page
        javascript.executeScript("window.scrollTo(0, document.body.scrollHeight)", "");

//		Scroll to element
        WebElement element = driver.findElement(By.xpath("//div[@id='dragdiv']"));
        javascript.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static WebElement jsExecutor_getElement(String byID) {
        WebElement element = null;
        try {
            JavascriptExecutor javascript = (JavascriptExecutor) driver;
            element = (WebElement) javascript.executeScript("return document.getElementById('" + byID + "');", element);

//			List elements = (List) javascript.executeScript("return document.getElementsByTagName('div');", searchbox);

        } catch (Exception e) {
            System.out.println("Exception: " + e);
            ActionWebUtils.captureScreenshot("Exception");
        }
        return element;
    }

}
