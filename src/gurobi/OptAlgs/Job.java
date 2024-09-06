package gurobi.OptAlgs;

public class Job {
	
	private int ID; // the identifier of the job
	private int p; // processing time of the job
	private int d; // due date of the job
	
	public Job(int p, int d) {
		this.p = p;
		this.d = d;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public int getProcTime() {
		return p;
	}
	
	public void setProcTime(int p) {
		this.p = p;
	}
	
	public int getDueDate() {
		return d;
	}
	
	public void setDueDate(int d) {
		this.d = d;
	}
	
	public void printJob() {
		System.out.printf("-> %d ", this.getID());
	}

	
}
