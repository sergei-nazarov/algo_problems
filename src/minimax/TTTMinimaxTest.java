package minimax;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TTTMinimaxTest {
    public static <T> void assertEquality(T actual, T expected) {
        if (actual.equals(expected)) {
            System.out.println("Passed!");
        } else {
            System.out.println("Failed!");
            System.out.println("Actual: " + actual);
            System.out.println("Expected: " + expected);
        }
    }

    @UnitTest(name = "Easy position")
    public void easyPosition() {
        TTTPiece[] toWinEasy = new TTTPiece[]{
                TTTPiece.X, TTTPiece.O, TTTPiece.X,
                TTTPiece.X, TTTPiece.E, TTTPiece.O,
                TTTPiece.E, TTTPiece.E, TTTPiece.O
        };
        TTTBoard testBoard1 = new TTTBoard(toWinEasy, TTTPiece.X);
        Integer answer1 = Mimimax.findBestMove(testBoard1, 8);
        assertEquality(answer1, 6);
    }

    @UnitTest(name = "Block position")
    public void blockPosition() {
        TTTPiece[] toBlockPosition = new TTTPiece[]{
                TTTPiece.X, TTTPiece.E, TTTPiece.E,
                TTTPiece.E, TTTPiece.E, TTTPiece.O,
                TTTPiece.E, TTTPiece.X, TTTPiece.O
        };
        TTTBoard testBoard2 = new TTTBoard(toBlockPosition, TTTPiece.X);
        Integer answer2 = Mimimax.findBestMove(testBoard2, 8);
        assertEquality(answer2, 2);
    }

    @UnitTest(name = "Hard position")
    public void hardPosition() {
        TTTPiece[] toWinHardPosition = new TTTPiece[]{
                TTTPiece.X, TTTPiece.E, TTTPiece.E,
                TTTPiece.E, TTTPiece.E, TTTPiece.O,
                TTTPiece.O, TTTPiece.X, TTTPiece.E
        };
        TTTBoard testBoard3 = new TTTBoard(toWinHardPosition, TTTPiece.X);
        Integer answer3 = Mimimax.findBestMove(testBoard3, 8);
        assertEquality(answer3, 1);
    }

    @UnitTest(name = "Very hard position")
    public void veryHardPosition() {
        TTTPiece[] toWinVeryHardPosition = new TTTPiece[]{
                TTTPiece.X, TTTPiece.E, TTTPiece.E,
                TTTPiece.O, TTTPiece.E, TTTPiece.O,
                TTTPiece.O, TTTPiece.X, TTTPiece.E
        };
        TTTBoard testBoard4 = new TTTBoard(toWinVeryHardPosition, TTTPiece.X);
        Integer answer4 = Mimimax.findBestMove(testBoard4, 8);
        assertEquality(answer4, 4);
    }

    public void runAllTests() {
        for (Method method : this.getClass().getMethods()) {
            for (UnitTest annotation : method.getAnnotationsByType(UnitTest.class)) {
                System.out.println("Running test " + annotation.name());
                try {
                    method.invoke(this);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("_______________________");
            }
        }
    }

    public static void main(String[] args) {
        new TTTMinimaxTest().runAllTests();
    }
}

@Retention(RetentionPolicy.RUNTIME)
@interface UnitTest {
    String name() default "";
}