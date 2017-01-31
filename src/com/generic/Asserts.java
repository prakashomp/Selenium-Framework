
package com.generic;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

/**
 * @author omprakash 
 * 		This method contains asserts methods
 * 
 */
public class Asserts {
	private SoftAssert softAssert;
	private StringBuffer verificationErrors;

	public Asserts(Class<?> clazz) {
		softAssert = new SoftAssert();
		verificationErrors = new StringBuffer();
	}

	/**
	 * @author omprakash
	 * @param msg
	 * @param required
	 *            This method is used to display the message to verify true.
	 */
	public void verifyTrue(Boolean required, String msg) {

		softAssert.assertTrue(required, msg);
		if (required == false) {

		}

	}

	/**
	 * @author omprakash
	 * @param elementDefinition
	 * @param elementLocator
	 * @param required
	 * @param pageURL
	 *            This function used to display the message to verify true for
	 *            availability of element
	 */
	public void verifyTrueElementPresent(String elementDefinition,
			String elementLocator, Boolean required, String pageURL) {

		softAssert.assertTrue(required.booleanValue(), elementDefinition);
		if (required == false) {
			

		}
	}

	/**
	 * @author omprakash
	 * @param msg
	 * @param required
	 *            This method used to display the message to verify false.
	 */
	public void verifyFalse(Boolean required, String msg) {

		softAssert.assertFalse(required.booleanValue());
		if (required == true) {
		
		}

	}

	/**
	 * @author omprakash
	 * @param actualText
	 * @param expText
	 * @param failMessage
	 *            This method used to compare the text.
	 */
	public void verifyCompareText(String actualText, String expText,
			String failMessage) {

		softAssert.assertEquals(actualText, expText);
		if (!actualText.equals(expText)) {
		
		}
	}

	/**
	 * @author omprakash
	 * @param actualText
	 * @param expText
	 * @param failMessage
	 * 
	 *            this method used to compare partial text
	 */
	public void verifyComparePartialText(String actualText, String expText,
			String failMessage) {

		softAssert.assertEquals(actualText.toLowerCase().trim(), expText
				.toLowerCase().trim());

		if (!actualText.contains(expText)) {
		
		}
	}

	/**
	 * @author omprakash
	 * @param msg
	 * @param obj1
	 * @param obj2
	 *            This method used to check the objects are equal or not
	 */

	public void verifyNotEquals(Object obj1, Object obj2, String msg) {

		softAssert.assertNotEquals(obj1, obj2);
		if (!obj1.equals(obj2)) {
		
		}
	}

	/**
	 * @author omprakash
	 * @param msg
	 * @param required
	 *            This method used to verify true with hard assert
	 */
	public void assertTrue(Boolean required, String msg) {
		try {
			Assert.assertTrue(required.booleanValue());
		} catch (Exception e) {
			verificationErrors.append(e);
		
		}
	}

	/**
	 * @author omprakash
	 * @param elementDefinition
	 * @param elementLocator
	 * @param required
	 * @param pageURL
	 *            This method used to verify true when element present with hard
	 *            assert
	 */
	public void assertTrueElementPresent(String elementDefinition,
			String elementLocator, Boolean required, String pageURL) {
		try {
			Assert.assertTrue(required.booleanValue());
		} catch (Exception e) {
			verificationErrors.append(e);
		
		}
	}

	/**
	 * @author omprakash
	 * @param msg
	 * @param required
	 *            This Method used to very the false with hard assert
	 */
	public void assertFalse(String msg, Boolean required) {
		try {
			Assert.assertFalse(required.booleanValue());
		} catch (Exception e) {
			verificationErrors.append(e);
		
		}
	}

	/**
	 * @author omprakash
	 * @param actualText
	 * @param expText
	 * @param failMessage
	 * @param required
	 *            This method is used to compare text with hard assert
	 */
	public void assertCompareText(String actualText, String expText,
			String failMessage) {
		{
			try {
				Assert.assertEquals(actualText, expText);
			} catch (Exception e) {
				verificationErrors.append(e);
			
			}
		}
	}

	/**
	 * @author omprakash
	 * @param actualText
	 * @param expText
	 * @param failMessage
	 * @param required
	 *            This method is used to compare the partial text with hard
	 *            assert.
	 */
	public void assertComparePartialText(String actualText, String expText,
			String failMessage, boolean required) {
		try {
			Assert.assertEquals(actualText.toLowerCase().trim(), expText
					.toLowerCase().trim());

		} catch (Exception e) {
			verificationErrors.append(e);
	
		}
	}

	/**
	 * @author omprakash
	 * @param msg
	 * @param obj1
	 * @param obj2
	 *            This method used to verify the object equals with hard assert.
	 */
	public void assertNotEquals(String msg, Object obj1, Object obj2) {
		try {
			Assert.assertNotEquals(obj1, obj2);
		} catch (Error e) {
			verificationErrors.append(e);
		
		}
	}

	/**
	 * @author omprakash
	 * @param obj
	 * @param msg
	 *            This method used to verify the object not null with hard
	 *            assert.
	 */
	public void assertNotNull(Object obj, String msg) {
		try {
			Assert.assertNotNull(obj, msg);
		} catch (Exception e) {
			verificationErrors.append(e);
		
		}
	}

	/**
	 * @author omprakash
	 * @param obj
	 * @param msg
	 *            This method used to verify the object null with hard assert.
	 */
	public void assertNull(Object obj, String msg) {
		try {
			Assert.assertNull(obj, msg);
		} catch (Exception e) {
			verificationErrors.append(e);
		
		}

	}

	/**
	 * This method is used to asset two integer value are equal or not.
	 * 
	 * @author omprakash
	 * @param actual
	 * @param expected
	 * @param msg
	 */
	public void assertEquals(int actual, int expected, String msg) {
		try {
			Assert.assertEquals(actual, expected);
		} catch (Exception e) {
			verificationErrors.append(e);
		
		}
	}

	/**
	 * This method is used to asset two integer value are equal or not.
	 * 
	 * @author omprakash
	 * @param actual
	 * @param expected
	 * @param msg
	 */
	public void assertNotEquals(int actual, int expected, String msg) {
		try {
			Assert.assertNotEquals(actual, expected);
		} catch (Exception e) {
			verificationErrors.append(e);
		
		}
	}

	public void clearVerificationErrors() {
		verificationErrors = new StringBuffer();
	}

	/**
	 * This method is used to check are null or not.
	 * 
	 * @author omprakash
	 * @param msg
	 * @param obj
	 */
	public void verifyNotNull(Object obj, String msg) {
		softAssert.assertNotNull(obj, msg);
		if (obj == null) {
		
		}
	}

	/**
	 * This method is used to verify two double values are equal or not.
	 * 
	 * @author omprakash
	 * @param actual
	 * @param expected
	 * @param msg
	 */
	public void verifyEquals(double actual, double expected, String msg) {
		softAssert.assertEquals(actual, expected);
		if (actual != expected) {
		
		}
	}

	/**
	 * This method is used to check are null or not.
	 * 
	 * @author omprakash
	 * @param msg
	 * @param obj
	 */
	public void verifyNull(Object obj, String msg) {
		softAssert.assertNull(obj, msg);
		if (obj != null) {
		
		}
	}

}
