package eecs2030.lab4;

import java.awt.Color;

public class JBlock extends Block {

	private int count = 0;

	public JBlock(Point2 pos, Color col) {
		super(3, pos, col);
		grid = gPos[0];
		draw();
	}

	private BlockGrid[] gPos = getGridPos();

	private BlockGrid[] getGridPos() {
		BlockGrid[] ph = new BlockGrid[4];

		ph[0] = new BlockGrid(3);
		ph[0].set(0, 0);
		ph[0].set(1, 0);
		ph[0].set(1, 1);
		ph[0].set(1, 2);

		ph[1] = new BlockGrid(3);
		ph[1].set(0, 1);
		ph[1].set(0, 2);
		ph[1].set(1, 1);
		ph[1].set(2, 1);

		ph[2] = new BlockGrid(3);
		ph[2].set(1, 0);
		ph[2].set(1, 1);
		ph[2].set(1, 2);
		ph[2].set(2, 2);

		ph[3] = new BlockGrid(3);
		ph[3].set(0, 1);
		ph[3].set(1, 1);
		ph[3].set(2, 1);
		ph[3].set(2, 0);

		return ph;
	}

	@Override
	public void spinLeft() {
		count--;
		if (count < 0) {
			count = 3;
		}

		grid = gPos[count];
		draw();

	}

	@Override
	public void spinRight() {
		count++;
		if (count > 3) {
			count = 0;
		}

		grid = gPos[count];
		draw();
	}

}
