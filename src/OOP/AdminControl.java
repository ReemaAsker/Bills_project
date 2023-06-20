package OOP;

public interface  AdminControl {

	/**
	 * 
	 * @param username
	 * @param pass
	 */
	public abstract boolean checkLogin(String username, String pass);

	/**
	 * 
	 * @param username
	 */
	public abstract boolean changePass(String username);

	/**
	 * 
	 * @param username
	 */
	public abstract boolean searchAdCah(int username);

	/**
	 * 
	 * @param admin
	 */
	public abstract boolean addAdmin(Person admin);

	/**
	 * 
	 * @param cashir
	 */
	public abstract boolean addCashir(Person cashir);

	/**
	 * 
	 * @param person
	 */
	public abstract String showPersonInfo(Person person);

	/**
	 * 
	 * @param customer
	 */
	public abstract boolean addCustomer(Customer customer);

	/**
	 * 
	 * @param customerNo
	 */
	public abstract boolean searchCustomer(String customerNo);

}