package xped.automation.util;


import xped.automation.driverConfig.DriverContext;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MetodosGenericos {

	public static void mostrarElemento(WebElement element) {
		((JavascriptExecutor) DriverContext.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static boolean seleccionCombo(WebElement comboBox, String descripcion) {
		boolean selec = visualizarObjeto(comboBox, 10);
		if (selec) {
			try {
				Select box = new Select(comboBox);
				box.selectByVisibleText(descripcion);
			} catch (Exception e) {

			}
			return true;
		} else {
			return false;
		}
	}

	public static boolean validarExpresionesRegulares(String expresionRegular, String entrada) {
		Pattern patron = Pattern.compile(expresionRegular);
		Matcher palabra = patron.matcher(entrada);
		return palabra.find();
	}

	public static void mouseHoverElement(WebElement element) {
		Actions act = new Actions(DriverContext.getDriver());
		act.moveToElement(element).perform();
	}

	public static boolean visualizarObjeto(WebElement elementName, int timeout) {
		try {
			System.out.println("Valida si Es visible el elemento a validar.");
			WebDriverWait wait = new WebDriverWait(DriverContext.getDriver(), Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.visibilityOf(elementName));
			System.out.println("Es visible el elemento a validar: " + elementName.getText());
			System.out.println("==============================================");
			System.out.println();
			return true;
		} catch (Exception var3) {
			System.out.println("No es visible el elemento a validar.");
			return false;
		}
	}

	public static void esperar(int tiempo) {
		try {
			System.out.println("Esperando: " + tiempo + "s");
			Thread.sleep(tiempo * 1000);
		} catch (InterruptedException io) {
			System.out.println(">>> " + io);
		}
	}

	public static int obtenerMinutos(String tiempo) {
		int i = 0;
		try {
			SimpleDateFormat f = new SimpleDateFormat("HH:mm");
			Date d = f.parse(tiempo);
			long tiempoInicial = d.getTime();

			DateFormat dateFormat = new SimpleDateFormat("HH:mm");
			Date date = new Date();

			String horaActual = dateFormat.format(date);
			Date e = f.parse(horaActual);
			long tiempofinal = e.getTime();

			long resta = tiempoInicial - tiempofinal;
			resta = resta / (1000 * 60);
			i = (int) resta;

		} catch (Exception var3) {
			System.out.print(var3);
		}

		return i;
	}

	public static void bajarScrollRobot() throws AWTException {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_END);
			robot.keyRelease(KeyEvent.VK_END);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static String getSelectedOptionValue(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(DriverContext.getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(webElement));
		Select select = new Select(webElement);
		return select.getFirstSelectedOption().getAttribute("value");
	}

	public static void selectOptionByValue(WebElement webElement, String value) {
		try{
			WebDriverWait wait = new WebDriverWait(DriverContext.getDriver(), Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(webElement));
			Select select = new Select(webElement);
			select.selectByValue(value);

		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Elemento no visible: " + e.getMessage());
		}

	}

	public static void waitImplicit(int time) {
		try {
			System.out.println("Esperando elemento");
			DriverContext.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		} catch (Exception var3) {

			System.out.println("Espera no cumplida");
		}
	}

	public static void waitExplicit(WebElement elementName, int time) {
			try {
				System.out.println("Esperando elemento");
				WebDriverWait myWaitVar = new WebDriverWait(DriverContext.getDriver(), Duration.ofSeconds(time));
				myWaitVar.until(ExpectedConditions.visibilityOfAllElements(elementName));
			} catch (Exception var3) {
				System.out.println("Espera no cumplida");
			}
	}
	public static void waitExplicitToBeClicleable(WebElement elementName, int time) {
		try {
			System.out.println("Esperando elemento");
			WebDriverWait myWaitVar = new WebDriverWait(DriverContext.getDriver(), Duration.ofSeconds(time));
			myWaitVar.until(ExpectedConditions.elementToBeClickable(elementName));
		} catch (Exception var3) {
			System.out.println("Espera no cumplida " + var3.getMessage());
		}
	}

	public static void cambiarVentana(int pantalla) {
		try {
			ArrayList<String> tabs = new ArrayList<String>(DriverContext.getDriver().getWindowHandles());
			DriverContext.getDriver().switchTo().window(tabs.get(pantalla));
		} catch (Exception e) {
			Assert.fail();
		}
	}

	public static void validarDatosContraApi(String datoApi, WebElement elementName) {

		if (datoApi.equals(elementName.getText())) {
			System.out.println("Validacion OK: " + datoApi);
		} else {
			Assert.fail("El " + datoApi + " no corresponde al registrado en la API");
		}

	}

	public static void accionClick(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			System.out.println("No es posible realizar click al elemento: " + e.getMessage());
			Assert.fail();
		}

	}

	public static void accionClicJS(WebElement element, String nombreElemento) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) DriverContext.getDriver();
			executor.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			Assert.fail();
		}

	}

	public static void accionSenkeys(WebElement element, String dato) {
		try {
			element.sendKeys(dato);
		} catch (Exception e) {
			Assert.fail();
		}

	}

	public static void accionClear(WebElement element, String nombreElemento) {
		try {
			element.clear();
		} catch (Exception e) {
			Assert.fail();
		}

	}

	public static String accionGetText(WebElement element, String nombreElemento) {
		String dato = null;
		try {
			dato = element.getText();
		} catch (Exception e) {

		}
		return dato;
	}

	public static String accionGetAtributo(WebElement element, String atributo, String nombreElemento) {
		String dato = null;
		try {
			dato = element.getAttribute(atributo);
		} catch (Exception e) {
			Assert.fail();
		}
		return dato;
	}

	public static String[] getColorBorder(WebElement element, String nombreElemento) {
		String[] color = null;
		try {
			color = element.getCssValue("border-bottom-color").replaceAll("(rgba)|(rgb)|(\\()|(\\s)|(\\))", "")
					.split(",");
		} catch (Exception e) {
			Assert.fail();
		}
		return color;
	}

	public static String convertirColorBorder(String[] colorBorder) {
		String color = null;
		try {
			color = String.format("#%s%s%s", toBrowserHexValue(Integer.parseInt(colorBorder[0])),
					toBrowserHexValue(Integer.parseInt(colorBorder[1])),
					toBrowserHexValue(Integer.parseInt(colorBorder[2])));
		} catch (Exception e) {
			Assert.fail();
		}
		return color;
	}

	private static String toBrowserHexValue(int number) {
		StringBuilder builder = new StringBuilder(Integer.toHexString(number & 0xff));
		while (builder.length() < 2) {
			builder.append("0");
		}
		return builder.toString().toUpperCase();
	}

	public static void validarFormatoColor(String colorFormat, String codigoValidacion, String nombreColor,
			String nombreCampo) {

		try {
			if (colorFormat.equals(codigoValidacion)) {

			} else {
				Assert.fail();
			}

		} catch (Exception e) {

		}

	}

	public static boolean validarEstadoBotones(WebElement element) {
		boolean estado = false;
		try {
			estado = element.isEnabled();
		} catch (Exception e) {
			Assert.fail();
		}

		return estado;
	}

	public static List<LogEntry> retornaTrazaNetwork() {

		List<LogEntry> entries = DriverContext.getDriver().manage().logs().get(LogType.PERFORMANCE).getAll();
		System.out.println(entries.size() + " " + LogType.PERFORMANCE + " log entries found");

		return entries;

	}

	public static void cerrarVentana() {
		DriverContext.getDriver().close();
	}

	public static void refresh() {
		DriverContext.getDriver().navigate().refresh();
	}

	public static void moverPantalla(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) DriverContext.getDriver();
		js.executeScript("arguments[0].scrollIntoView();", element);

	}
	
	public static void bajarScroll() {

		JavascriptExecutor js = (JavascriptExecutor) DriverContext.getDriver();
		js.executeScript("window.scrollBy(0,250)");

	}
	public static void subirScroll() {

		JavascriptExecutor js = (JavascriptExecutor) DriverContext.getDriver();
		js.executeScript("window.scrollTop()");

	}

	public static void cambiarUrl(String url){
		DriverContext.getDriver().get(url);
	}

	public static void scrollElement(WebElement element, WebDriver driver){
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}

	public static void verificarTexto(WebElement element, String mensaje){
		try{
			String dato = element.getText();
			if(dato.equals(mensaje)){
				Assert.assertTrue("Se comprueba que texto corresponde al mostrado en FRONT " + mensaje, true);
			}else {
				Assert.fail("El texto no corresponde al que se encontro en el FRONT " + mensaje);
			}
		}catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Se genera el siguiente error, al intentar verificar sección: " + e.getMessage());
		}
	}
	public static void verificarTextoporAtributo(WebElement element, String mensaje, String atributo){
		try{
			if(element.getAttribute(atributo).equals(mensaje)){
				Assert.assertTrue("Se comprueba que texto corresponde al mostrado en FRONT " + mensaje, true);
			}else {
				Assert.fail("El texto no corresponde al que se encontro en el FRONT " + mensaje);
			}
		}catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Se genera el siguiente error, al intentar verificar sección: " + e.getMessage());
		}


	}

	public static int mostrarLargoList(List<WebElement> list) {
		int valor = 0;
		try {
			valor = list.size();
			System.out.println("El largo de la lista tiene un total de "+ valor + "Resultados");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Se genera el siguiente error, al intentar verificar sección: " + e.getMessage());
		}
		return valor;

	}

	public static void verificarTextoConExpresionRegular(String expresion, WebElement element, String entrada){
		String dato = "";
		try{

			/*Pattern patron = Pattern.compile(expresion);
			Matcher palabra = patron.matcher(entrada);
			if (palabra.find()){
				dato = palabra.group();
			}*/
			Pattern patternName = Pattern.compile(expresion);
			Matcher matcher = patternName.matcher(entrada);
			if (matcher.find()){
				dato = matcher.group();
			}

			if(element.getText().equals(dato)){
				Assert.assertTrue("Se comprueba que texto corresponde al mostrado en FRONT ", true);
			}else {
				Assert.fail("El texto no corresponde al que se encontro en el FRONT ");
			}
		}catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Se genera el siguiente error, al intentar verificar sección: " + e.getMessage());
		}
	}

	public static void compararTextos(String txtElemento, String textoComparar){
		try {
			if (txtElemento.equals(textoComparar)){
				Assert.assertTrue("Se comprueba que texto corresponde al mostrado en FRONT ", true);
			}else {
				Assert.fail("El texto no corresponde al que se encontro en el FRONT ");
			}
		}catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Se genera el siguiente error, al intentar verificar sección: " + e.getMessage());
		}
	}


}
