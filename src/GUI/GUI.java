package GUI;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import model.Model;
import view.BackGroundPanel;
import controller.BisectionController;
import controller.FalsePositionController;
import controller.FixedPointController;
import controller.NewtonRaphsonAccController;
import controller.NewtonRaphsonController;
import controller.SecantController;
import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;
/**
 * Example of components laid out in a grid
 */
public class GUI extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel ivjJFrameContentPane = null;
	private JTabbedPane tabbed_Panel = null;
	private JPanel Part1_Panel = null;
	private PartTwo Part2_Panel = null;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public GUI() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, ParseException {
//		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
		initialize();
	}

	/**
	 * Return the JFrameContentPane property value.
	 * @return javax.swing.JPanel
	 */
	private JPanel getJFrameContentPane() {
		if (ivjJFrameContentPane == null) {
			ivjJFrameContentPane = new javax.swing.JPanel();
			ivjJFrameContentPane.setName("JFrameContentPane");
			ivjJFrameContentPane.setLayout(null);
			ivjJFrameContentPane.add(getTabbed_Panel(), null);
		}
		return ivjJFrameContentPane;
	}

	/**
	 * Initialize the class.
	 * @throws ParseException 
	 * @throws UnsupportedLookAndFeelException 
	 */
	private void initialize() throws UnsupportedLookAndFeelException, ParseException {
		this.setName("JFrame1");
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setTitle("BasicSwingComponents");
		this.setContentPane(getJFrameContentPane());
	}

	/**
	 * This method initializes tabbed_Panel	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getTabbed_Panel() {
		if (tabbed_Panel == null) {
			tabbed_Panel = new JTabbedPane();
			tabbed_Panel.setBounds(0, 0, (int)screenSize.getWidth(), (int)screenSize.getHeight());
			tabbed_Panel.addTab("Part 1", null, getPart1_Panel(), null);
			tabbed_Panel.addTab("Part 2", null, getPart2_Panel(), null);
		}
		return tabbed_Panel;
	}

	/**
	 * This method initializes Part1_Panel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPart1_Panel() {
		if (Part1_Panel == null) {
			Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

			BisectionController contrl = new BisectionController(new Model());
			FalsePositionController contrl2 = new FalsePositionController(
					new Model());
			FixedPointController contrl3 = new FixedPointController(new Model());
			NewtonRaphsonController contrl4 = new NewtonRaphsonController(
					new Model());
			NewtonRaphsonAccController contrl5 = new NewtonRaphsonAccController(
					new Model());
			SecantController contrl6 = new SecantController(new Model());

			JFrame frame = new JFrame("yalla");
			BackGroundPanel bg = new BackGroundPanel(contrl, contrl2, contrl3,
					contrl4, contrl5, contrl6);

			contrl.setBackGroundPanel(bg);
			contrl2.setBackGroundPanel(bg);
			contrl3.setBackGroundPanel(bg);
			contrl4.setBackGroundPanel(bg);
			contrl5.setBackGroundPanel(bg);
			contrl6.setBackGroundPanel(bg);

			Part1_Panel = bg;
		}
		return Part1_Panel;
	}

	/**
	 * This method initializes Part2_Panel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPart2_Panel() {
		Part2_Panel = new PartTwo();
		Part2_Panel.setParent(this);
		if (Part2_Panel == null) {
			Part2_Panel = new PartTwo();
			Part2_Panel.setLayout(new GridBagLayout());
		}
		return Part2_Panel;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, ParseException {
		GUI f = new GUI();
		f.setVisible(true);
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
