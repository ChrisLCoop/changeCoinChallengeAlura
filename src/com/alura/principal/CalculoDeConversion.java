package com.alura.principal;

public class CalculoDeConversion {
    /* monedas para convertir
    -Dólar =>> Peso argentino
    -Peso argentino =>> Dólar
    -Dólar =>> Real Brasileño
    -Real Brasileño =>> Dólar
    -Dólar =>> Peso colombiano
    -Peso colombiano =>> Dólar
     */
    double cambioUsdToArs;
    double cambioUsdToBrl;
    double cambioUsdToCop;

    //variables de los resultados de cambios entre los paises mensionados lineas arriba

    double UsdArs;
    double ArsUsd;
    double UsdBrl;
    double BrlUsd;
    double UsdCop;
    double CopUsd;

    //valor a convertir
    double dinero;

    //contructor
    public CalculoDeConversion(double cambioUsdToArs, double cambioUsdToBrl, double cambioUsdToCop, double dinero) {
        this.cambioUsdToArs = cambioUsdToArs;
        this.cambioUsdToBrl = cambioUsdToBrl;
        this.cambioUsdToCop = cambioUsdToCop;
        this.dinero = dinero;
    }

    //--------
    public double getUsdArs() {
        return UsdArs;
    }

    public double getArsUsd() {
        return ArsUsd;
    }

    public double getUsdBrl() {
        return UsdBrl;
    }

    public double getBrlUsd() {
        return BrlUsd;
    }

    public double getUsdCop() {
        return UsdCop;
    }

    public double getCopUsd() {
        return CopUsd;
    }

    //conversion de las monedas ya mensionadas lineas arriba (o.O)

    void operacionDeConversion(){
        UsdArs = Math.round((dinero * cambioUsdToArs)*100.00)/100.00;
        ArsUsd = Math.round((dinero / cambioUsdToArs)*100.00)/100.00;

        UsdBrl = Math.round((dinero * cambioUsdToBrl)*100.00)/100.00;
        BrlUsd = Math.round((dinero / cambioUsdToBrl)*100.00)/100.00;

        UsdCop = Math.round((dinero * cambioUsdToCop)*100.00)/100.00;
        CopUsd = Math.round((dinero / cambioUsdToCop)*100.00)/100.00;
    }
}


