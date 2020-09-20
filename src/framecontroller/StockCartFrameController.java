package framecontroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import controller.StockDeleteController;
import controller.StockSaveController;
import controller.StockSearchController;
import view.MainView;
import view.StockCartView;

public class StockCartFrameController implements ActionListener, InternalFrameListener {
	private StockCartView cartView;
	private MainView mainView;
	private StockSaveController saveController;
	private StockDeleteController deleteController;
	private StockSearchController searchController;

	public StockCartFrameController(MainView mainView) {
		this.mainView = mainView;
		cartView = new StockCartView();
		saveController = new StockSaveController(cartView);
		deleteController = new StockDeleteController(cartView);
		searchController = new StockSearchController(cartView);
		cartView.btnSave.addActionListener(saveController);
		cartView.btnDelete.addActionListener(deleteController);
		cartView.txtStokKodu.addFocusListener(searchController);
		cartView.addInternalFrameListener(this);
	}

	public void showCartView() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		if (cartView.isVisible() == false) {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(cartView);
			cartView.setVisible(true);
			mainView.desktopPane.add(cartView);
			try {
				cartView.setSelected(true);
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
			showCartView();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@Override
	public void internalFrameActivated(InternalFrameEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameClosed(InternalFrameEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameClosing(InternalFrameEvent e) {
		cartView.setFieldEmpty();
		cartView.dispose();
	}

	@Override
	public void internalFrameDeactivated(InternalFrameEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameDeiconified(InternalFrameEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameIconified(InternalFrameEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameOpened(InternalFrameEvent e) {
		// TODO Auto-generated method stub

	}
}
