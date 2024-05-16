import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void shouldReturnTrueSymmetricRow() {
        int[] wiersz=new int[]{34,54,54,37};

        boolean wynik=Main.isRowSymmetric(wiersz);
        Assertions.assertFalse(wynik);


    }
}