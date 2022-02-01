package myProject;


public class ControlHangman {
    private Diccionario frases;
    private String frase, clave, errores;
    private int conteoErrores;
    private boolean fallo, ganar;

    public ControlHangman(){
        frases = new Diccionario();
    }

    public String PintarClaveFrase(){
        //Da los valores iniciales
        clave = "";
        errores = "Los errores son: ";
        conteoErrores = 0;

        //Obtiene la frase
        frase = frases.getFrase();
        
        //se crea la clave
        for(int i = 0; i<frase.length();i++){
            if(frase.charAt(i)==' '){
                clave+=frase.charAt(i);
            }else{
                clave+="-";
            }

        }
        return clave;
    }

    public String validarLetra(char letra){
        fallo=false; //la bandera inicia en false
        int index = frase.indexOf(letra);//recorre la palabra y verifica si esta la letra, devuelve solo la primera insidencia
        if(index!=-1){
            while(index>-1){
                reemplazarLetra(index, letra);
                index= frase.indexOf(index+1,letra);

            }
        }else{
            fallo=true;
            conteoErrores++;
            errores+=letra+" ";

        }
        return clave;

    }

    private void reemplazarLetra(int index, char letra) {
        char[] arrayClave = clave.toCharArray();//me convierte el string de clave a array para obtener el index y reemplazarlo por la letra
        arrayClave[index]=letra;//en el index, lo reemplaza por la letra
        clave = String.copyValueOf(arrayClave); // aca convierte el array clave a string
    }
    public boolean isGanador(){
        /*
        if(clave.indexOf('-')==-1){
            ganar=true;
        }else {
            ganar=false;
        }
        return ganar;
        */
        ganar = (clave.indexOf('-')==-1)?true:false; //Verifica si es -1 y si se cumple, coloca el true despues del ? y sino retorna el false(forma para ahorrar if's)
        return ganar;
    }

    public String getFrase() {
        return frase;
    }

    public String getClave() {
        return clave;
    }

    public String getErrores() {
        return errores;
    }

    public int getConteoErrores() {
        return conteoErrores;
    }

    public boolean isFallo() {
        return fallo;
    }
}
