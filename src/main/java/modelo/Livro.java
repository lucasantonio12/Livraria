/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author lucas
 */
public class Livro {
   
    private String autor;
    private String titulo;
    private String nota;

    public Livro() {
    }

    public Livro(String autor, String titulo, String nota) {
        this.autor = autor;
        this.titulo = titulo;
        this.nota = nota;
    }
    
    
    
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Livro{" + "autor=" + autor + ", titulo=" + titulo + ", nota=" + nota + '}';
    }
    
    
}
