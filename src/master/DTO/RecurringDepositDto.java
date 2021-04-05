package master.DTO;

public class RecurringDepositDto {
	
	double rdamt;
	int month;
	String accno;
	String dopen;
	public double getRdamt() {
		return rdamt;
	}
	public void setRdamt(double rdamt) {
		this.rdamt = rdamt;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public String getAccno() {
		return accno;
	}
	public void setAccno(String accno) {
		this.accno = accno;
	}
	public String getDopen() {
		return dopen;
	}
	public void setDopen(String dopen) {
		this.dopen = dopen;
	}
	

}
