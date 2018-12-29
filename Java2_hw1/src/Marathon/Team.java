package Marathon;

public class Team {
    private String name;
    private Competitor[] competitors;

    public Competitor[] getCompetitors() {
        return competitors;
    }

    public Team(String name, Competitor... competitors) {
        this.name = name;
        this.competitors = competitors;
    }

    public void infoTeam() {
        for (Competitor c : competitors) {
            c.info();
        }
    }
}
