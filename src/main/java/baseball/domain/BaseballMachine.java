package baseball.domain;

import baseball.util.Input;
import static baseball.message.GameMessage.*;

public class BaseballMachine {

    private Computer computer;
    private User user;
    private StrikeModel strikeModel;

    public void prepareGame() {
        this.computer = new Computer();
    }

    public void matchNumber() {
        createUserNumber();
        this.strikeModel = new StrikeModel(user.getUserNumberList(), computer.getComputerNumberList());
    }

    // 스트라이크가 3개일경우 정답 반환
    public boolean checkAnswer() {
        return strikeModel.getStrike() == 3;
    }

    // 볼 스트라이크에 따라 구분하여 힌트 메세지 출력
    private boolean classify(int ball, int strike) {
        if (ball > 0 && strike > 0) {
            System.out.println(ballAndStrikeMessage(ball, strike));
            return false;
        }
        if (ball > 0 && strike == 0) {
            System.out.println(ballMessage(ball));
            return false;
        }
        if (ball == 0 && strike > 0) {
            System.out.println(strikeMessage(strike));
            return strike == 3;
        }
        System.out.println(nothingMessage());
        return false;
    }

    // 유저 일급컬렉션 생성
    private void createUserNumber() {
        this.user = new User(Input.inputUserNumber());
    }

}
