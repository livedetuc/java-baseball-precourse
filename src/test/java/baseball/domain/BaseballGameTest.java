package baseball.domain;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import baseball.Application;
import nextstep.test.NSTest;
import nextstep.utils.Randoms;

public class BaseballGameTest extends NSTest {
    @BeforeEach
    void beforeEach() {
        super.setUp();
    }

    @Test
    void 사용자_입력_받기_및_검증1() {
        BaseballGame game = new BaseballGame();
        BaseballGame.Player player = game.getPlayer();
        command("하이", "1234", "1", "123");
        // 게임 중 사용자 입력
        player.readGameOnInput();
        verify("[ERROR]", "[ERROR]", "[ERROR]", "");
    }

    @Test
    void 사용자_입력_받기_및_검증2() {
        BaseballGame game = new BaseballGame();
        BaseballGame.Player player = game.getPlayer();
        command("하이", "1234", "123", "1");
        // 게임 종료 후 사용자 입력
        player.readGameOverInput();
        verify("[ERROR]", "[ERROR]", "[ERROR]", "");
    }

    @Test
    void 게임_타겟_랜덤_생성() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 3, 3, 5)
                    .thenReturn(9, 1, 9, 1, 2);
            BaseballGame game = new BaseballGame();

            game.getComputer().resetTarget();
            assertThat(game.getComputer().getTarget()).isEqualTo("135");

            game.getComputer().resetTarget();
            assertThat(game.getComputer().getTarget()).isEqualTo("912");
        }
    }

    @Test
    void 타겟_일치_여부_판단() {
        BaseballGame game = new BaseballGame();
        BaseballGame.Computer computer = game.getComputer();

        // target 생성 전: 실패
        assertThat(computer.isTarget(null)).isEqualTo(false);
        assertThat(computer.isTarget("123")).isEqualTo(false);

        // target 생성 후: source 와 일치 시 성공
        String target = computer.resetTarget();
        assertThat(computer.isTarget(target)).isEqualTo(true);

        assertThat(computer.isTarget(null)).isEqualTo(false);
        assertThat(computer.isTarget("123")).isEqualTo(false);
    }

    @Test
    void 힌트_생성() {
        BaseballGame game = new BaseballGame();
        BaseballGame.Computer computer = game.getComputer();

        computer.setTarget("123");

        computer.generateHint("321");
        assertThat(computer.getStrike()).isEqualTo(1);
        assertThat(computer.getBall()).isEqualTo(2);

        computer.generateHint("562");
        assertThat(computer.getStrike()).isEqualTo(0);
        assertThat(computer.getBall()).isEqualTo(1);

        computer.generateHint("123");
        assertThat(computer.getStrike()).isEqualTo(3);
        assertThat(computer.getBall()).isEqualTo(0);

        computer.generateHint("964");
        assertThat(computer.getStrike()).isEqualTo(0);
        assertThat(computer.getBall()).isEqualTo(0);

    }

    @AfterEach
    void tearDown() {
        outputStandard();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
