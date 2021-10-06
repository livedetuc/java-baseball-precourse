package baseball.domain;

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

		public void resetTarget() {
			target = "";
		}

		public boolean isTarget(String source) {
			return target != null && target.equals(source);
		}

		private void generateHint(String input) {
			strike = 0;
			ball = 0;
		}
	}

}
