package ru.yandex.practicum.tests;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import ru.yandex.practicum.page.MainPage;
import ru.yandex.practicum.page.StatusPage;

//обьявили класс
public class ScooterTests {
    // (обьявляем driver полем класса) заменили на инициализацию фабрики добавили анотацию правило
    @Rule
    public DriverFactory factory=new DriverFactory();

    //создаем тест проверки номер заказа не найден
    @Test
    public void testNonExistingOrderNotFound() {

        //получаем драйвер через геттер с фабрики
        WebDriver driver= factory.getDriver();

        //для работы пейджы ей нужен свой драйвер
        var mainPage=new MainPage(driver);

//открываем главную страницу
        mainPage.openMainPage();

//находим и кликаем на кнопку статус заказа
        mainPage.clickOnStatusButton();

//находим и вводим поле поиска заказа
        mainPage.enterOrderIn("321");

// нажать на кнопку Go
        StatusPage statusPage=mainPage.clickOnGoButton();

// проверка выпадающей картинки ошибки
        statusPage.checkErrorImage();
    }
}
