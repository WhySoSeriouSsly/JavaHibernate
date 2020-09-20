package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.StockModel;
import view.StockCartView;

public class StockDeleteController implements ActionListener {
	private StockCartView cartView;
	public StockDeleteController(StockCartView cartView) {
		this.cartView=cartView;
	}
	public void deleteStock() {
		StockModel stock=cartView.getModel();
		stock.deleteStock(stock);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		deleteStock();
	}
	
}
