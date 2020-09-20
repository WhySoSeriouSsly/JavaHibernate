package view;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Window.Type;

public class MainView extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JMenuItem mnitmStokList;
	public JMenuItem mnitmStokIslemleri;
	public JDesktopPane desktopPane;
	private JLabel lblWelcome;

	public MainView() {
		setTitle("Stok Sistemi");

		Init();
		this.setVisible(false);

	}

	private void Init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1082, 780);
		Image icon = Toolkit.getDefaultToolkit().getImage("D:\\app.png");
		this.setIconImage(icon);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu mnStok = new JMenu("Stok");
		menuBar.add(mnStok);

		mnitmStokList = new JMenuItem("Stok Listesi");
		mnStok.add(mnitmStokList);

		mnitmStokIslemleri = new JMenuItem("Stok Ýþlemleri");
		mnStok.add(mnitmStokIslemleri);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		desktopPane = new JDesktopPane();
		desktopPane.setForeground(Color.BLACK);
		desktopPane.setBackground(Color.BLACK);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE).addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(desktopPane,
				GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE));

		lblWelcome = new JLabel("HO\u015EGELD\u0130N\u0130Z");
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 42));
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setBackground(Color.WHITE);
		lblWelcome.setBounds(381, 551, 333, 73);
		desktopPane.add(lblWelcome);
		ImageIcon iconDefault = new ImageIcon("D:\\bjk.jpg");
		JLabel lblImage = new JLabel(iconDefault);
		lblImage.setBounds(10, 11, 1016, 688);
		desktopPane.add(lblImage);

		contentPane.setLayout(gl_contentPane);
	}

	public void createFrame(JInternalFrame frame) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		if (frame.isVisible() == false) {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(frame);
			frame.setVisible(true);
			desktopPane.add(frame);
			try {
				frame.setSelected(true);
			} catch (java.beans.PropertyVetoException e) {
				System.out.println(e);
			}
			setContentPane(desktopPane);
			desktopPane.putClientProperty("JDesktopPane.dragMode", "outline");
		} else {
			return;
		}
	}
}
