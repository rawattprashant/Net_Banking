package master.DTO;

public class UpdateAccDto {
	
	String accno;
	Double bal;
	String depositby;
	String dateofDeposit;
	public String getAccno() {
		return accno;
	}
	public void setAccno(String accno) {
		this.accno = accno;
	}
	public Double getBal() {
		return bal;
	}
	public void setBal(Double bal) {
		this.bal = bal;
	}
	public String getDepositby() {
		return depositby;
	}
	public void setDepositby(String depositby) {
		this.depositby = depositby;
	}
	public String getDateofDeposit() {
		return dateofDeposit;
	}
	public void setDateofDeposit(String dateofDeposit) {
		this.dateofDeposit = dateofDeposit;
	}
	

}
