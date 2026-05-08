package com.instituto.api.service;
import org.springframework.stereotype.Service;

@Service
public class AulaService {


    private final int[][] aula = new int[5][15];


    public String ocuparAsiento(int fila, int columna) {
        if (!coordenadasValidas(fila, columna)) {
            return "Error: coordenadas fuera de rango. Fila: 0-4, Columna: 0-14.";
        }
        if (aula[fila][columna] == 1) {
            return "El asiento [" + fila + "][" + columna + "] ya está ocupado.";
        }
        aula[fila][columna] = 1;
        return "Asiento [" + fila + "][" + columna + "] ocupado exitosamente.";
    }

    public String liberarAsiento(int fila, int columna) {
        if (!coordenadasValidas(fila, columna)) {
            return "Error: coordenadas fuera de rango. Fila: 0-4, Columna: 0-14.";
        }
        if (aula[fila][columna] == 0) {
            return "El asiento [" + fila + "][" + columna + "] ya está libre.";
        }
        aula[fila][columna] = 0;
        return "Asiento [" + fila + "][" + columna + "] liberado exitosamente.";
    }
    public String mostrarMatriz() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Distribución del Aula (5x15) ===\n");
        sb.append("Leyenda: [0]=Libre  [1]=Ocupado\n\n");
        sb.append("     ");
        for (int c = 0; c < 15; c++) {
            sb.append(String.format("C%-2d ", c));
        }
        sb.append("\n");
        for (int f = 0; f < 5; f++) {
            sb.append(String.format("F%d | ", f));
            for (int c = 0; c < 15; c++) {
                sb.append(" ").append(aula[f][c]).append("  ");
            }
            sb.append("\n");
        }
        sb.append("nOcupados: ").append(contarOcupados()).append(" / 75");
        return sb.toString();
    }

    public int contarOcupados() {
        int count = 0;
        for (int f = 0; f < 5; f++) {
            for (int c = 0; c < 15; c++) {
                if (aula[f][c] == 1) count++;
            }
        }
        return count;
    }

    private boolean coordenadasValidas(int fila, int columna) {
        return fila >= 0 && fila < 5 && columna >= 0 && columna < 15;
    }
}
