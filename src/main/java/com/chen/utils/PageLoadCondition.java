package com.chen.utils;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageLoadCondition {
	public static ExpectedCondition<WebElement> presenceOfElementLocated(
			final By locator) {
		return new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver driver) {
				return findElement(locator, driver);
			}

			@Override
			public String toString() {
				return "presence of element located by: " + locator;
			}
		};
	}

	public static void wait(WebDriver driver, long timeout, By by) {
		try {
			new WebDriverWait(driver, timeout).until(PageLoadCondition
					.presenceOfElementLocated(by));
		} catch (Exception e) {
		}
	}

	public static void waitVisibility(WebDriver driver, long timeout, By by) {
		try {
			new WebDriverWait(driver, timeout).until(ExpectedConditions
					.visibilityOfElementLocated(by));
		} catch (Exception e) {
		}
	}

	public static void waitVisibilityValue(WebDriver driver, long timeout, By by) {
		for (int i = 0; i < timeout; i++) {
			try {
				new WebDriverWait(driver, 1).until(ExpectedConditions
						.visibilityOfElementLocated(by));
				if (StringUtils.isNotBlank(driver.findElement(by).getText())
						|| StringUtils.isNotBlank(driver.findElement(by)
								.getAttribute("value"))) {
					return;
				}
			} catch (Exception e) {
			}
		}
	}

	private static WebElement findElement(By by, WebDriver driver) {
		try {
			return driver.findElement(by);
		} catch (Exception e) {
		}
		return null;
	}

	public static boolean ifExits(WebDriver driver, By by) {
		boolean status = false;
		try {
			driver.findElement(by);
			status = true;
		} catch (Exception e) {
			status = false;
		}
		return status;
	}

	/**
	 * 切换到新窗口 最后一个窗口
	 * @param driver
	 */
	public static void swithToNewWindow(WebDriver driver) {
		String winHandleBefore = driver.getWindowHandle();
		// 切换到新窗口
		for (String winHandle : driver.getWindowHandles()) {
			if (!winHandle.equals(winHandleBefore)) {
				driver.switchTo().window(winHandle);
			}
		}
	}

	/**
	 * 关闭当前窗口
	 * @param driver
	 */
	public static void closeCurrentWindow(WebDriver driver) {
		String winHandleBefore = driver.getWindowHandle();
		driver.switchTo().window(winHandleBefore).close();;
	}
	
	/**
	 * 切换窗口 最后一个窗口
	 * @param driver
	 */
	public static void swithToWindow(WebDriver driver) {
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		} 
	}
}
