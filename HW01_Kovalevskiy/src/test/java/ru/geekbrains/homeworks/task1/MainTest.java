package ru.geekbrains.homeworks.task1;

import lombok.extern.log4j.Log4j;
import org.junit.*;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j
public class MainTest {
    
    @Rule
    public TestWatcher watchman = new TestWatcher() {
        
        @Override
        protected void starting(Description description) {
            log.info("[ " + description + " ]");
        }
        
        @Override
        protected void failed(Throwable e, Description description) {
            StringBuilder builder = new StringBuilder();
            
            builder.append("[ NOK ] failed!");
            
            if (e != null) {
                builder.append(' ').append(e);
            }
            
            log.info(builder);
            log.info("");
        }
        
        @Override
        protected void succeeded(Description description) {
            log.info("[ OK ] succeeded!");
            log.info("");
        }
    };
    
    @BeforeClass
    public static void setUpBeforeClass() {
        log.info("All unit tests were started...");
        log.info("");
    }
    
    @AfterClass
    public static void tearDownAfterClass() {
        log.info("All unit tests were finished!\n");
    }
    
    /* **************************************************  *******  ************************************************* */
    /* *************************************************** -TESTS- ************************************************** */
    /* **************************************************  *******  ************************************************* */
    
    /* checkSumSign */
    
    @Test
    public void checkSumSign_SumMoreThan0_Equal() {
        int a = 12, b = 122;
        String expectedResult = "Сумма положительная";
        
        log.info("Checking for positive sign:");
        assertThat(Main.checkSumSign(a, b)).isEqualTo(expectedResult);
    }
    
    @Test
    public void checkSumSign_SumLessThan0_Equal() {
        int a = 12, b = -122;
        String expectedResult = "Сумма отрицательная";
    
        log.info("Checking for negative sign:");
        assertThat(Main.checkSumSign(a, b)).isEqualTo(expectedResult);
    }
    
    @Test
    public void checkSumSign_SumLessThan0_NotEqual() {
        int a = 12, b = 122;
        String expectedResult = "Сумма отрицательная";
        
        log.info("Checking for positive sign:");
        assertThat(Main.checkSumSign(a, b)).isNotEqualTo(expectedResult);
    }
    
    /* getColor */
    
    @Test
    public void getColor_NumberLessThan0_Equal() {
        int number = -12;
        String expectedResult = "Красный";
        
        log.info("Checking for red color:");
        assertThat(Main.getColor(number, true)).isEqualTo(expectedResult);
    }
    
    @Test
    public void getColor_NumberLessThan0_NotEqual() {
        int number = -12;
        String expectedResult = "Белый";
        
        log.info("Checking for red color:");
        assertThat(Main.getColor(number, true)).isNotEqualTo(expectedResult);
    }
    
    @Test
    public void getColor_NumberBeteeen0And100Than_Equal() {
        int number = 12;
        String expectedResult = "Желтый";
        
        log.info("Checking for yellow color:");
        assertThat(Main.getColor(number, true)).isEqualTo(expectedResult);
    }
    
    @Test
    public void getColor_NumberBeteeen0And100Than_NotEqual() {
        int number = 12;
        String expectedResult = "Белый";
        
        log.info("Checking for yellow color:");
        assertThat(Main.getColor(number, true)).isNotEqualTo(expectedResult);
    }
    
    @Test
    public void getColor_NumberMoreThan100_Equal() {
        int number = 120;
        String expectedResult = "Зеленый";
        
        log.info("Checking for green color:");
        assertThat(Main.getColor(number, true)).isEqualTo(expectedResult);
    }
    
    @Test
    public void getColor_NumberMoreThan100_NotEqual() {
        int number = 120;
        String expectedResult = "Белый";
        
        log.info("Checking for green color:");
        assertThat(Main.getColor(number, true)).isNotEqualTo(expectedResult);
    }
    
    /* compareNumbers */
    
    @Test
    public void compareNumbers_FirstNumberIsMoreThanSecondNumber_True() {
        int a = 122, b = 12;
        String expectedResult = "a >= b";
    
        log.info("Checking for >= :");
        assertThat(Main.compareNumbers(a, b)).isEqualTo(expectedResult);
    }
    
    @Test
    public void compareNumbers_FirstNumberIsMoreThanSecondNumber_False() {
        int a = 12, b = 120;
        String expectedResult = "a >= b";
        
        log.info("Checking for < :");
        assertThat(Main.compareNumbers(a, b)).isNotEqualTo(expectedResult);
    }
    
    @Test
    public void compareNumbers_FirstNumberIsLessThanSecondNumber_True() {
        int a = 12, b = 120;
        String expectedResult = "a < b";
        
        log.info("Checking for < :");
        assertThat(Main.compareNumbers(a, b)).isEqualTo(expectedResult);
    }
    
    @Test
    public void compareNumbers_FirstNumberIsLessThanSecondNumber_False() {
        int a = 12, b = 1;
        String expectedResult = "a < b";
        
        log.info("Checking for >= :");
        assertThat(Main.compareNumbers(a, b)).isNotEqualTo(expectedResult);
    }
    
    /* **************************************************  *******  ************************************************* */
    /* *************************************************** /TESTS/ ************************************************** */
    /* **************************************************  *******  ************************************************* */
}
