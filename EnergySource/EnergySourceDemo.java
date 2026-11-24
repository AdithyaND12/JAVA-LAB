abstract class EnergySource {
    private final String sourceId;
    private final String sourceName;
    private final double energyGenerated;

    protected EnergySource(String sourceId, String sourceName, double energyGenerated) {
        if (energyGenerated < 0) {
            throw new IllegalArgumentException("Energy generated cannot be negative.");
        }
        this.sourceId = sourceId;
        this.sourceName = sourceName;
        this.energyGenerated = energyGenerated;
    }

    protected double getEnergyGenerated() {
        return energyGenerated;
    }

    public abstract double calculateEfficiency();

    public void displayDetails() {
        System.out.printf(
                "Source ID: %s%nSource Name: %s%nEnergy Generated: %.2f kWh%nEfficiency: %.2f%%%n",
                sourceId, sourceName, energyGenerated, calculateEfficiency());
    }
}

class SolarEnergy extends EnergySource {
    public SolarEnergy(String sourceId, String sourceName, double energyGenerated) {
        super(sourceId, sourceName, energyGenerated);
    }

    @Override
    public double calculateEfficiency() {
        return getEnergyGenerated() / 5000.0 * 100;
    }
}

class WindEnergy extends EnergySource {
    public WindEnergy(String sourceId, String sourceName, double energyGenerated) {
        super(sourceId, sourceName, energyGenerated);
    }

    @Override
    public double calculateEfficiency() {
        return getEnergyGenerated() / 8000.0 * 100;
    }
}

public class EnergySourceDemo {
    public static void main(String[] args) {
        EnergySource[] sources = {
                new SolarEnergy("S101", "Solar Farm", 4200),
                new WindEnergy("W201", "Wind Farm", 6400)
        };

        for (EnergySource source : sources) {
            source.displayDetails();
            System.out.println();
        }
    }
}
