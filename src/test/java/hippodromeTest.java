import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class hippodromeTest {

    @Mock
    Hippodrome hippodrome;

    @BeforeEach
    void setup () {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    void hippodromeTest () {

        Mockito.when(hippodrome.getHorses()).thenThrow(IllegalArgumentException.class);
        assertThrows(IllegalArgumentException.class, () -> hippodrome.getHorses());
    }

    @Test
    void hippodromeTest2 () {

        try {
            when(hippodrome.getHorses()).thenThrow(IllegalArgumentException.class);
            assertThrows(IllegalArgumentException.class, () -> hippodrome.getHorses());
        } catch (IllegalArgumentException ex) {
            assertEquals("Horses cannot be null.", ex.getMessage());
        }
    }

    @Test
    //Проверить, что при передаче в конструктор пустого списка, будет выброшено IllegalArgumentException;
    void hippodromeListTest () {
        assertThrows(IllegalArgumentException.class, () -> new Hippodrome(Collections.emptyList()));
    }

    @Test
        //Проверить, что при передаче в конструктор пустого списка, выброшенное исключение будет содержать сообщение "Horses cannot be empty.";
    void hippodromeListTest2 () {
       IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(Collections.emptyList()));
       assertEquals("Horses cannot be empty.", exception.getMessage());
    }


    @Test
    void  hippodromeHorseTest (){
        List <Horse> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(new Horse("Horse" + (i + 1), Math.random()*30) );
        }

        Hippodrome hippodrome = new Hippodrome(list);
        List<Horse> horse = hippodrome.getHorses();
        assertEquals(list, horse);

        for (int i = 0; i < horse.size(); i++) {
            assertTrue(list.get(i) == horse.get(i));
        }

    }

    @Test
    void  hippodromeHorseMoveTest() {
        List <Horse> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Horse mockHorse = mock(Horse.class);
            list.add(mockHorse);
        }

        Hippodrome hippodrome1 = new Hippodrome(list);
        hippodrome1.move();

        for (Horse mockHorse : list) {
            verify(mockHorse, times(1)).move();
        }
    }
    @Test
    void hippodromeHorseDistanceTest(){
        Horse horse1 = new Horse("1", 10, 1);
        Horse horse2 = new Horse("2", 15, 2);
        Horse horse3 = new Horse("3", 20,3);

        List<Horse> horses = new ArrayList<>();
        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);

        Hippodrome hippodrome = new Hippodrome(horses);

        Horse winner = hippodrome.getWinner();

        assertSame(horse3, winner);

    }




}
