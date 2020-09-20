package framecontroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import controller.StockListController;
import view.MainView;
import view.StockListView;

public class StockCartListFrameController implements ActionListener{

	private MainView mainView;
	private StockListController listController;
	private StockListView listView;
	private StockListPopUpController popUpController;
	public StockCartListFrameController(MainView mainView) {
		listView=new StockListView();
		this.mainView=mainView;
		listController=new StockListController(listView);
		listView.btnGetStock.addActionListener(listController);
		popUpController=new StockListPopUpController(listView);
		listView.tblStocks.addMouseListener(popUpController);
	}
	public void showListFrame() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		if (listView.isVisible() == false) {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(listView);
			listView.setVisible(true);
			mainView.desktopPane.add(listView);
			try {
				listView.setSelected(true);
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}
			mainView.setContentPane(mainView.desktopPane);
			mainView.desktopPane.putClientProperty("JDesktopPane.dragMode", "outline");
		} else {
			return;
		}

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			showListFrame();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
	}
}
