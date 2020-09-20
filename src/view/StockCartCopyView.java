package view;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class StockCartCopyView extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtNewCopyStockCode;
	public JButton btnCopyButton;


	public StockCartCopyView() {
		super("Stok Kartý Kopyalama",true, true, true, true);
		Init();
		this.setClosable(true);
	}

	public String getCopyStockCode() {
		return txtNewCopyStockCode.getText().toString();
	}

	private void Init() {

		setTitle("Kopyala");
		setBounds(100, 100, 298, 209);

		JLabel lblNewLabel = new JLabel("Yeni Stok Kodu");

		txtNewCopyStockCode = new JTextField();
		txtNewCopyStockCode.setColumns(10);

		btnCopyButton = new JButton("Kopyala");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING,
						groupLayout.createSequentialGroup().addGap(27).addComponent(lblNewLabel)
								.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
								.addComponent(txtNewCopyStockCode, GroupLayout.PREFERRED_SIZE, 113,
										GroupLayout.PREFERRED_SIZE)
								.addGap(94))
				.addGroup(groupLayout.createSequentialGroup().addGap(113).addComponent(btnCopyButton)
						.addContainerGap(152, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(64)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtNewCopyStockCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))
						.addGap(18).addComponent(btnCopyButton).addContainerGap(54, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);

	}
}
