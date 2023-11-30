package org.example.dominio;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class Miembro {
    private metodoContacto metodoContacto;

    public void notificar(Notificacion Notificacion) {
        if (metodoContacto == metodoContacto.Email) {
         // enviar mail
        }
        else if (metodoContacto == metodoContacto.Whatsapp) {
         // enviar whatsapp
        }
    }
}
