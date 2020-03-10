package TemplateMethod;

public abstract class TourPackage
{
    public TourPackage()
    {

    }

    public void hire ()
    {
        jabo();
        ghurbo();
        firbo();
    }

    protected abstract void jabo();

    protected abstract void ghurbo();

    protected abstract void firbo();
}
