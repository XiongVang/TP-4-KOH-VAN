package domain;

public class Hold {

	private boolean hasOverDueFees;

	public Hold(boolean hasOverDueFees) {
		this.hasOverDueFees = hasOverDueFees;
	}

	public void setHasOverDueFees(boolean hasOverDueFees) {
		this.hasOverDueFees = hasOverDueFees;
	}

	public boolean hasOverDueFees() {
		return this.hasOverDueFees;
	}
}
