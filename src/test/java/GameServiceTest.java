import com.javarush.dzhalilov.quest.service.GameService;
import com.javarush.dzhalilov.quest.service.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameServiceTest {

    private GameService gameService;

    @BeforeEach
    public void setUp() {
        gameService = new GameService();
    }

    @Test
    public void testChooseAnswer_Win() {
        GameState result = gameService.chooseAnswer(3L, 41L);
        assertTrue(result.isGameOver());
        assertEquals("LOSS", result.getResult());
    }

    @Test
    public void testChooseAnswer_Loss() {
        GameState result= gameService.chooseAnswer(2L, 22L);
        assertTrue(result.isGameOver());
        assertEquals("LOSS", result.getResult());
    }

    @Test
    public void testChooseAnswer_NextQuestion() {
        GameState result = gameService.chooseAnswer(1L, 11L);
        assertFalse(result.isGameOver());
        assertEquals(2L, result.getNextQuestion().getQuestionId());
    }
}