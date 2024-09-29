package lab07.Vehicles;

public abstract class Vehicle {
    protected boolean isAnonymous = false;
    protected String identifier;

    public Vehicle() {
        this.isAnonymous = true;
    }

    public Vehicle(String identifier) {
        this.identifier = identifier;
    }

    final public String identify()
    {
        if (this.isAnonymous) {
            return this.getAnonymousIdentifier();
        }

        return this.getIdentifier();
    }

    protected String getAnonymousIdentifier()
    {
        return "anonymous by " + this.getClass().getSimpleName().toLowerCase();
    }

    abstract protected String getIdentifier();
}
