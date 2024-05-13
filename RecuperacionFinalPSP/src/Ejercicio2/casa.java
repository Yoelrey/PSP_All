package Ejercicio2;

import java.io.Serializable;

public class casa implements Serializable {
    
	private static final long serialVersionUID = 1L;
	private int habitaciones;
    private int baños;
    private boolean trastero;

    public casa(int habitaciones, int baños, boolean trastero) {
        this.habitaciones = habitaciones;
        this.baños = baños;
        this.trastero = trastero;
    }

    public int getHabitaciones() {
        return habitaciones;
    }

    public int getBaños() {
        return baños;
    }

    public boolean getTrastero() {
        return trastero;
    }
}