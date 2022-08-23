package hauses;

public class Hause {
    public int getResidents() {
        return residents;
    }

    public void setResidents(int residents) {
        this.residents = residents;
    }

    public boolean isFoundation() {
        return foundation;
    }

    public void setFoundation(boolean foundation) {
        this.foundation = foundation;
    }

    private int residents;

    private boolean foundation;

    public Hause(int residents, boolean foundation) {
        this.residents = residents;
        this.foundation = foundation;
    }
}
