class Pollo extends Carne {
        final String REPRESENTACION = ";;;;;;;;;;;";
        
        public Pollo(String coccion) {
            super("Pollo", coccion);
        }
    
        @Override
        public void mostrar() {
            System.out.println(REPRESENTACION);
        }
    }

