package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.StockModel;
import view.StockListView;

public class StockListController implements ActionListener {
	public StockModel stockModel;
	private StockListView listView;

	public StockListController(StockListView listView) {
		this.listView = listView;
		stockModel = new StockModel();
	}

	public void listStock() {
		listView.populateTable(stockModel.getAllStocks());
		return;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		listStock();
	}
}