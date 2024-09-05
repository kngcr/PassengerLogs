package assignments09;



public class Passenger {
    private String name;
    private boolean frequentFlyer;
    private String status;
    private int nMiles;

    public Passenger(String n, boolean ff, int m) {
        this.name = n;
        this.frequentFlyer = ff;
        this.nMiles = m;
        if (!ff) {
            this.status = "Not frequent flyer";
        } else {
            setStatus(m);
        }
    }

    public void setStatus(int m) {
        if (m > 99999) {
            this.status = "Gold";
        } else if (m >= 50000) {
            this.status = "Silver";
        } else if (m >= 2500) {
            this.status = "Bronze";
        } else {
            this.status = "Aspiring";
        }
    }

    public String toString() {
    	return name + "(" + status + ")";
    }
}