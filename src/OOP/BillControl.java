package OOP;

public abstract class BillControl {

	/**
	 * 
	 * @param bill
	 */
	public abstract boolean addBill(Bill bill);

	/**
	 * 
	 * @param billNo
	 */
	public abstract boolean deleteBill(String billNo);

	/**
	 * 
	 * @param billNo
	 */
	public abstract boolean serchBill(String billNo);

	public abstract String showBillInfo();

}