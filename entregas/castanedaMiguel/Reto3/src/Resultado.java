public class Resultado {

    ComprimidoList comprimidoList;
    DiccionarioList diccionarioList;

    public Resultado(ComprimidoList cLista, DiccionarioList dLista){
        setComprimidoList(cLista);
        setDiccionarioList(dLista);

    }
    public DiccionarioList getDiccionarioList(){
        return this.diccionarioList;
    }
    public ComprimidoList getComprimidoList(){
        return this.comprimidoList;
    }
    public void setDiccionarioList(DiccionarioList diccionarioList) {
        this.diccionarioList = diccionarioList;
    }

    public void setComprimidoList(ComprimidoList comprimidoList) {
        this.comprimidoList = comprimidoList;
    }
}
