package master.DTO;

public class FundTransferDto {

	String saccno;
	String baccno;
	String dot;
	Double balance;
	String ifcs;
	String banknm;
	public String getBanknm() {
		return banknm;
	}
	public void setBanknm(String banknm) {
		this.banknm = banknm;
	}
	public String getSaccno() {
		return saccno;
	}
	public void setSaccno(String saccno) {
		this.saccno = saccno;
	}
	public String getBaccno() {
		return baccno;
	}
	public void setBaccno(String baccno) {
		this.baccno = baccno;
	}
	public String getDot() {
		return dot;
	}
	public void setDot(String dot) {
		this.dot = dot;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getIfcs() {
		return ifcs;
	}
	public void setIfcs(String ifcs) {
		this.ifcs = ifcs;
	}
	
	
	
}
