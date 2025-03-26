import com.example.apifull_security.entity.Funko;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShowInfoTest {

    @Test
    public void showInfo_Funko_Test() {

        // Preparación
        Funko funko = new Funko();

        // Ejecución
        String testFunko = funko.showInfo("Goku", "Dragon Ball Character", 9.99);

        // Verificación
        String expectedResult = "Funko: Goku, Dragon Ball Character - $ 9.99";
        assertEquals(expectedResult, testFunko);

    }

}