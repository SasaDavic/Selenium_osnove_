package d13_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {

	public static void main(String[] args) throws InterruptedException {
	/*
	 * Napisati program koji vrsi dodavanje 5 reda u tabelu. 
Maksimizirati prozor
Ucitati stranicu https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php
Dodati 5 redova sa istim podacima.Jedan red u jednoj iteraciji 
Klik na dugme Add New
Unesite name,departmant i phone (uvek iste vrednost)
Trazenje po name atributu
Kliknite na zeleno Add dugme. 
PAZNJA: Pogledajte strukturu stranice i videcete da se u svakom redu poslednje kolone javljaju dugmici edit, add, delete ali zbog prirode reda neki dugmici se vide a neki ne. 
Morate da dohvatite uvek Add dugme iz poslednjeg reda tabele. Mozete koristeci index iz petlje, a mozete koristeci i last() fukncionalnost za xpath. Koristan link last mehnizma
Cekanje od 0.5s
Na kraju programa ugasite pretrazivac.


	 */
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver1.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php");
		
		for (int i = 0; i < 5; i++) {
			driver.findElement(By.tagName("button")).click();
			driver.findElement(By.name("name")).sendKeys("Milan");
		//	driver.findElement(By.xpath("//tbody/tr[last()]/td/input")).sendKeys("Milan"); - na drugi nacin
			driver.findElement(By.name("department")).sendKeys("Jovanovic");
		//	driver.findElement(By.xpath("//tbody/tr[last()]/td[2]/input")).sendKeys("Jovanovic");
			driver.findElement(By.name("phone")).sendKeys("+381 61 888 999");
		//	driver.findElement(By.xpath("//tbody/tr[last()]/td[3]/input")).sendKeys("+381 61 888 999");
			driver.findElement(By.xpath("//tbody/tr[last()]/td[last()]/a[contains(@class, 'add')]")).click();
		}
		
		Thread.sleep(500);
		driver.quit();

	}

}
