package baseball.domain;

import static nextstep.utils.Randoms.pickNumberInRange;
import lombok.Getter;
import lombok.Setter;

@Getter
public class BaseballGame {

	final private int COUNT_OF_DIGITS = 3;

	private Computer computer;
	private Player player;

	public BaseballGame() {
		computer = new Computer();
		player = new Player();
	}

	/**
	 * Game Player
	 */
	@Getter
	class Player {
		/**
		 * Player 가 입력한 값
		 */
		private String input;

		public String readInput() {
			return "";
		}

		private boolean isValid(String input) {
			return true;
		}
	}


	/**
	 * Game Computer
	 */
	@Getter
	@Setter
	class Computer {

		/**
		 * Game 에서 맞춰야 하는 상대방(컴퓨터)의 수
		 */
		private String target;

		/**
		 *  상대방(컴퓨터)이 제시하는 힌트
		 *  - strike
		 *  - ball
		 */
		private int strike;
		private int ball;

		public String resetTarget() {
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < COUNT_OF_DIGITS; i++) {
				result.append(getUniqueRandomNumber(result.toString()));
			}
			target = result.toString();
			return target;
		}

		private int getUniqueRandomNumber(String digits) {
			int newDigit = pickNumberInRange(1, 9);
			// target 에 중복되는 숫자가 없도록 하기 위해
			while (digits.contains(newDigit + "")) {
				newDigit = pickNumberInRange(1, 9);
			}
			return newDigit;
		}

		public boolean isTarget(String source) {
			return target != null && target.equals(source);
		}

		public void generateHint(String input) {
			strike = 0;
			ball = 0;

			for (int i = 0; i < COUNT_OF_DIGITS; i++) {
				generateHint(input, i);
			}
		}

		private void generateHint(String input, int index) {
			// 같은 수, 같은 자리에 있으면 strike
			if (input.charAt(index) == target.charAt(index)) {
				strike++;
				return;
			}
			// 같은 수, 다른 자리에 있으면 ball
			if (target.indexOf(input.charAt(index)) > -1) {
				ball++;
			}
		}

		public String hintToString() {
			StringBuilder result = new StringBuilder();
			if (strike != 0) {
				result.append(String.format("%d스트라이크 ", strike));
			}
			if (ball != 0) {
				result.append(String.format("%d볼", ball));
			}
			if (strike == 0 && ball == 0) {
				result.append("낫싱");
			}
			return result.toString();
		}
	}

}
