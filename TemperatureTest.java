/** 
 * @author Aditya Mahajan <aditya.mahajan@mcgill.ca>
 * @version 2013.10.06
 * Unit Testing Temperature class
 */

import org.junit.* ;
import static org.junit.Assert.* ;

public class TemperatureTest {

	
  // Add multiple tests to check all functions of
  // {@Code Temperature} class.
	
	
	//private variables for testing
	
	final double PRECISION_ERROR= 0.0001;
	
	private Temperature testTemp;
	
	private double testingValue;
	private double valueResulted;
	
	private double expectedConvertedValue;
	
	private Temperature.Units testingUnit;
	private Temperature.Units unitResulted;
	
	private Temperature.Units testConvUnit;
	

	
	/*
	 * First test getValue for each unit of temperature 
	 */
	@Test
	public void testCelsiusGetValue () 
	{	
		testingValue = 200;
		testingUnit = Temperature.Units.CELSIUS;
		testTemp = new Temperature (testingValue, testingUnit);
		valueResulted = testTemp.getValue ();
		assertEquals (testingValue, valueResulted, PRECISION_ERROR);
	}
	@Test
	public void testFahrenheitGetValue () 
	{
		testingValue = 200;
		testingUnit = Temperature.Units.FAHRENHEIT;
		testTemp = new Temperature (testingValue, testingUnit);
		valueResulted = testTemp.getValue ();
		assertEquals (testingValue, valueResulted, PRECISION_ERROR);
	}
	@Test
	public void testKelvinGetValue () 
	{
		testingValue = 200;
		testingUnit = Temperature.Units.KELVIN;
		testTemp = new Temperature (testingValue, testingUnit);
		valueResulted = testTemp.getValue ();
		assertEquals (testingValue, valueResulted, PRECISION_ERROR);
	}
	// there still needs to be tests for negative values, zeros, and decimal values
	@Test
	public void testZeroGetValue() 
	{
		testingValue =0;
		testingUnit = Temperature.Units.KELVIN;
		testTemp= new Temperature(testingValue, testingUnit);
		valueResulted= testTemp.getValue();
		assertEquals (testingValue,valueResulted,PRECISION_ERROR);
	}
	@Test
	public void testNegativeGetValue()
	{
		testingValue= -200;
		testingUnit =Temperature.Units.KELVIN;
		testTemp= new Temperature(testingValue,testingUnit);
		valueResulted= testTemp.getValue();
		assertEquals (testingValue,valueResulted,PRECISION_ERROR);
	
	}
	@Test
	public void testDecimalsGetValue()
	{
		testingValue= 12.3456;
		testingUnit =Temperature.Units.CELSIUS;
		testTemp= new Temperature(testingValue,testingUnit);
		valueResulted= testTemp.getValue();
		assertEquals (testingValue,valueResulted,PRECISION_ERROR);
	}
	@Test
	public void testNegDecimalsGetValue()
	{
		testingValue= -12.3456;
		testingUnit =Temperature.Units.CELSIUS;
		testTemp= new Temperature(testingValue,testingUnit);
		valueResulted= testTemp.getValue();
		assertEquals (testingValue,valueResulted,PRECISION_ERROR);
	}
	
