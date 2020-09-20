package framecontroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UnsupportedLookAndFeelException;

import controller.StockCartCopyController;
import view.StockCartCopyView;
import view.StockListView;

public class StockCartCopyFrameController implements ActionListener{
	private StockCartCopyView copyView;
	private StockListView listView;
	private StockCartCopyController copyController;
	public StockCartCopyFrameController(StockListView listView) {
		copyView=new StockCartCopyView();
		this.listView=listView;
		copyController=new StockCartCopyController(copyView, listView);
		copyView.btnCopyButton.addActionListener(copyController);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			MainFrameController.mainView.createFrame(copyView);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
