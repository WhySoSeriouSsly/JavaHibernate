package framecontroller;

import controller.MainFrameCloseController;
import dataaccess.HibernateUtil;
import view.MainView;

public class MainFrameController {

	static MainView mainView;
	public static void main(String[] args) {
		HibernateUtil util=new HibernateUtil();
		util.baglanti();
		mainView = new MainView();
		mainView.setVisible(true);
		StockCartListFrameController listFrameController = new StockCartListFrameController(mainView);
		StockCartFrameController cartFrameController=new StockCartFrameController(mainView);
		MainFrameCloseController closeFrameController=new MainFrameCloseController();
		mainView.mnitmStokList.addActionListener(listFrameController);
		mainView.mnitmStokIslemleri.addActionListener(cartFrameController);
		mainView.addWindowListener(closeFrameController);
	}
}
