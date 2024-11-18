package br.pucrs.fds.dominio.entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class teste {
    public static void main(String[] args) {
        LocalDate a = LocalDate.parse("24-11-2025",DateTimeFormatter.ofPattern("d-M-u"));
        System.out.println(a);
    }
}
