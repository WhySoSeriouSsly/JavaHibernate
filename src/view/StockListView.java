package view;

import javax.swing.JInternalFrame;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.StockModel;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JPopupMenu;
import java.beans.PropertyVetoException;
import javax.swing.JMenuItem;
import java.awt.Color;

public class StockListView extends JInternalFrame {

	private static final long serialVersionUID = 6583026181222259078L;
	public JTable tblStocks;
	public JTextField txtSearchStock;
	public String getTxtSearchStock() {
		return txtSearchStock.getText().toString();
	}

	private DefaultTableModel model;
	public JButton btnSearch;
	public JPopupMenu popupMenu;
	public JMenuItem mntmDelete;
	public JMenuItem mntmCopy;
	public JMenuItem mnitmExportExcel;
	public JMenuItem mnitmExportPdf;
	public JMenuItem mnitmReportData;
	public JButton btnGetStock;
	public StockListView() {
		super("Stok Listesi", false, true, true, true);
		getContentPane().setBackground(Color.WHITE);
		Init();
		try {
			this.setClosed(true);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}

	public void populateTable(List<StockModel> stockss) {
		model = (DefaultTableModel) tblStocks.getModel();
		model.setRowCount(0);
		List<StockModel> stocks = stockss;
		for (StockModel stock : stocks) {
			Object[] row = { stock.getStokCode(), stock.getStockName(),
					stock.getBarcode(), stock.getDateOfCreation()};
			model.addRow(row);
		}
		tblStocks.setModel(model);
	}

	public String txtSearchStockCode() {
		return txtSearchStock.getText().toString();
	}

	public String getSelectItem() {
		int row = tblStocks.getSelectedRow();
		if (row == -1) {
			if (tblStocks.getRowCount() == 0) {
				return null;
			} else {
				return null;
			}
		}
		String codeValue = tblStocks.getModel().getValueAt(row, 0).toString();
		return codeValue;
	}

	private void Init() {

		setBounds(100, 100, 817, 390);

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblSearchKey = new JLabel("Aranacak Kelime");

		txtSearchStock = new JTextField();
		txtSearchStock.setColumns(10);

		btnSearch = new JButton("Ara");

		btnGetStock = new JButton("Stoklar\u0131 Listele");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 780, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblSearchKey)
									.addGap(18)
									.addComponent(txtSearchStock, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 417, Short.MAX_VALUE)
									.addComponent(btnGetStock)
									.addGap(9))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(128)
							.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(11, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnGetStock))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSearchKey)
								.addComponent(txtSearchStock, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSearch)))
					.addContainerGap(61, Short.MAX_VALUE))
		);

		tblStocks = new JTable();
		tblStocks.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Stok Kodu", "Stok Ad\u0131", "Barkod", "Tarih"
			}
		));

		popupMenu = new JPopupMenu();

		mntmDelete = new JMenuItem("Sil");
		popupMenu.add(mntmDelete);

		mntmCopy = new JMenuItem("Kopyala");
		popupMenu.add(mntmCopy);
		
		mnitmExportExcel=new JMenuItem("Excele Aktar");
		popupMenu.add(mnitmExportExcel);
		
		mnitmExportPdf=new JMenuItem("Pdf'ye Aktar");
		popupMenu.add(mnitmExportPdf);
		
		mnitmReportData=new JMenuItem("Raporla");
		popupMenu.add(mnitmReportData);
		
		
		scrollPane.setViewportView(tblStocks);
		getContentPane().setLayout(groupLayout);
	}
}
