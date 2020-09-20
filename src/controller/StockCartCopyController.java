package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import business.utility.DateTime;
import model.StockModel;
import view.StockCartCopyView;
import view.StockListView;

public class StockCartCopyController implements ActionListener {
	private StockCartCopyView copyView;
	private StockListView listView;
	private StockListController listController;

	public StockCartCopyController(StockCartCopyView copyView, StockListView listView) {
		this.copyView = copyView;
		this.listView = listView;
		listController = new StockListController(listView);
	}

	public void copyStock() {
		StockModel stock = new StockModel();
		stock.setStokCode(listView.getSelectItem());
		if (stock.getById() == null) {
			return;
		}
		StockModel newStock = stock.getById();
		newStock.setStokCode(copyView.getCopyStockCode());
		newStock.setDateOfCreation(DateTime.date());
		newStock.insertStock(newStock);
		listController.listStock();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		copyStock();
	}

}
