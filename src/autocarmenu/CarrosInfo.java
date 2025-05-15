/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autocarmenu;

public class CarrosInfo {
    String modelo, cor, placa, marca;
    int ano, id;
    
    public CarrosInfo(String modelo, String cor, String placa, int ano, String
            marca, int id) {
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.placa = placa;
        this.marca = marca;
        this.id = id;
    }
    
    public String formatarTexto(String t) {
        t = t.substring(0, 1).toUpperCase() + t.substring(1).toLowerCase();
        
        return t;
    }
    
    public String formatarPlaca(String p) {
        p = p.toUpperCase();
        if (p.matches("[A-Z]{3}\\d{1}[A-Z]{1}\\d{2}")) {
            return p.substring(0, 3) + "-" + p.substring(3);
        } else if (p.matches("[A-Z]{3}\\d{4}")) {
            return placa.substring(0, 3) + "-" + placa.substring(3);
        } else {
            return "INVÁLIDA";
        }
    }
    
    @Override
    public String toString() {
        return formatarTexto(marca)+" | "
               +formatarTexto(modelo)+" | "
               +ano+ " | "
               +formatarTexto(cor)+" | "
               +formatarPlaca(placa)+" / "
               +"ID: #"+id;
    }
    
}
