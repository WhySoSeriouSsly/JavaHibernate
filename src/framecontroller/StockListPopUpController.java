package framecontroller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.StockListView;

public class StockListPopUpController implements MouseListener{
	private StockListView listView;
	private StockCartCopyFrameController copyFrameController;
	public StockListPopUpController(StockListView listView) {
		this.listView=listView;
		copyFrameController=new StockCartCopyFrameController(listView);
		listView.mntmCopy.addActionListener(copyFrameController);
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton()==java.awt.event.MouseEvent.BUTTON3) {
			listView.popupMenu.show(listView.tblStocks,e.getX(),e.getY());
			return;
		}
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
