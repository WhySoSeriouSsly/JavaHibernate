package controller;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import business.utility.DateTime;
import model.StockModel;
import view.StockCartView;

public class StockSearchController implements FocusListener{
	private StockCartView cartView;
	public StockSearchController(StockCartView cartView) {
		this.cartView=cartView;
	}
	public void getByStockCode() {
		StockModel stock=new StockModel();
		stock.setStokCode(cartView.getTxtStokKodu());
		if(stock.getById()==null) {
			cartView.setFieldEmpty();
			return;
		}
		cartView.txtStokKodu.setText(stock.getById().getStokCode());
		cartView.txtStokAdi.setText(stock.getById().getStockName());
		cartView.cbxStokTipi.setSelectedIndex(stock.getById().getStockType());
		cartView.cbxStokBirimi.setSelectedItem(stock.getById().getUnit());
		cartView.txtStokBarkodu.setText(stock.getById().getBarcode());
		cartView.cbxKdvTipi.setSelectedItem(stock.getById().getVatType());
		cartView.txAaciklama.setText(stock.getById().getDescription());
		cartView.ftxOlusturulmaTarihi.setText(DateTime.dateNow(stock.getById().getDateOfCreation()));
	}
	
	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void focusLost(FocusEvent arg0) {
		getByStockCode();
	}
}
