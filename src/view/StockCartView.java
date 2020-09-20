package view;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import business.utility.DateTime;
import model.StockModel;

import javax.swing.JLabel;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

public class StockCartView extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	public JTextField txtStokKodu;
	public JTextField txtStokAdi;
	public JTextField txtStokBarkodu;
	public JComboBox cbxKdvTipi;
	public JComboBox cbxStokBirimi;
	public JComboBox cbxStokTipi;
	public JTextArea txAaciklama;
	public JFormattedTextField ftxOlusturulmaTarihi;
	public JButton btnSave;
	public JButton btnDelete;
	public JButton btnGet;
	public JButton btnEmptyField;
	public JButton btnMailView;

	public StockCartView() {
		super("Stok Kartý", true, true, false, true);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setTitle("Stok Kartý Ýþlemleri");
		Init();
	}
	
	public StockModel getModel() {
		return new StockModel(getTxtStokKodu(), getTxtStokAdi(), getCbxStokTipi(), getCbxStokBirimi(),
				getTxtStokBarkodu(), getCbxKdvTipi(), getTxAaciklama());
	}

	public String getTxtStokKodu() {
		if (txtStokKodu.getText().trim().isEmpty()) {
			return "";
		}
		return txtStokKodu.getText().toString().trim();
	}

	public String getTxtStokAdi() {
		return txtStokAdi.getText().toString().trim();
	}

	public String getTxtStokBarkodu() {
		return txtStokBarkodu.getText().toString().trim();
	}

	public Double getCbxKdvTipi() {
		Double kdv;
		if (cbxKdvTipi.getSelectedIndex() == 0) {
			kdv = 0.0;
			return kdv;
		}
		return Double.parseDouble(cbxKdvTipi.getSelectedItem().toString());
	}

	public String getCbxStokBirimi() {
		String birim;
		if (cbxStokBirimi.getSelectedIndex() == 0) {
			birim = "";
			return birim;
		}
		return cbxStokBirimi.getSelectedItem().toString();
	}

	public int getCbxStokTipi() {
		int tip;
		if (cbxStokTipi.getSelectedIndex() == 0) {
			tip = 0;
			return tip;
		}
		return cbxStokTipi.getSelectedIndex();
	}

	public String getTxAaciklama() {
		return txAaciklama.getText().toString().trim();
	}
	
	public String getFtxOlusturulmaTarihi() {
		return ftxOlusturulmaTarihi.getText().toString();
	}

	public void setFieldEmpty() {
		txtStokKodu.setText("");
		txtStokAdi.setText("");
		cbxStokTipi.setSelectedIndex(0);
		cbxStokBirimi.setSelectedIndex(0);
		txtStokBarkodu.setText("");
		cbxKdvTipi.setSelectedIndex(0);
		txAaciklama.setText("");
		ftxOlusturulmaTarihi.setText(DateTime.dateNow());
	}
	private void Init() {
		setBounds(100, 100, 381, 551);
		JLabel lblStokIslemleri = new JLabel("Stok Ýþlemleri");
		lblStokIslemleri.setFont(new Font("Tahoma", Font.BOLD, 23));

		JLabel lblStokKodu = new JLabel("Stok Kodu");

		JLabel lblStokAdi = new JLabel("Stok Ad\u0131");

		JLabel lblNewLabel = new JLabel("Stok Tipi");

		JLabel lblNewLabel_1_1 = new JLabel("Barkod");

		JLabel lblNewLabel_1_2 = new JLabel("KDV Tipi");

		JLabel lblNewLabel_1_3 = new JLabel("A\u00E7\u0131klama");

		JLabel lblNewLabel_1_3_1 = new JLabel("Olusturulma Tarihi");

		JLabel lblStokBirimi = new JLabel("Stok Birimi");

		txtStokKodu = new JTextField();
		txtStokKodu.setColumns(10);

		txtStokAdi = new JTextField();
		txtStokAdi.setColumns(10);

		cbxStokTipi = new JComboBox();
		cbxStokTipi.setModel(new DefaultComboBoxModel(new String[] { "Se\u00E7iniz", "1.Nolu Stok", "2.Nolu Stok",
				"3.Nolu Stok", "4.Nolu Stok", "5.Nolu Stok", "6.Nolu Stok", "7.Nolu Stok", "8.Nolu Stok", "9.Nolu Stok",
				"10.Nolu Stok", "11.Nolu Stok", "12.Nolu Stok", "13.Nolu Stok", "14.Nolu Stok" }));

		cbxStokBirimi = new JComboBox();
		cbxStokBirimi.setModel(new DefaultComboBoxModel(new String[] { "Se\u00E7iniz", "Sebze", "Meyve", "Elektronik",
				"Beyaz E\u015Fya", "Kisisel", "Makyaj", "Bilgisayar", "Telefon", "Ev", "Tamir", "Bitki" }));

		txtStokBarkodu = new JTextField();
		txtStokBarkodu.setColumns(10);

		cbxKdvTipi = new JComboBox();
		cbxKdvTipi.setModel(new DefaultComboBoxModel(
				new String[] { "Seciniz", "3.0", "8.0", "13.0", "18.0", "21.0", "24.0", "30.0", "33.0", "41.0" }));

		txAaciklama = new JTextArea();
		txAaciklama.setBackground(Color.WHITE);
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strDate = dateFormat.format(date);
		ftxOlusturulmaTarihi = new JFormattedTextField(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		ftxOlusturulmaTarihi.setEditable(false);
		ftxOlusturulmaTarihi.setText(strDate);
		btnSave = new JButton("Kaydet");

		btnDelete = new JButton("Sil");

		btnGet = new JButton("Getir");

		btnEmptyField = new JButton("Alanlar\u0131 temizle");
		
		btnMailView = new JButton("Mail");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(101)
					.addComponent(lblStokIslemleri))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(48)
					.addComponent(lblStokKodu)
					.addGap(18)
					.addComponent(txtStokKodu, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(btnGet))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(57)
					.addComponent(lblStokAdi)
					.addGap(18)
					.addComponent(txtStokAdi, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(56)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(cbxStokTipi, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(48)
					.addComponent(lblStokBirimi)
					.addGap(18)
					.addComponent(cbxStokBirimi, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(63)
					.addComponent(lblNewLabel_1_1)
					.addGap(18)
					.addComponent(txtStokBarkodu, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(58)
					.addComponent(lblNewLabel_1_2)
					.addGap(18)
					.addComponent(cbxKdvTipi, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addComponent(lblNewLabel_1_3)
					.addGap(18)
					.addComponent(txAaciklama, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel_1_3_1)
					.addGap(18)
					.addComponent(ftxOlusturulmaTarihi, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(88)
					.addComponent(btnSave)
					.addGap(18)
					.addComponent(btnDelete)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnMailView, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnEmptyField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(28))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addComponent(lblStokIslemleri)
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(lblStokKodu))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(txtStokKodu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnGet))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblStokAdi))
						.addComponent(txtStokAdi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel))
						.addComponent(cbxStokTipi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblStokBirimi))
						.addComponent(cbxStokBirimi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_1)
						.addComponent(txtStokBarkodu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1_2))
						.addComponent(cbxKdvTipi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_3)
						.addComponent(txAaciklama, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(lblNewLabel_1_3_1))
						.addComponent(ftxOlusturulmaTarihi, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSave)
						.addComponent(btnDelete)
						.addComponent(btnEmptyField))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnMailView)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
}
