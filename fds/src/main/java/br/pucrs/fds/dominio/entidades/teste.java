package br.pucrs.fds.dominio.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class teste {
    public static void main(String[] args) {
        LocalDate a = LocalDate.parse("24-11-2025",DateTimeFormatter.ofPattern("d-M-u"));
        System.out.println(a);
        float aa = 14392.8f;
        System.out.println(aa);
        BigDecimal valorPago = BigDecimal.valueOf(aa);
        System.out.println(valorPago);
        Double bb = 1999*12*0.6;
        BigDecimal valorCorreto = BigDecimal.valueOf(bb);
        System.out.println(valorCorreto);
        System.out.println(valorCorreto.compareTo(valorPago));
    }
}