	/*
	 * Second test getUnit for each unit in temperature
	 */
	@Test
	public void testCelsiusGetUnit ()
	{
		testingValue =200;
		testingUnit =Temperature.Units.CELSIUS;
		testTemp= new Temperature (testingValue, testingUnit);
		unitResulted=testTemp.getUnits();
		assertEquals(testingUnit,unitResulted); 
	}
	@Test
	public void testKelvinGetUnit ()
	{
		testingValue =200;
		testingUnit =Temperature.Units.KELVIN;
		testTemp= new Temperature (testingValue, testingUnit);
		unitResulted=testTemp.getUnits();
		assertEquals(testingUnit,unitResulted); 
	}
	@Test
	public void testFahrenheitGetUnit ()
	{
		testingValue =200;
		testingUnit =Temperature.Units.FAHRENHEIT;
		testTemp= new Temperature (testingValue, testingUnit);
		unitResulted=testTemp.getUnits();
		assertEquals(testingUnit,unitResulted); 
	}
	//checking for getUnit with negatives
	@Test
	public void testNegCelsiusGetUnit ()
	{
		testingValue = -200;
		testingUnit =Temperature.Units.CELSIUS;
		testTemp= new Temperature (testingValue, testingUnit);
		unitResulted=testTemp.getUnits();
		assertEquals(testingUnit,unitResulted); 
	}
	@Test
	public void testNegKelvinGetUnit ()
	{
		testingValue = -200;
		testingUnit =Temperature.Units.KELVIN;
		testTemp= new Temperature (testingValue, testingUnit);
		unitResulted=testTemp.getUnits();
		assertEquals(testingUnit,unitResulted); 
	}
	@Test
	public void testNegFahrenheitGetUnit ()
	{
		testingValue = -200;
		testingUnit =Temperature.Units.FAHRENHEIT;
		testTemp= new Temperature (testingValue, testingUnit);
		unitResulted=testTemp.getUnits();
		assertEquals(testingUnit,unitResulted); 
	}
	/*
	 * now we test the convertors with different conversion combinations
	 * each method for each conversion tries different values including:
	 * normal in range value,zero,negative,decimals,and negative decimals, so
	 * that values from different boundries are tested 
	 */
	@Test
	public void testChangeUnitsCtoK()//[K] = [°C] + 273.15
	{
		//normal value
		testTemp=new Temperature(200,Temperature.Units.CELSIUS);
		testConvUnit=Temperature.Units.KELVIN;
		testTemp.changeUnits(testConvUnit);
		valueResulted=testTemp.getValue();
		expectedConvertedValue= 473.15;
		assertEquals(expectedConvertedValue,valueResulted,PRECISION_ERROR);
		//zero value
		testTemp=new Temperature(0,Temperature.Units.CELSIUS);
		testConvUnit=Temperature.Units.KELVIN;
		testTemp.changeUnits(testConvUnit);
		valueResulted=testTemp.getValue();
		expectedConvertedValue= 273.15;
		assertEquals(expectedConvertedValue,valueResulted,PRECISION_ERROR);
		//negative value
		testTemp=new Temperature(-200,Temperature.Units.CELSIUS);
		testConvUnit=Temperature.Units.KELVIN;
		testTemp.changeUnits(testConvUnit);
		valueResulted=testTemp.getValue();
		expectedConvertedValue= 73.15;
		assertEquals(expectedConvertedValue,valueResulted,PRECISION_ERROR);
		//decimal value
		testTemp=new Temperature(12.3456,Temperature.Units.CELSIUS);
		testConvUnit=Temperature.Units.KELVIN;
		testTemp.changeUnits(testConvUnit);
		valueResulted=testTemp.getValue();
		expectedConvertedValue= 285.4956;
		assertEquals(expectedConvertedValue,valueResulted,PRECISION_ERROR);
		//negative decimal value
		testTemp=new Temperature(-12.3456,Temperature.Units.CELSIUS);
		testConvUnit=Temperature.Units.KELVIN;
		testTemp.changeUnits(testConvUnit);
		valueResulted=testTemp.getValue();
		expectedConvertedValue= 260.8044;
		assertEquals(expectedConvertedValue,valueResulted,PRECISION_ERROR);
		
		
	}
	@Test
	public void testChangeUnitsKtoC()//[°C] = [K] - 273.15
	{
		//normal in range value
		testTemp=new Temperature(200,Temperature.Units.KELVIN);
		testConvUnit=Temperature.Units.CELSIUS;
		testTemp.changeUnits(testConvUnit);
		valueResulted=testTemp.getValue();
		expectedConvertedValue= -73.15;
		assertEquals(expectedConvertedValue,valueResulted,PRECISION_ERROR);
		//zero value
		testTemp=new Temperature(0,Temperature.Units.KELVIN);
		testConvUnit=Temperature.Units.CELSIUS;
		testTemp.changeUnits(testConvUnit);
		valueResulted=testTemp.getValue();
		expectedConvertedValue= -273.15;
		assertEquals(expectedConvertedValue,valueResulted,PRECISION_ERROR);
		//negative value
		testTemp=new Temperature(-200,Temperature.Units.KELVIN);
		testConvUnit=Temperature.Units.CELSIUS;
		testTemp.changeUnits(testConvUnit);
		valueResulted=testTemp.getValue();
		expectedConvertedValue= -473.15;
		assertEquals(expectedConvertedValue,valueResulted,PRECISION_ERROR);
		//decimal value
		testTemp=new Temperature(12.3456,Temperature.Units.KELVIN);
		testConvUnit=Temperature.Units.CELSIUS;
		testTemp.changeUnits(testConvUnit);
		valueResulted=testTemp.getValue();
		expectedConvertedValue= -260.8044;
		assertEquals(expectedConvertedValue,valueResulted,PRECISION_ERROR);
		//negative decimal value
		testTemp=new Temperature(-12.3456,Temperature.Units.KELVIN);
		testConvUnit=Temperature.Units.CELSIUS;
		testTemp.changeUnits(testConvUnit);
		valueResulted=testTemp.getValue();
		expectedConvertedValue= -285.4956;
		assertEquals(expectedConvertedValue,valueResulted,PRECISION_ERROR);
	}
	@Test
	//[°F] = [°C] × (9/5) + 32
	public void testChangeUnitsCtoF()
	{
		//normal in range value
		testTemp=new Temperature(200,Temperature.Units.CELSIUS);
		testConvUnit=Temperature.Units.FAHRENHEIT;
		testTemp.changeUnits(testConvUnit);
		valueResulted=testTemp.getValue();
		expectedConvertedValue= ((((200)*(9))/5)+32);
		assertEquals(expectedConvertedValue,valueResulted,PRECISION_ERROR);
		//zero vallue
		testTemp=new Temperature(0,Temperature.Units.CELSIUS);
		testConvUnit=Temperature.Units.FAHRENHEIT;
		testTemp.changeUnits(testConvUnit);
		valueResulted=testTemp.getValue();
		expectedConvertedValue= ((0*(9/5))+32);
		assertEquals(expectedConvertedValue,valueResulted,PRECISION_ERROR);
		//negative value
		testTemp=new Temperature(-200,Temperature.Units.CELSIUS);
		testConvUnit=Temperature.Units.FAHRENHEIT;
		testTemp.changeUnits(testConvUnit);
		valueResulted=testTemp.getValue();
		expectedConvertedValue= ((((-200)*(9))/5)+32);
		assertEquals(expectedConvertedValue,valueResulted,PRECISION_ERROR);
		//decimal value
		testTemp=new Temperature(12.3456,Temperature.Units.CELSIUS);
		testConvUnit=Temperature.Units.FAHRENHEIT;
		testTemp.changeUnits(testConvUnit);
		valueResulted=testTemp.getValue();
		expectedConvertedValue= ((((12.3456)*(9))/5)+32);
		assertEquals(expectedConvertedValue,valueResulted,PRECISION_ERROR);
		//negative decimal values
		testTemp=new Temperature(-12.3456,Temperature.Units.CELSIUS);
		testConvUnit=Temperature.Units.FAHRENHEIT;
		testTemp.changeUnits(testConvUnit);
		valueResulted=testTemp.getValue();
		expectedConvertedValue= ((((-12.3456)*(9))/5)+32);
		assertEquals(expectedConvertedValue,valueResulted,PRECISION_ERROR);
	}
	@Test
	public void testChangeUnitsFtoC()//[°C] = ([°F] - 32) * 5/9
	{
		//normal in range value
		testTemp=new Temperature(200,Temperature.Units.FAHRENHEIT);
		testConvUnit=Temperature.Units.CELSIUS;
		testTemp.changeUnits(testConvUnit);
		valueResulted=testTemp.getValue();
		expectedConvertedValue= (200-32) * 5.0/9.0;
		assertEquals(expectedConvertedValue,valueResulted,PRECISION_ERROR);
		//zero value
		testTemp=new Temperature(0,Temperature.Units.FAHRENHEIT);
		testConvUnit=Temperature.Units.CELSIUS;
		testTemp.changeUnits(testConvUnit);
		valueResulted=testTemp.getValue();
		expectedConvertedValue= (0-32) * 5.0/9.0;
		assertEquals(expectedConvertedValue,valueResulted,PRECISION_ERROR);
		//negative value
		testTemp=new Temperature(-200,Temperature.Units.FAHRENHEIT);
		testConvUnit=Temperature.Units.CELSIUS;
		testTemp.changeUnits(testConvUnit);
		valueResulted=testTemp.getValue();
		expectedConvertedValue= (-200-32) * 5.0/9.0;
		assertEquals(expectedConvertedValue,valueResulted,PRECISION_ERROR);
		//decimal value
		testTemp=new Temperature(12.3456,Temperature.Units.FAHRENHEIT);
		testConvUnit=Temperature.Units.CELSIUS;
		testTemp.changeUnits(testConvUnit);
		valueResulted=testTemp.getValue();
		expectedConvertedValue= (12.3456-32) * 5.0/9.0;
		assertEquals(expectedConvertedValue,valueResulted,PRECISION_ERROR);
		//negative decimal value
		testTemp=new Temperature(-12.3456,Temperature.Units.FAHRENHEIT);
		testConvUnit=Temperature.Units.CELSIUS;
		testTemp.changeUnits(testConvUnit);
		valueResulted=testTemp.getValue();
		expectedConvertedValue= (-12.3456-32) * 5.0/9.0;
		assertEquals(expectedConvertedValue,valueResulted,PRECISION_ERROR);

	}
	@Test
	public void testChangeUnitsKtoF()//[°F] = [K] * 9/5 - 459.67
	{
		testTemp=new Temperature(200,Temperature.Units.KELVIN);
		testConvUnit=Temperature.Units.FAHRENHEIT;
		testTemp.changeUnits(testConvUnit);
		valueResulted=testTemp.getValue();
		expectedConvertedValue= 200 * 9.0/5.0 - 459.67;
		assertEquals(expectedConvertedValue,valueResulted,PRECISION_ERROR);
		//zero value
		testTemp=new Temperature(0,Temperature.Units.KELVIN);
		testConvUnit=Temperature.Units.FAHRENHEIT;
		testTemp.changeUnits(testConvUnit);
		valueResulted=testTemp.getValue();
		expectedConvertedValue= 0 * 9.0/5.0 - 459.67;
		assertEquals(expectedConvertedValue,valueResulted,PRECISION_ERROR);
		//negative value
		testTemp=new Temperature(-200,Temperature.Units.KELVIN);
		testConvUnit=Temperature.Units.FAHRENHEIT;
		testTemp.changeUnits(testConvUnit);
		valueResulted=testTemp.getValue();
		expectedConvertedValue= -200 * 9.0/5.0 - 459.67;
		assertEquals(expectedConvertedValue,valueResulted,PRECISION_ERROR);
		//decimal value
		testTemp=new Temperature(12.3456,Temperature.Units.KELVIN);
		testConvUnit=Temperature.Units.FAHRENHEIT;
		testTemp.changeUnits(testConvUnit);
		valueResulted=testTemp.getValue();
		expectedConvertedValue= 12.3456 * 9.0/5.0 - 459.67;
		assertEquals(expectedConvertedValue,valueResulted,PRECISION_ERROR);
		//negative decimal value
		testTemp=new Temperature(-12.3456,Temperature.Units.KELVIN);
		testConvUnit=Temperature.Units.FAHRENHEIT;
		testTemp.changeUnits(testConvUnit);
		valueResulted=testTemp.getValue();
		expectedConvertedValue= (-12.3456) * 9.0/5.0 - 459.67;
		assertEquals(expectedConvertedValue,valueResulted,PRECISION_ERROR);

		
	}
	@Test
	public void testChangeUnitsFtoK()//[K] = ([°F] + 459.67) * 5/9
	{
		testTemp=new Temperature(200,Temperature.Units.FAHRENHEIT);
		testConvUnit=Temperature.Units.KELVIN;
		testTemp.changeUnits(testConvUnit);
		valueResulted=testTemp.getValue();
		expectedConvertedValue= (200 + 459.67) * 5.0/9.0;
		assertEquals(expectedConvertedValue,valueResulted,PRECISION_ERROR);
		//zero value
		testTemp=new Temperature(0,Temperature.Units.FAHRENHEIT);
		testConvUnit=Temperature.Units.KELVIN;
		testTemp.changeUnits(testConvUnit);
		valueResulted=testTemp.getValue();
		expectedConvertedValue= (0+ 459.67) * 5.0/9.0;
		assertEquals(expectedConvertedValue,valueResulted,PRECISION_ERROR);
		//negative value
		testTemp=new Temperature(-200,Temperature.Units.FAHRENHEIT);
		testConvUnit=Temperature.Units.KELVIN;
		testTemp.changeUnits(testConvUnit);
		valueResulted=testTemp.getValue();
		expectedConvertedValue= (-200 + 459.67) * 5.0/9.0;
		assertEquals(expectedConvertedValue,valueResulted,PRECISION_ERROR);
		//decimal value
		testTemp=new Temperature(12.3456,Temperature.Units.FAHRENHEIT);
		testConvUnit=Temperature.Units.KELVIN;
		testTemp.changeUnits(testConvUnit);
		valueResulted=testTemp.getValue();
		expectedConvertedValue= (12.3456 + 459.67) * 5.0/9.0;
		assertEquals(expectedConvertedValue,valueResulted,PRECISION_ERROR);
		//negative decimal value
		testTemp=new Temperature(-12.3456,Temperature.Units.FAHRENHEIT);
		testConvUnit=Temperature.Units.KELVIN;
		testTemp.changeUnits(testConvUnit);
		valueResulted=testTemp.getValue();
		expectedConvertedValue= (-12.3456 + 459.67) * 5.0/9.0;
		assertEquals(expectedConvertedValue,valueResulted,PRECISION_ERROR);

		
		
	}
	
}
