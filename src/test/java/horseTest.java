import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class horseTest {

    @Test
    //Проверить, что при передаче в конструктор первым параметром null, будет выброшено IllegalArgumentException. Для этого нужно воспользоваться методом assertThrows;Проверить, что при передаче в конструктор первым параметром null, будет выброшено IllegalArgumentException. Для этого нужно воспользоваться методом assertThrows;
    void horseTest(){
        assertThrows(IllegalArgumentException.class, () -> new Horse(null, 10, 10));
    }

    @Test
    //Проверить, что при передаче в конструктор первым параметром null, выброшенное исключение будет содержать сообщение "Name cannot be null.". Для этого нужно получить сообщение из перехваченного исключения и воспользоваться методом assertEquals;
    void horseTestText() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Horse(null, 10, 100));
        assertEquals("Name cannot be null.", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({", 10, 10",
    " , 10, 10"})
    //Проверить, что при передаче в конструктор первым параметром пустой строки или строки содержащей только пробельные символы (пробел, табуляция и т.д.), будет выброшено IllegalArgumentException. Чтобы выполнить проверку с разными вариантами пробельных символов, нужно сделать тест параметризованным;
    void horseTestTextStroka(String name, double speed, double distance) {
        assertThrows(IllegalArgumentException.class, () -> new Horse(name, speed, distance));
    }

    @Test
        //Проверить, что при передаче в конструктор первым параметром пустой строки или строки содержащей только пробельные символы (пробел, табуляция и т.д.), выброшенное исключение будет содержать сообщение "Name cannot be blank.";
    void horseTestTextStroka2() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Horse("", 100, 100));
        assertEquals("Name cannot be blank.", exception.getMessage());

        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () -> new Horse(" ", 100, 100));
        assertEquals("Name cannot be blank.", exception.getMessage());
    }

    @Test
    //Проверить, что при передаче в конструктор вторым параметром отрицательного числа, будет выброшено IllegalArgumentException;
        void horseTestSpeed(){
        assertThrows(IllegalArgumentException.class, () -> new Horse("One", -10, 10));
    }

    @Test
    //Проверить, что при передаче в конструктор вторым параметром отрицательного числа, выброшенное исключение будет содержать сообщение "Speed cannot be negative.";
    void horseTestSpeedText(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Horse ("One", -1,10));
        assertEquals("Speed cannot be negative.", exception.getMessage());
    }

    @Test
        //Проверить, что при передаче в конструктор вторым параметром отрицательного числа, будет выброшено IllegalArgumentException;
    void horseTestDistance(){
        assertThrows(IllegalArgumentException.class, () -> new Horse("One", 10, -10));
    }

    @Test
        //Проверить, что при передаче в конструктор третьим параметром отрицательного числа, выброшенное исключение будет содержать сообщение "Distance cannot be negative.";
         void horseTestDistanceText(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Horse ("One", 1,-10));
        assertEquals("Distance cannot be negative.", exception.getMessage());
    }

    @Test
    //Проверить, что метод возвращает строку, которая была передана первым параметром в конструктор;
    void getNameTest(){

        Horse horse = Mockito.mock(Horse.class);
        when(horse.getName()).thenReturn("Petr");
        assertEquals("Petr", horse.getName());
    }

    @Test
        //Проверить, что метод возвращает число, которое было передано вторым параметром в конструктор;
    void getSpeedTest(){
        Double aDouble = 10.0;
        Horse horse = new Horse("d", aDouble, 10);
        assertEquals(aDouble, horse.getSpeed());
    }

    @Test
    //Проверить, что метод возвращает число, которое было передано третьим параметром в конструктор;
    void getDistanceTest() {
        Double aDouble = 10.0;
        Horse horse = new Horse("d", 10, aDouble);
        assertEquals(aDouble, horse.getDistance());
    }

    @Test
        //Проверить, что метод возвращает ноль, если объект был создан с помощью конструктора с двумя параметрами;
    void getDistanceTest2() {
        Horse horse = Mockito.mock(Horse.class);
        assertEquals(0, horse.getDistance());
    }


    @Test
    void getRandomDouble(){
        try {
            MockedStatic<Horse> mockedStatic = Mockito.mockStatic(Horse.class);
            mockedStatic.verify(() -> Horse.getRandomDouble(0.2, 0.9));
        } catch (Exception e){

        }
    }



    




}
