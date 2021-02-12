package javasamples2;

public class SnakeandLadder {
	public static final int noPlay = 0;
	public static final int Ladder = 1;
	public static final int Snake = 2;

	public static void main(String[] args) {
		int positionplayer1 = 1;
		int positionplayer2 = 1;
		boolean firstplayer = true;
		boolean secondplayer = false;
		while (positionplayer1 <= 100 && positionplayer2 <= 100) {
			if (positionplayer1 < 0)
				positionplayer1 = 0;
			else if (positionplayer2 < 0)
				positionplayer2 = 0;
			else {
				int diceRoll = (int) Math.floor(Math.random() * 10) % 6 + 1;
				int option = (int) Math.floor(Math.random() * 10) % 3;
				switch (option) {
				case noPlay: {
					firstplayer = (!firstplayer);
					secondplayer = (!secondplayer);
					break;
				}
				case Ladder:
					if (firstplayer) {
						int value1 = positionplayer1 + diceRoll;
						if (value1 < 100) {
							positionplayer1 += diceRoll;
							firstplayer = true;
							secondplayer = false;
						} else if (value1 == 100) {
							positionplayer1 = 100;
						} else
							break;
					}
					break;
				case Snake:
					if (firstplayer) {
						positionplayer1 -= diceRoll;
						firstplayer = true;
						secondplayer = false;
					} else {
						positionplayer2 -= diceRoll;
						firstplayer = false;
						secondplayer = true;
					}
					break;
				}
			}
		}
		System.out.println("Position of First Player:" + positionplayer1);
		System.out.println("Position of Second Player:" + positionplayer2);
		if (positionplayer1 == 100)
			System.out.println("First Player Won!");
		else
			System.out.println("Second Player Won!");
	}
}
