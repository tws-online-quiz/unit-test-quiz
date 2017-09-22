/*
 * This Java source file was generated by the Gradle 'init' task.
 */

import org.junit.Before;
import org.junit.Test;
import tw.core.Answer;
import tw.core.Game;
import tw.core.generator.AnswerGenerator;
import tw.core.model.GuessResult;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTest {


    private final Answer actualAnswer = Answer.createAnswer("1 2 3 4");
    private Game game;

    @Before
    public void setUp() throws Exception {
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(actualAnswer);
        game = new Game(answerGenerator);
    }


    @Test
    public void should_return_0A0B_when_no_number_is_correct() {
        //when
        String inputAnswerStr = "5 6 7 8";
        String expectValue = "0A0B";
        //then
        validateGuessNumber(inputAnswerStr, expectValue);
    }

    @Test
    public void should_return_1A0B_when_1_is_correct() {
        //given
        String inputAnswerStr = "1 5 6 7";
        String expectValue = "1A0B";

        //then
        validateGuessNumber(inputAnswerStr, expectValue);
    }

    @Test
    public void should_return_0A2B_when_2_and_4_are_include() {
        //when
        String inputAnswerStr = "2 4 7 8";
        String expectValue = "0A2B";
        //then
        validateGuessNumber(inputAnswerStr, expectValue);
    }


    @Test
    public void should_return_2A2B_when_1_3_are_correct_and_4_2_are_include() {
        //when
        String inputAnswerStr = "1 4 3 2";
        String expectValue = "2A2B";
        //then
        validateGuessNumber(inputAnswerStr, expectValue);
    }

    @Test
    public void should_get_record_of_every_guess_result_when_call_guessHistory() {
        game.guess(Answer.createAnswer("2 1 6 7"));
        game.guess(Answer.createAnswer("1 2 3 4"));

        List<GuessResult> guessResults = game.guessHistory();

        assertThat(guessResults.size(), is(2));
        assertThat(guessResults.get(0).getResult(), is("0A2B"));
        assertThat(guessResults.get(0).getInputAnswer().toString(), is("2 1 6 7"));

        assertThat(guessResults.get(1).getResult(), is("4A0B"));
        assertThat(guessResults.get(1).getInputAnswer().toString(), is("1 2 3 4"));
    }

    @Test
    public void should_get_the_success_status_when_guess_input_is_correct() throws Exception {

        //given
        excuteSuccessGuess();
        //when
        String statusOfGame = game.checkStatus();
        //then
        assertThat(statusOfGame, is("success"));

    }


    @Test
    public void should_get_the_fail_status_when_guess_action_count_over_or_equal_6() throws Exception {

        //given
        excuteSixErrorGuess();
        //when
        String statusOfGame = game.checkStatus();
        //then
        assertThat(statusOfGame, is("fail"));

    }

    @Test
    public void should_get_the_continue_status_when_guess_action_count_less_than_6() throws Exception {

        //given
        excuteErrorGuessLessThanSixTimes();
        //when
        String statusOfGame = game.checkStatus();
        //then
        assertThat(statusOfGame, is("continue"));

    }

    @Test
    public void should_get_ture_when_incorrect_guess_action_number_less_than_6() throws Exception {
        //given
        game.guess(Answer.createAnswer("2 1 9 3"));
        //when
        Boolean isContinue = game.checkCoutinue();
        //then
        assertThat(isContinue, is(true));

    }

    @Test
    public void should_get_ture_when_incorrect_guess_action_number_over_or_equal_6() throws Exception {
        //given
        excuteSixErrorGuess();
        //when
        Boolean isContinue = game.checkCoutinue();
        //then
        assertThat(isContinue, is(false));

    }

    @Test
    public void should_get_false_when_correct_guess() throws Exception {
        //given
        excuteSuccessGuess();
        //when
        Boolean isContinue = game.checkCoutinue();
        //then
        assertThat(isContinue, is(false));

    }

    private void excuteSuccessGuess() {
        game.guess(Answer.createAnswer("5 2 7 4"));
        game.guess(Answer.createAnswer("1 2 3 4"));
    }

    private void excuteErrorGuessLessThanSixTimes() {
        game.guess(Answer.createAnswer("2 7 3 4"));
        game.guess(Answer.createAnswer("1 5 3 4"));
        game.guess(Answer.createAnswer("1 8 2 1"));
    }

    private void excuteSixErrorGuess() {
        game.guess(Answer.createAnswer("2 9 3 4"));
        game.guess(Answer.createAnswer("1 5 3 4"));
        game.guess(Answer.createAnswer("1 8 2 1"));
        game.guess(Answer.createAnswer("1 2 3 9"));
        game.guess(Answer.createAnswer("4 3 2 1"));
        game.guess(Answer.createAnswer("1 5 6 4"));
    }

    private void validateGuessNumber(String inputAnswerStr, String expectValue) {
        Answer inputAnswer = Answer.createAnswer(inputAnswerStr);

        //when
        GuessResult result = game.guess(inputAnswer);

        //then
        assertThat(result.getResult(), is(expectValue));
    }
}
