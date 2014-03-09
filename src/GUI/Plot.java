package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import Function.Function;

public class Plot extends JPanel implements MouseListener, MouseMotionListener {
	private Function f;
	private Function line;

	private int from = 0;
	private int x, y;
	private int width;
	private int height;
	private int px, py;
	private final double INITIAL_ZOOM_FACTOR = 0.03;
	private double[] xPoint;
	private double[] yPoint;

	public Plot(int width, int height) {
		x = 0;
		y = 0;
		this.width = width;
		this.height = height;
		from = -width;
		setLocation(100, 0);
		setSize(width, height);
		setBackground(Color.white);
		addMouseListener(this);
		addMouseMotionListener(this);
		calc();
	}

	private void movePlot(int x, int y) {
		this.x += x - px;
		this.y += y - py;
		repaint();
		px = x;
		py = y;
	}

	public void zoomIn() {
		zFactor -= zFactor / 10;
		calc();
		repaint();
	}

	public void zoomOut() {
		if (zFactor + zFactor / 10 < 1)
			zFactor += zFactor / 10;
		calc();
		repaint();
	}

	public void reset() {
		x = 0;
		y = 0;
		zFactor = INITIAL_ZOOM_FACTOR;
		repaint();
	}

	public void setFunction(Function function) {
		f = function;
	}

	public void setLine(Function Line) {
		line = Line;
	}

	public void setPoints(double[] x, double[] y) {
		xPoint = x;
		yPoint = y;
	}

	public void removePoint() {
		xPoint = yPoint = null;
	}

	int shx, shy;
	int signx, signy;

	private void calc() {
		shx = 10000;
		shy = 10000;
		signx = 0;
		signy = 0;
		int tmp;
		for (int i = (int) (-Math.abs(y) * zFactor); i < height + Math.abs(y)
				* zFactor; i++) {
			tmp = height / 2 - (int) (i / zFactor);
			if (Math.abs(tmp) < shx) {
				if (tmp < 0) {
					shx = tmp * -1;
					signx = -1;
				} else {
					shx = tmp;
					signx = 1;
				}
			}
		}

		for (int i = (int) (-Math.abs(x) * zFactor); i < width + Math.abs(x)
				* zFactor; i++) {
			tmp = width / 2 - (int) (i / zFactor);
			if (Math.abs(tmp) < shy) {
				if (tmp < 0) {
					shy = tmp * -1;
					signy = -1;
				} else {
					shy = tmp;
					signy = 1;
				}
			}
		}
	}

	private double zFactor = INITIAL_ZOOM_FACTOR;

	public void paint(Graphics gg) {
		super.paint(gg);

		Graphics2D g = (Graphics2D) gg;
		g.setStroke(new BasicStroke(2));
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		// X-Axis
		g.drawLine(-Math.abs(x), height / 2 + y, width, height / 2 + y);
		// Y-Axis
		g.drawLine(width / 2 + x, 0 - Math.abs(y), width / 2 + x, height);
		g.setStroke(new BasicStroke(0));
		int px1, px2, py1, py2;
		double t2, t4;

		// X-Axis's
		for (int i = (int) (-Math.abs(y) * zFactor); i < height + Math.abs(y)
				* zFactor; i++) {

			g.drawLine(-Math.abs(x), (int) ((i / zFactor) + y + signx * shx),
					width, (int) ((i / zFactor) + y + signx * shx));

		}
		// Y-Axis's
		for (int i = (int) (-Math.abs(x) * zFactor); i < width + Math.abs(x)
				* zFactor; i++) {

			g.drawLine((int) (i / zFactor) + x + signy * shy, -Math.abs(y),
					(int) (i / zFactor) + x + signy * shy, height);

		}
		g.setColor(Color.red);
		g.setStroke(new BasicStroke(1));
		for (int i = from - x; i < from - x + 2 * width; i++) {
			px1 = (int) ((i + width / 2 + x));
			py1 = (int) (-((t2 = (evaluate(i * zFactor))) / zFactor) + height
					/ 2 + y);
			px2 = (int) ((i + 1 + width / 2 + x));
			py2 = (int) (-((t4 = (evaluate((i + 1) * zFactor))) / zFactor)
					+ height / 2 + y);
			// draw Function
			if (t2 == Double.NaN || t4 == Double.NaN)
				continue;
			g.drawLine(px1, py1, px2, py2);

			if (line != null) {
				g.setColor(Color.green);

				py1 = (int) (-((t2 = (evaluateLine(i * zFactor))) / zFactor)
						+ height / 2 + y);
				py2 = (int) (-((t4 = (evaluateLine((i + 1) * zFactor))) / zFactor)
						+ height / 2 + y);

				g.drawLine(px1, py1, px2, py2);

				g.setColor(Color.red);
			}
		}
		drawPoints(g);
	}

	private void drawPoints(Graphics2D g) {
		if (xPoint == null)
			return;
		int px, py;
		g.setColor(Color.blue);
		double rad = 0.4;
		for (int i = 0; i < xPoint.length; i++) {
			px = (int) (width / 2 + (xPoint[i] / zFactor) + x);
			py = (int) (height / 2 - (yPoint[i] / zFactor) + y);
			g.fillOval(px - (int) ((rad / 2) / zFactor), py
					- (int) ((rad / 2) / zFactor), (int) (rad / zFactor),
					(int) (rad / zFactor));
		}
	}

	private double evaluate(double t) {
		if (f != null)
			return f.evaluate(t);
		return 0;
	}

	private double evaluateLine(double t) {
		return line.evaluate(t);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		movePlot(e.getX(), e.getY());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		px = e.getX();
		py = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}
