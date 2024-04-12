class Prenda {
    TipoPrenda tipo;
    Material material;
    String colorPrimario;
    String colorSecundario;

    public Prenda(TipoPrenda tipo, Material material, String colorPrimario, String colorSecundario) {
        if (tipo == null || material == null || colorPrimario == null || colorPrimario.isEmpty()) {
            throw new IllegalArgumentException("Faltan datos requeridos para la prenda.");
        }
        if (!tipo.esCompatibleConCategoria()) {
            throw new IllegalArgumentException("El tipo de prenda no coincide con su categoría.");
        }
        this.tipo = tipo;
        this.material = material;
        this.colorPrimario = colorPrimario;
        this.colorSecundario = colorSecundario;
    }

    public Categoria getCategoria() {
        return tipo.getCategoria();
    }
}

enum TipoPrenda {
    CAMISA(Categoria.SUPERIOR),
    CAMPERA(Categoria.SUPERIOR),
    PANTALON(Categoria.INFERIOR),
    ZAPATO(Categoria.CALZADO),
    ANTEOJOS(Categoria.ACCESORIOS),
    PAÑUELO(Categoria.ACCESORIOS);

    Categoria categoria;

    TipoPrenda(Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public boolean esCompatibleConCategoria() {
        return getCategoria() == categoria;
    }
}

enum Categoria {
    SUPERIOR, INFERIOR, CALZADO, ACCESORIOS
}

enum Material {
    CUERO, JEAN, ALGODON
}