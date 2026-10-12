package fOne.builder;

public class Bolide {
    private String team;
    private String driver;
    private String model;

    public Bolide(String team, String driver, String model) {
        this.team = team;
        this.driver = driver;
        this.model = model;
    }

    public String getTeam() {
        return team;
    }

    public String getDriver() {
        return driver;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "Команда: " + team + ", Пилот: " + driver + ", Модель: " + model;
    }
}
