package org.example.dominio;

public class Notificacion{
   private String Titulo;

   private String Cuerpo;

   private Incidente Incidente;

   private boolean enviado;

   public Notificacion(String Titulo, String Cuerpo, Incidente Incidente){
      this.Titulo = Titulo;
      this.Cuerpo = Cuerpo;
      this.Incidente = Incidente;
      this.enviado = false;
   }
   @Override
   public String toString() {
      return "Notificacion{" +
              "Titulo='" + Titulo + '\'' +
              ", Cuerpo='" + Cuerpo + '\'' +
              ", Incidente=" + Incidente +
              '}';
   }
}
