package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dataaccess.HibernateUtil;

@Entity
@Table(name = "stocks")
public class StockModel implements Serializable {
	@Id
	@Column(name = "StokCode", nullable = false)
	private String stokCode;

	@Column(name = "StockName")
	private String stockName;

	@Column(name = "StockType")
	private int stockType;

	@Column(name = "Unit")
	private String unit;

	@Column(name = "Barcode")
	private String barcode;

	@Column(name = "VatType")
	private double vatType;

	@Column(name = "Description")
	private String description;

	@Column(name = "DateOfCreation")
	private Date dateOfCreation;

	public String getStokCode() {
		return stokCode;
	}

	public void setStokCode(String stokCode) {
		this.stokCode = stokCode;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public int getStockType() {
		return stockType;
	}

	public void setStockType(int stockType) {
		this.stockType = stockType;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public double getVatType() {
		return vatType;
	}

	public void setVatType(double vatType) {
		this.vatType = vatType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateOfCreation() {

		return dateOfCreation;
	}

	public String getDateOfCreationFor() {

		return dateOfCreation.toString();
	}

	public void setDateOfCreation(Date value) {
		dateOfCreation = value;
	}

	public String stockModel() {
		return getStokCode().toString() + " " + getStockName().toString() + " " + String.valueOf(getStockType()) + " "
				+ getUnit().toString() + " " + getBarcode().toString() + " " + String.valueOf(getVatType()) + " "
				+ getDescription().toString() + " " + getDateOfCreation().toString();
	}

	public StockModel(String stokCode, String stockName, int stockType, String unit, String barcode, double vatType,
			String description) {
		this.stokCode = stokCode;
		this.stockName = stockName;
		this.stockType = stockType;
		this.unit = unit;
		this.barcode = barcode;
		this.vatType = vatType;
		this.description = description;
	}

	public StockModel(String stokCode, String stockName, int stockType, String unit, String barcode, double vatType,
			String description, Date date) {
		this.stokCode = stokCode;
		this.stockName = stockName;
		this.stockType = stockType;
		this.unit = unit;
		this.barcode = barcode;
		this.vatType = vatType;
		this.description = description;
		this.dateOfCreation = date;
	}

	public StockModel() {

	}

	public void insertStock(StockModel stock) {// save or update
		Session session = HibernateUtil.session;
		Transaction tx = session.beginTransaction();
		session.save(stock);
		tx.commit();
		session.clear();
	}
	public void updateStock(StockModel stock) {
		Session session = HibernateUtil.session;
		Transaction tx = session.beginTransaction();
		session.update(stock);
		tx.commit();
		session.clear();
	}
	public void deleteStock(StockModel stock) {
		Session session = HibernateUtil.session;
		Transaction tx = session.beginTransaction();
		session.delete(stock);
		tx.commit();
		session.clear();
	}

	public List<StockModel> getAll() {
		Session session = HibernateUtil.session;
		Transaction tx = session.beginTransaction();
		List<StockModel> stockList = session.createQuery("SELECT a FROM stocks a", StockModel.class).getResultList();
		System.out.println(stockList.get(0).getStockName());
		tx.commit();
		return stockList;
	}

	public List<StockModel> getAllStocks() {
		Session session = HibernateUtil.session;
//		CriteriaBuilder cb = session.getCriteriaBuilder();
//		CriteriaQuery<StockModel> cq = cb.createQuery(StockModel.class);
//		Root<StockModel> rootEntry = cq.from(StockModel.class);
//		CriteriaQuery<StockModel> all = cq.select(rootEntry);
//		TypedQuery<StockModel> allQuery = session.createQuery(all);
		Criteria criteria = session.createCriteria(StockModel.class);
		List<StockModel> stockListesi = criteria.list();
		session.clear();
		return stockListesi;
	}

	public StockModel getById() {
		Session session = HibernateUtil.session;
		Transaction tx = session.beginTransaction();
		StockModel stock = session.get(StockModel.class, getStokCode());
		tx.commit();
		session.clear();
		return stock;
	}
}
