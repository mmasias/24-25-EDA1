public class Huevo extends Extra{
    final String REPRESENTACION = "~-~-( )~-~-";
    protected Huevo(){
        super("Huevo");
    }
    
    @Override
    public void mostrar() {
        System.out.println(REPRESENTACION);
    }

}
