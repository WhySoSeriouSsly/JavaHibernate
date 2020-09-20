package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import business.Message;
import business.utility.DateTime;
import model.StockModel;
import view.StockCartView;

public class StockSaveController implements ActionListener {
	private StockCartView cartView;

	public StockSaveController(StockCartView cartView) {
		this.cartView = cartView;
	}

	public void insertStock() {
		StockModel stock = new StockModel();
		stock.setStokCode(cartView.getTxtStokKodu());
		stock.setStockName(cartView.getTxtStokAdi());
		stock.setStockType(cartView.getCbxStokTipi());
		stock.setUnit(cartView.getCbxStokBirimi());
		stock.setBarcode(cartView.getTxtStokBarkodu());
		stock.setVatType(cartView.getCbxKdvTipi());
		stock.setDescription(cartView.getTxAaciklama());
		stock.setDateOfCreation(DateTime.date());
		if (stock.getById() == null) {
			stock.insertStock(stock);
			Message.showMessage("Stok Eklendi");
			return;
		}
		stock.updateStock(stock);
		Message.showMessage("Stok Güncellendi");
		return;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		insertStock();
	}
}
