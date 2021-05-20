package task1;

import lombok.extern.slf4j.Slf4j;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import ru.geekbrains.homeworks.task1.Main;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Slf4j
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
            
            log.info(builder.toString());
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
    
    /* checkIfSumBelongsToInterval */
    
    @Test
    public void when_BordersAreIncorrect_Expect_Exception() {
        int a = 12, b = 122, leftBorder = 100, rightBorder = 1;
        
        assertThatThrownBy(() -> {
            log.info("Checking for exception:");
            Main.checkIfSumBelongsToInterval(a, b, leftBorder, rightBorder);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Interval boundaries are incorrect!");
    }
    
    @Test
    public void when_SumBelongsToInterval_Expect_True() {
        int a = 12, b = 122, leftBorder = 1, rightBorder = 200;
        String expectedResult = "true";
        
        log.info("Checking that the sum belongs to the interval:");
        assertThat(Main.checkIfSumBelongsToInterval(a, b, leftBorder, rightBorder)).isEqualTo(expectedResult);
    }
    
    @Test
    public void when_SumNotBelongsToInterval_Expect_False() {
        int a = 12, b = 122, leftBorder = 1, rightBorder = 100;
        String expectedResult = "false";
    
        log.info("Checking that the sum doesn't belong to the interval:");
        assertThat(Main.checkIfSumBelongsToInterval(a, b, leftBorder, rightBorder)).isEqualTo(expectedResult);
    }
    
    /* checkNumberSign */
    
    @Test
    public void checkNumberSign_NumberSignPositive_Equal() {
        int number = 12;
        String expectedResult = "positive";
        
        log.info("Checking for positive sign:");
        assertThat(Main.checkNumberSign(number)).isEqualTo(expectedResult);
    }
    
    @Test
    public void checkNumberSign_NumberSignNegative_Equal() {
        int number = -12;
        String expectedResult = "negative";
        
        log.info("Checking for negative sign:");
        assertThat(Main.checkNumberSign(number)).isEqualTo(expectedResult);
    }
    
    @Test
    public void checkNumberSign_NumberSignAbsent_Equal() {
        int number = 0;
        String expectedResult = "zero";
        
        log.info("Checking for zero:");
        assertThat(Main.checkNumberSign(number)).isEqualTo(expectedResult);
    }
    
    /* isNumberNegative */
    
    @Test
    public void isNumberNegative_NumberSignNegative_Equal() {
        int number = -10;
        String expectedResult = "true";
        
        log.info("Checking for negative:");
        assertThat(Main.isNumberNegative(number)).isEqualTo(expectedResult);
    }
    
    @Test
    public void isNumberNegative_NumberSignPositive_Equal() {
        int number = 10;
        String expectedResult = "false";
        
        log.info("Checking for positive:");
        assertThat(Main.isNumberNegative(number)).isEqualTo(expectedResult);
    }
    
    /* repeatNumberTimes */
    
    @Test
    public void when_NumberOfRepetitionsAreIncorrect_Expect_Exception() {
        String str = "test";
        int number = 0;
        
        assertThatThrownBy(() -> {
            log.info("Checking for exception:");
            Main.repeatNumberTimes(str, number);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Number of repetitions is incorrect!");
    }
    
    @Test
    public void repeatNumberTimes_Repeat4Times_Equal() {
        String str = "Test";
        int number = 4;
        String expectedResult = "TestTestTestTest";
        
        log.info("Checking for equality:");
        assertThat(Main.repeatNumberTimes(str, number)).isEqualTo(expectedResult);
    }
    
    @Test
    public void repeatNumberTimes_Repeat4Times_NotEqual() {
        String str = "Test";
        int number = 4;
        String expectedResult = "TestTestTest";
        
        log.info("Checking for equality:");
        assertThat(Main.repeatNumberTimes(str, number)).isNotEqualTo(expectedResult);
    }
    
    /* isLeapYear */
    
    @Test
    public void when_YearIsIncorrect_Expect_Exception() {
        int year = 0;
        
        assertThatThrownBy(() -> {
            log.info("Checking for exception:");
            Main.isLeapYear(year);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Year is incorrect!");
    }
    
    @Test
    public void isLeapYear_YearNotMultipleOf4_Equal() {
        int year = 1;
        String expectedResult = "не високосный";
        
        log.info("Checking for a non-leap year:");
        assertThat(Main.isLeapYear(year)).isEqualTo(expectedResult);
    }
    
    @Test
    public void isLeapYear_YearMultipleOf4_Equal() {
        int year = 2004;
        String expectedResult = "високосный";
        
        log.info("Checking for a leap year:");
        assertThat(Main.isLeapYear(year)).isEqualTo(expectedResult);
    }
    
    @Test
    public void isLeapYear_YearMultipleOf100_Equal() {
        int year = 1900;
        String expectedResult = "не високосный";
        
        log.info("Checking for a non-leap year:");
        assertThat(Main.isLeapYear(year)).isEqualTo(expectedResult);
    }
    
    @Test
    public void isLeapYear_YearMultipleOf400_Equal() {
        int year = 2000;
        String expectedResult = "високосный";
        
        log.info("Checking for a leap year:");
        assertThat(Main.isLeapYear(year)).isEqualTo(expectedResult);
    }
    
    /* **************************************************  *******  ************************************************* */
    /* *************************************************** /TESTS/ ************************************************** */
    /* **************************************************  *******  ************************************************* */
}
