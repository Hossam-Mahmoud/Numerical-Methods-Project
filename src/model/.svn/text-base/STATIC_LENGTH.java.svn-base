package model;

import java.awt.Dimension;
import java.awt.Toolkit;

public class STATIC_LENGTH {

	private static Dimension screen = Toolkit.getDefaultToolkit()
			.getScreenSize();

	// background panel
	public static final int START_BACKGROUND_X = 0;
	public static final int START_BACKGROUND_Y = 0;
	public static final int BACKGROUND_WIDTH = screen.width;
	public static final int BACKGROUND_HEIGHT = screen.height;

	// header panel
	public static final int START_HEADER_X = 0;
	public static final int START_HEADER_Y = 0;
	public static final int HEADER_WIDTH = screen.width;
	public static final int HEADER_HEIGHT = screen.height / 10;

	// TAB PANEL

	public static final int TAB_X = 0;
	public static final int TAB_Y = HEADER_HEIGHT + 10;
	public static final int TAB_WIDTH = screen.width;
	public static final int TAB_HEIGHT = screen.height - HEADER_HEIGHT - 50;

	// outputPanel

	public static final int OUTPUT_X = 5 + TAB_X;
	public static final int OUTPUT_Y = TAB_Y;
	public static final int OUTPUT_WIDTH = TAB_WIDTH;
	public static final int OUTPUT_HEIGHT = TAB_HEIGHT;

	private static final int OUTPUT_DELTA = 30;
	// table panel

	public static final int TABLE_X = OUTPUT_X;
	public static final int TABLE_Y = OUTPUT_Y + OUTPUT_DELTA;
	public static final int TABLE_WIDTH = OUTPUT_WIDTH / 4;
	public static final int TABLE_HEIGHT = OUTPUT_HEIGHT - OUTPUT_DELTA;

	// draw panel

	public static final int DRAW_X = TABLE_X + TABLE_WIDTH;
	public static final int DRAW_Y = OUTPUT_Y + OUTPUT_DELTA;
	public static final int DRAW_WIDTH = screen.width - TABLE_WIDTH;
	public static final int DRAW_HEIGHT = OUTPUT_HEIGHT - OUTPUT_DELTA;

	// default precision
	public static final double PRECISION = 0.00001;
	public static int MAX_ITERATION = 5000;
}
