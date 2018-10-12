package com.centroeduc.dao;

import com.centroeduc.model.Administrador;
import com.centroeduc.model.Alumno;
import com.centroeduc.model.AlumnoGrado;
import com.centroeduc.model.AsignacionCurso;
import com.centroeduc.model.Notas;
import com.centroeduc.model.Secretaria;
import com.centroeduc.model.Unidad;
import java.util.ArrayList;

public class prueba {

    public static void main(String[] args) {
        NotasDAO notasdao = new  NotasDAO();
        int rs = notasdao.AgregarNotas("P0019", 1, 1, 1, 6);
        System.out.println("codigo " + rs);
        
    }

}
