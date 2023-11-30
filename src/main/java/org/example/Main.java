package org.example;

import org.example.dominio.*;
import org.example.repositorios.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//        Integrantes Grupo 3:
//        SANTIAGO MARTÍN TOLEDO AGUIRRE
//        JUAN IGNACIO MOURIÑO ATELA
//        ELIAS PUDDINI
//        NELLY IRIS HERRERO
//        WEFFER OSCAR
//        TOMAS TORANZOS

public class Main {

    TecnicoRepositorio repoTecnico = new TecnicoRepositorio(); IncidenteRepositorio repoIncidentes = new IncidenteRepositorio();
    RankingTecnicos lambdaMasIncidentesResueltos = n -> { // dada una lista de tecnicos, busca el que tenga mas incidentes resueltos.
        List<Tecnico> tecnicos = repoTecnico.getTecnicos();
        List<Incidente> incidentes = repoIncidentes.getIncidentes();
        Tecnico tecnicoTop = tecnicos.get(0);
        int topIncidentesResueltos = 0;
        for(Tecnico t: tecnicos ){
            List<Incidente> resueltosPorTecnico = incidentes.stream().filter(h -> h.ocurrioHaceNdias(n) && h.getTecnicoAsignado() == t ).collect(Collectors.toList());
            if (resueltosPorTecnico.size() > topIncidentesResueltos) {
                tecnicoTop = t;
                topIncidentesResueltos = resueltosPorTecnico.size();
            }
        }
        return tecnicoTop;
    };
    RankingTecnicosEspecialidad lambdaMasIncidentesResueltosEspecialidad = (n,e) -> { // dada una lista de tecnicos, busca el que tenga mas incidentes resueltos.
        List<Tecnico> tecnicos = repoTecnico.getTecnicos();
        List<Incidente> incidentes = repoIncidentes.getIncidentes();
        Tecnico tecnicoTop = tecnicos.get(0);
        int topIncidentesResueltos = 0;
        for(Tecnico t: tecnicos ){
            List<Incidente> resueltosPorTecnico = incidentes.stream().filter(h -> h.ocurrioHaceNdias(n) && h.getTecnicoAsignado() == t && h.especialidadCapacitada(e) ).collect(Collectors.toList());
            if (resueltosPorTecnico.size() > topIncidentesResueltos) {
                tecnicoTop = t;
                topIncidentesResueltos = resueltosPorTecnico.size();
            }
        }
        return tecnicoTop;
    };

    RankingTecnicos lambdaTecnicoMasRapido = (n) -> {
        List<Tecnico> tecnicos = repoTecnico.getTecnicos();
        List<Incidente> incidentes = repoIncidentes.getIncidentes();
        Tecnico tecnicoTop = tecnicos.get(0);
        float mejorPromedioTiempo = 0;
        for (Tecnico t: tecnicos) {
            List<Incidente> resueltosPorTecnico = incidentes.stream().filter(h -> h.ocurrioHaceNdias(n) && h.getTecnicoAsignado() == t).collect(Collectors.toList());
            float promedioTiempo = resueltosPorTecnico.stream().mapToLong(incidente -> incidente.getFechaResolucion() - incidente.getFechaCreacion()).boxed().collect(Collectors.summingLong(Long::longValue));
            if (promedioTiempo / resueltosPorTecnico.size() < mejorPromedioTiempo || mejorPromedioTiempo == 0){
                tecnicoTop = t;
                mejorPromedioTiempo = promedioTiempo;
            }
        }
        return tecnicoTop;
    };

    public static void main(String[] args) {


        ServicioRepositorio repoServicio = new ServicioRepositorio();
//        repoServicio.getServicios().forEach(System.out::println);
//
//        Servicio s = repoServicio.getServiciosPorNombre("Implementación y Actualización de Sistemas SAP");
//        System.out.println(s);
//
        EspecialidadesRepositorio repoEspecialidades = new EspecialidadesRepositorio();
//        repoEspecialidades.getEspecialidades().forEach(System.out::println);
//
//        Especialidad e = repoEspecialidades.getNombreEspecialidad("Integración de Sistemas SAP");
//        System.out.println(e);
//
        TipoProblemaRepositorio repoTipoProblema = new TipoProblemaRepositorio();
//        repoTipoProblema.getTipoProblema().forEach(System.out::println);
//
//        TipoProblema tp = repoTipoProblema.getTipoProblemaxnombre("Problemas de Configuración");
//        System.out.println(tp);
//
        ProblemaRepositorio repoProblema = new ProblemaRepositorio();
//        repoProblema.getProblemas().forEach(System.out::println);
//
//        Problema p = repoProblema.getProblema("01/12/2023");
//        System.out.println(p);
//
        ClienteRepositorio repoCliente = new ClienteRepositorio();
//        repoCliente.getClientes().forEach(System.out::println);
//
//        Cliente c = repoCliente.getClientesPorCUIT("30-123456789-8");
//        System.out.println(c);
//
        EstimacionRepositorio repoEstimaciones = new EstimacionRepositorio();
//        repoEstimaciones.getEstimacion().forEach(System.out::println);
//
//        Estimacion est = repoEstimaciones.getEstimacionXCantHsEst(5);
//        System.out.println(est);
//
        TecnicoRepositorio repoTecnico = new TecnicoRepositorio();
//        repoTecnico.getTecnicos().forEach(System.out::println);
//
//        Tecnico t = repoTecnico.getNombreTecnico("Gerardo");
//        System.out.println(t);
//
        IncidenteRepositorio repoIncidentes = new IncidenteRepositorio();
//        repoIncidentes.getIncidentes().forEach(System.out::println);
//
//        Incidente inc = repoIncidentes.getIncidentesPorNombre("incidente1");
//        System.out.println(inc);


        // SERVICIOS
        Servicio servicio1 = new Servicio("Implementación y Actualización de Sistemas SAP", "Ofrecemos servicios completos desde la implementación inicial hasta las actualizaciones periódicas de sistemas SAP");
        Servicio servicio2 = new Servicio("Soporte Técnico Remoto para MacOS", "Brindamos asistencia técnica remota especializada para resolver problemas en entornos MacOS");
        Servicio servicio3 = new Servicio("Desarrollo de Aplicaciones Tango", "Nuestro servicio de desarrollo a medida crea aplicaciones Tango adaptadas a las necesidades únicas de su empresa");
        Servicio servicio4 = new Servicio("Implementación y Actualización de Sistemas SAP", "Ofrecemos servicios completos desde la implementación inicial hasta las actualizaciones periódicas de sistemas SAP");
        Servicio servicio5 = new Servicio("Soporte Técnico Remoto para MacOS", "Brindamos asistencia técnica remota especializada para resolver problemas en entornos MacOS");
        Servicio servicio6 = new Servicio("Desarrollo de Aplicaciones Tango", "Nuestro servicio de desarrollo a medida crea aplicaciones Tango adaptadas a las necesidades únicas de su empresa");
        Servicio servicio7 = new Servicio("Implementación y Actualización de Sistemas SAP", "Ofrecemos servicios completos desde la implementación inicial hasta las actualizaciones periódicas de sistemas SAP");
        Servicio servicio8 = new Servicio("Soporte Técnico Remoto para MacOS", "Brindamos asistencia técnica remota especializada para resolver problemas en entornos MacOS");
        Servicio servicio9 = new Servicio("Desarrollo de Aplicaciones Tango", "Nuestro servicio de desarrollo a medida crea aplicaciones Tango adaptadas a las necesidades únicas de su empresa");
        Servicio servicio10 = new Servicio("Implementación y Actualización de Sistemas SAP", "Ofrecemos servicios completos desde la implementación inicial hasta las actualizaciones periódicas de sistemas SAP");
        Servicio servicio11 = new Servicio("Soporte Técnico Remoto para MacOS", "Brindamos asistencia técnica remota especializada para resolver problemas en entornos MacOS");
        Servicio servicio12 = new Servicio("Desarrollo de Aplicaciones Tango", "Nuestro servicio de desarrollo a medida crea aplicaciones Tango adaptadas a las necesidades únicas de su empresa");

        repoServicio.guardarServicio(servicio1);
        repoServicio.guardarServicio(servicio2);
        repoServicio.guardarServicio(servicio3);
        repoServicio.guardarServicio(servicio4);
        repoServicio.guardarServicio(servicio5);
        repoServicio.guardarServicio(servicio6);
        repoServicio.guardarServicio(servicio7);
        repoServicio.guardarServicio(servicio8);
        repoServicio.guardarServicio(servicio9);
        repoServicio.guardarServicio(servicio10);
        repoServicio.guardarServicio(servicio11);
        repoServicio.guardarServicio(servicio12);

        // ESPECIALIDADES
        List<Especialidad> especialidades = new ArrayList<>();

        Especialidad especialidad1 = new Especialidad("Integración de Sistemas SAP", "Dificultades en la integración de sistemas SAP con otras plataformas");
        Especialidad especialidad2 = new Especialidad("Conflictos de Compatibilidad en MacOS", "Problemas de compatibilidad entre aplicaciones empresariales");
        Especialidad especialidad3 = new Especialidad("Errores en la Configuración de Aplicaciones Tango", "Desafíos relacionados con la configuración incorrecta de aplicaciones Tango");
        Especialidad especialidad4 = new Especialidad("Integración de Sistemas Windows", "Dificultades en la integración de sistemas SAP con otras plataformas");
        Especialidad especialidad5 = new Especialidad("Conflictos de Compatibilidad en MacOS", "Problemas de compatibilidad entre aplicaciones empresariales");
        Especialidad especialidad6 = new Especialidad("Errores en la Configuración de Aplicaciones Tango", "Desafíos relacionados con la configuración incorrecta de aplicaciones Tango");
        Especialidad especialidad7 = new Especialidad("Integración de Sistemas SAP", "Dificultades en la integración de sistemas SAP con otras plataformas");
        Especialidad especialidad8 = new Especialidad("Conflictos de Compatibilidad en MacOS", "Problemas de compatibilidad entre aplicaciones empresariales");
        Especialidad especialidad9 = new Especialidad("Errores en la Configuración de Aplicaciones Tango", "Desafíos relacionados con la configuración incorrecta de aplicaciones Tango");
        Especialidad especialidad10 = new Especialidad("Integración de Sistemas SAP", "Dificultades en la integración de sistemas SAP con otras plataformas");
        Especialidad especialidad11 = new Especialidad("Conflictos de Compatibilidad en Windows", "Problemas de compatibilidad entre aplicaciones empresariales");
        Especialidad especialidad12 = new Especialidad("Errores en la Configuración de Aplicaciones Tango", "Desafíos relacionados con la configuración incorrecta de aplicaciones Tango");

        repoEspecialidades.guardarEspecialidades(especialidad1);
        repoEspecialidades.guardarEspecialidades(especialidad2);
        repoEspecialidades.guardarEspecialidades(especialidad3);
        repoEspecialidades.guardarEspecialidades(especialidad4);
        repoEspecialidades.guardarEspecialidades(especialidad5);
        repoEspecialidades.guardarEspecialidades(especialidad6);
        repoEspecialidades.guardarEspecialidades(especialidad7);
        repoEspecialidades.guardarEspecialidades(especialidad8);
        repoEspecialidades.guardarEspecialidades(especialidad9);
        repoEspecialidades.guardarEspecialidades(especialidad10);
        repoEspecialidades.guardarEspecialidades(especialidad11);
        repoEspecialidades.guardarEspecialidades(especialidad12);

        especialidad1.agregarEspecialidad(especialidad1);
        especialidad2.agregarEspecialidad(especialidad2);
        especialidad3.agregarEspecialidad(especialidad3);
        especialidad1.agregarEspecialidad(especialidad4);
        especialidad2.agregarEspecialidad(especialidad5);
        especialidad3.agregarEspecialidad(especialidad6);
        especialidad1.agregarEspecialidad(especialidad7);
        especialidad2.agregarEspecialidad(especialidad8);
        especialidad3.agregarEspecialidad(especialidad9);
        especialidad1.agregarEspecialidad(especialidad10);
        especialidad2.agregarEspecialidad(especialidad11);
        especialidad3.agregarEspecialidad(especialidad12);

        repoEspecialidades.actualizarEspecialidades(especialidad1);
        repoEspecialidades.actualizarEspecialidades(especialidad2);
        repoEspecialidades.actualizarEspecialidades(especialidad3);
        repoEspecialidades.actualizarEspecialidades(especialidad4);
        repoEspecialidades.actualizarEspecialidades(especialidad5);
        repoEspecialidades.actualizarEspecialidades(especialidad6);
        repoEspecialidades.actualizarEspecialidades(especialidad7);
        repoEspecialidades.actualizarEspecialidades(especialidad8);
        repoEspecialidades.actualizarEspecialidades(especialidad9);
        repoEspecialidades.actualizarEspecialidades(especialidad10);
        repoEspecialidades.actualizarEspecialidades(especialidad11);
        repoEspecialidades.actualizarEspecialidades(especialidad12);

        // TIPOS DE PROBLEMAS
        TipoProblema tipoProblema1 = new TipoProblema("Problemas de Configuración", "Dificultades relacionadas con la configuración inicial", 4, especialidades);
        TipoProblema tipoProblema2 = new TipoProblema("Errores de Integración", "Desafíos asociados con la correcta integración de aplicaciones empresariales", 5, especialidades);
        TipoProblema tipoProblema3 = new TipoProblema("Conflictos de Software", "Problemas derivados de conflictos de software", 6, especialidades);
        TipoProblema tipoProblema4 = new TipoProblema("Problemas de Configuración", "Dificultades relacionadas con la configuración inicial", 4, especialidades);
        TipoProblema tipoProblema5 = new TipoProblema("Errores de Integración", "Desafíos asociados con la correcta integración de aplicaciones empresariales", 3, especialidades);
        TipoProblema tipoProblema6 = new TipoProblema("Conflictos de Software", "Problemas derivados de conflictos de software", 3, especialidades);
        TipoProblema tipoProblema7 = new TipoProblema("Problemas de Configuración", "Dificultades relacionadas con la configuración inicial", 4, especialidades);
        TipoProblema tipoProblema8 = new TipoProblema("Errores de Integración", "Desafíos asociados con la correcta integración de aplicaciones empresariales", 6, especialidades);
        TipoProblema tipoProblema9 = new TipoProblema("Conflictos de Software", "Problemas derivados de conflictos de software", 4, especialidades);
        TipoProblema tipoProblema10 = new TipoProblema("Problemas de Configuración", "Dificultades relacionadas con la configuración inicial", 3, especialidades);
        TipoProblema tipoProblema11 = new TipoProblema("Errores de Integración", "Desafíos asociados con la correcta integración de aplicaciones empresariales", 3, especialidades);
        TipoProblema tipoProblema12 = new TipoProblema("Conflictos de Software", "Problemas derivados de conflictos de software", 4, especialidades);

        repoTipoProblema.guardarTipoProblema(tipoProblema1);
        repoTipoProblema.guardarTipoProblema(tipoProblema2);
        repoTipoProblema.guardarTipoProblema(tipoProblema3);
        repoTipoProblema.guardarTipoProblema(tipoProblema4);
        repoTipoProblema.guardarTipoProblema(tipoProblema5);
        repoTipoProblema.guardarTipoProblema(tipoProblema6);
        repoTipoProblema.guardarTipoProblema(tipoProblema7);
        repoTipoProblema.guardarTipoProblema(tipoProblema8);
        repoTipoProblema.guardarTipoProblema(tipoProblema9);
        repoTipoProblema.guardarTipoProblema(tipoProblema10);
        repoTipoProblema.guardarTipoProblema(tipoProblema11);
        repoTipoProblema.guardarTipoProblema(tipoProblema12);

        tipoProblema1.agregarTipoProblema(tipoProblema1);
        tipoProblema2.agregarTipoProblema(tipoProblema2);
        tipoProblema3.agregarTipoProblema(tipoProblema3);
        tipoProblema1.agregarTipoProblema(tipoProblema4);
        tipoProblema2.agregarTipoProblema(tipoProblema5);
        tipoProblema3.agregarTipoProblema(tipoProblema6);
        tipoProblema1.agregarTipoProblema(tipoProblema7);
        tipoProblema2.agregarTipoProblema(tipoProblema8);
        tipoProblema3.agregarTipoProblema(tipoProblema9);
        tipoProblema1.agregarTipoProblema(tipoProblema10);
        tipoProblema2.agregarTipoProblema(tipoProblema11);
        tipoProblema3.agregarTipoProblema(tipoProblema12);

        repoTipoProblema.actualizarTipoProblema(tipoProblema1);
        repoTipoProblema.actualizarTipoProblema(tipoProblema2);
        repoTipoProblema.actualizarTipoProblema(tipoProblema3);
        repoTipoProblema.actualizarTipoProblema(tipoProblema4);
        repoTipoProblema.actualizarTipoProblema(tipoProblema5);
        repoTipoProblema.actualizarTipoProblema(tipoProblema6);
        repoTipoProblema.actualizarTipoProblema(tipoProblema7);
        repoTipoProblema.actualizarTipoProblema(tipoProblema8);
        repoTipoProblema.actualizarTipoProblema(tipoProblema9);
        repoTipoProblema.actualizarTipoProblema(tipoProblema10);
        repoTipoProblema.actualizarTipoProblema(tipoProblema11);
        repoTipoProblema.actualizarTipoProblema(tipoProblema12);

        // PROBLEMAS
        Problema problema1 = new Problema(servicio1, tipoProblema1, "01/12/2023", "14/12/2023", "errores críticos");
        Problema problema2 = new Problema(servicio2, tipoProblema2, "02/12/2023", "08/12/2023", "errores múltiples");
        Problema problema3 = new Problema(servicio3, tipoProblema3, "03/12/2023", "14/12/2023", "Software Obsoleto");
        Problema problema4 = new Problema(servicio1, tipoProblema4, "01/12/2023", "14/12/2023", "errores críticos");
        Problema problema5 = new Problema(servicio2, tipoProblema5, "02/12/2023", "08/12/2023", "errores múltiples");
        Problema problema6 = new Problema(servicio3, tipoProblema6, "03/12/2023", "14/12/2023", "Software Obsoleto");
        Problema problema7 = new Problema(servicio1, tipoProblema7, "01/12/2023", "14/12/2023", "errores críticos");
        Problema problema8 = new Problema(servicio2, tipoProblema8, "02/12/2023", "08/12/2023", "errores múltiples");
        Problema problema9 = new Problema(servicio3, tipoProblema9, "03/12/2023", "14/12/2023", "Software Obsoleto");
        Problema problema10 = new Problema(servicio1, tipoProblema10, "01/12/2023", "14/12/2023", "errores críticos");
        Problema problema11 = new Problema(servicio2, tipoProblema11, "02/12/2023", "08/12/2023", "errores múltiples");
        Problema problema12 = new Problema(servicio3, tipoProblema12, "03/12/2023", "14/12/2023", "Software Obsoleto");

        repoProblema.guardarProblema(problema1);
        repoProblema.guardarProblema(problema2);
        repoProblema.guardarProblema(problema3);
        repoProblema.guardarProblema(problema4);
        repoProblema.guardarProblema(problema5);
        repoProblema.guardarProblema(problema6);
        repoProblema.guardarProblema(problema7);
        repoProblema.guardarProblema(problema8);
        repoProblema.guardarProblema(problema9);
        repoProblema.guardarProblema(problema10);
        repoProblema.guardarProblema(problema11);
        repoProblema.guardarProblema(problema12);

        // CLIENTE
        Cliente cliente1 = new Cliente("Disco", "30-123456789-8");
        Cliente cliente2 = new Cliente("Farmacity", "30-987654321-5");
        Cliente cliente3 = new Cliente("Coto", "30-905621321-5");
        Cliente cliente4 = new Cliente("Diarco", "30-122116789-8");
        Cliente cliente5 = new Cliente("Fiat", "30-982114321-5");
        Cliente cliente6 = new Cliente("Farmacity", "30-987654321-5");
        Cliente cliente7 = new Cliente("Disco", "30-123456789-8");
        Cliente cliente8 = new Cliente("Ford", "30-987635321-5");
        Cliente cliente9 = new Cliente("Apple", "30-998421321-5");
        Cliente cliente10 = new Cliente("Samsung", "30-123854789-8");
        Cliente cliente11 = new Cliente("Nokia", "30-905352321-5");
        Cliente cliente12 = new Cliente("Coto", "30-905621321-5");

        repoCliente.guardarCliente(cliente1);
        repoCliente.guardarCliente(cliente2);
        repoCliente.guardarCliente(cliente3);
        repoCliente.guardarCliente(cliente4);
        repoCliente.guardarCliente(cliente5);
        repoCliente.guardarCliente(cliente6);
        repoCliente.guardarCliente(cliente7);
        repoCliente.guardarCliente(cliente8);
        repoCliente.guardarCliente(cliente9);
        repoCliente.guardarCliente(cliente10);
        repoCliente.guardarCliente(cliente11);
        repoCliente.guardarCliente(cliente12);

        servicio1.agregarListaProblemas(tipoProblema1);
        servicio2.agregarListaProblemas(tipoProblema2);
        servicio3.agregarListaProblemas(tipoProblema3);
        servicio4.agregarListaProblemas(tipoProblema4);
        servicio5.agregarListaProblemas(tipoProblema5);
        servicio6.agregarListaProblemas(tipoProblema6);
        servicio7.agregarListaProblemas(tipoProblema7);
        servicio8.agregarListaProblemas(tipoProblema8);
        servicio9.agregarListaProblemas(tipoProblema9);
        servicio10.agregarListaProblemas(tipoProblema10);
        servicio11.agregarListaProblemas(tipoProblema11);
        servicio12.agregarListaProblemas(tipoProblema12);

        repoServicio.actualizarServicio(servicio1);
        repoServicio.actualizarServicio(servicio2);
        repoServicio.actualizarServicio(servicio3);
        repoServicio.actualizarServicio(servicio4);
        repoServicio.actualizarServicio(servicio5);
        repoServicio.actualizarServicio(servicio6);
        repoServicio.actualizarServicio(servicio7);
        repoServicio.actualizarServicio(servicio8);
        repoServicio.actualizarServicio(servicio9);
        repoServicio.actualizarServicio(servicio10);
        repoServicio.actualizarServicio(servicio11);
        repoServicio.actualizarServicio(servicio12);

        cliente1.agregarServiciosContratados(servicio1);
        cliente2.agregarServiciosContratados(servicio2);
        cliente3.agregarServiciosContratados(servicio3);
        cliente4.agregarServiciosContratados(servicio4);
        cliente5.agregarServiciosContratados(servicio5);
        cliente6.agregarServiciosContratados(servicio6);
        cliente7.agregarServiciosContratados(servicio7);
        cliente8.agregarServiciosContratados(servicio8);
        cliente9.agregarServiciosContratados(servicio9);
        cliente10.agregarServiciosContratados(servicio10);
        cliente11.agregarServiciosContratados(servicio11);
        cliente12.agregarServiciosContratados(servicio12);

        repoCliente.actualizarCliente(cliente1);
        repoCliente.actualizarCliente(cliente2);
        repoCliente.actualizarCliente(cliente3);
        repoCliente.actualizarCliente(cliente4);
        repoCliente.actualizarCliente(cliente5);
        repoCliente.actualizarCliente(cliente6);
        repoCliente.actualizarCliente(cliente7);
        repoCliente.actualizarCliente(cliente8);
        repoCliente.actualizarCliente(cliente9);
        repoCliente.actualizarCliente(cliente10);
        repoCliente.actualizarCliente(cliente11);
        repoCliente.actualizarCliente(cliente12);

        //ESTIMACION CANTIDAD DE HORAS ESTIMADAS POR EL TECNICO
        EstimacionRepositorio repoEstimacion = new EstimacionRepositorio();

        Estimacion estimacion1 = new Estimacion(3, tipoProblema1);
        Estimacion estimacion2 = new Estimacion(1, tipoProblema2);
        Estimacion estimacion3 = new Estimacion(2, tipoProblema3);
        Estimacion estimacion4 = new Estimacion(3, tipoProblema4);
        Estimacion estimacion5 = new Estimacion(2, tipoProblema5);
        Estimacion estimacion6 = new Estimacion(2, tipoProblema6);
        Estimacion estimacion7 = new Estimacion(1, tipoProblema7);
        Estimacion estimacion8 = new Estimacion(1, tipoProblema8);
        Estimacion estimacion9 = new Estimacion(2, tipoProblema9);
        Estimacion estimacion10 = new Estimacion(3, tipoProblema10);
        Estimacion estimacion11 = new Estimacion(2, tipoProblema11);
        Estimacion estimacion12 = new Estimacion(3, tipoProblema12);

        repoEstimacion.guardarEstimacion(estimacion1);
        repoEstimacion.guardarEstimacion(estimacion2);
        repoEstimacion.guardarEstimacion(estimacion3);
        repoEstimacion.guardarEstimacion(estimacion4);
        repoEstimacion.guardarEstimacion(estimacion5);
        repoEstimacion.guardarEstimacion(estimacion6);
        repoEstimacion.guardarEstimacion(estimacion7);
        repoEstimacion.guardarEstimacion(estimacion8);
        repoEstimacion.guardarEstimacion(estimacion9);
        repoEstimacion.guardarEstimacion(estimacion10);
        repoEstimacion.guardarEstimacion(estimacion11);
        repoEstimacion.guardarEstimacion(estimacion12);

        estimacion1.agregarEstimacion(estimacion1);
        estimacion2.agregarEstimacion(estimacion2);
        estimacion3.agregarEstimacion(estimacion3);
        estimacion1.agregarEstimacion(estimacion4);
        estimacion2.agregarEstimacion(estimacion5);
        estimacion3.agregarEstimacion(estimacion6);
        estimacion1.agregarEstimacion(estimacion7);
        estimacion2.agregarEstimacion(estimacion8);
        estimacion3.agregarEstimacion(estimacion9);
        estimacion1.agregarEstimacion(estimacion10);
        estimacion2.agregarEstimacion(estimacion11);
        estimacion3.agregarEstimacion(estimacion12);

        repoEstimacion.actualizarEstimacion(estimacion1);
        repoEstimacion.actualizarEstimacion(estimacion2);
        repoEstimacion.actualizarEstimacion(estimacion3);
        repoEstimacion.actualizarEstimacion(estimacion4);
        repoEstimacion.actualizarEstimacion(estimacion5);
        repoEstimacion.actualizarEstimacion(estimacion6);
        repoEstimacion.actualizarEstimacion(estimacion7);
        repoEstimacion.actualizarEstimacion(estimacion8);
        repoEstimacion.actualizarEstimacion(estimacion9);
        repoEstimacion.actualizarEstimacion(estimacion10);
        repoEstimacion.actualizarEstimacion(estimacion11);
        repoEstimacion.actualizarEstimacion(estimacion12);

        // TECNICOS
        Tecnico tecnico1 = new Tecnico("Gerardo", especialidades, true, Collections.singletonList(estimacion1));
        Tecnico tecnico2 = new Tecnico("Jorge", especialidades, true, Collections.singletonList(estimacion2));
        Tecnico tecnico3 = new Tecnico("Gerardo", especialidades, true, Collections.singletonList(estimacion3));
        Tecnico tecnico4 = new Tecnico("Horacio", especialidades, true, Collections.singletonList(estimacion4));
        Tecnico tecnico5 = new Tecnico("Sergio", especialidades, false, Collections.singletonList(estimacion5));
        Tecnico tecnico6 = new Tecnico("Gerardo", especialidades, true, Collections.singletonList(estimacion6));
        Tecnico tecnico7 = new Tecnico("Sergio", especialidades, true, Collections.singletonList(estimacion7));
        Tecnico tecnico8 = new Tecnico("Jorge", especialidades, false, Collections.singletonList(estimacion8));
        Tecnico tecnico9 = new Tecnico("Gerardo", especialidades, true, Collections.singletonList(estimacion9));
        Tecnico tecnico10 = new Tecnico("Jorge", especialidades, true, Collections.singletonList(estimacion10));
        Tecnico tecnico11 = new Tecnico("Horacio", especialidades, true, Collections.singletonList(estimacion11));
        Tecnico tecnico12 = new Tecnico("Jorge", especialidades, false, Collections.singletonList(estimacion12));

        repoTecnico.guardarTecnico(tecnico1);
        repoTecnico.guardarTecnico(tecnico2);
        repoTecnico.guardarTecnico(tecnico3);
        repoTecnico.guardarTecnico(tecnico4);
        repoTecnico.guardarTecnico(tecnico5);
        repoTecnico.guardarTecnico(tecnico6);
        repoTecnico.guardarTecnico(tecnico7);
        repoTecnico.guardarTecnico(tecnico8);
        repoTecnico.guardarTecnico(tecnico9);
        repoTecnico.guardarTecnico(tecnico10);
        repoTecnico.guardarTecnico(tecnico11);
        repoTecnico.guardarTecnico(tecnico12);

        tecnico1.agregarEspecialidad(especialidad3);
        tecnico2.agregarEspecialidad(especialidad1);
        tecnico3.agregarEspecialidad(especialidad2);
        tecnico1.agregarEspecialidad(especialidad4);
        tecnico2.agregarEspecialidad(especialidad5);
        tecnico3.agregarEspecialidad(especialidad6);
        tecnico1.agregarEspecialidad(especialidad7);
        tecnico2.agregarEspecialidad(especialidad8);
        tecnico3.agregarEspecialidad(especialidad9);
        tecnico1.agregarEspecialidad(especialidad10);
        tecnico2.agregarEspecialidad(especialidad11);
        tecnico3.agregarEspecialidad(especialidad12);

        repoTecnico.actualizarTecnico(tecnico1);
        repoTecnico.actualizarTecnico(tecnico2);
        repoTecnico.actualizarTecnico(tecnico3);
        repoTecnico.actualizarTecnico(tecnico4);
        repoTecnico.actualizarTecnico(tecnico5);
        repoTecnico.actualizarTecnico(tecnico6);
        repoTecnico.actualizarTecnico(tecnico7);
        repoTecnico.actualizarTecnico(tecnico8);
        repoTecnico.actualizarTecnico(tecnico9);
        repoTecnico.actualizarTecnico(tecnico10);
        repoTecnico.actualizarTecnico(tecnico11);
        repoTecnico.actualizarTecnico(tecnico12);

        tecnico1.agregarHorasEstimadasResolucion(estimacion1);
        tecnico2.agregarHorasEstimadasResolucion(estimacion2);
        tecnico3.agregarHorasEstimadasResolucion(estimacion2);
        tecnico4.agregarHorasEstimadasResolucion(estimacion3);
        tecnico5.agregarHorasEstimadasResolucion(estimacion4);
        tecnico6.agregarHorasEstimadasResolucion(estimacion5);
        tecnico7.agregarHorasEstimadasResolucion(estimacion10);
        tecnico8.agregarHorasEstimadasResolucion(estimacion1);
        tecnico9.agregarHorasEstimadasResolucion(estimacion11);
        tecnico10.agregarHorasEstimadasResolucion(estimacion8);
        tecnico11.agregarHorasEstimadasResolucion(estimacion9);
        tecnico12.agregarHorasEstimadasResolucion(estimacion10);

        repoTecnico.actualizarTecnico(tecnico1);
        repoTecnico.actualizarTecnico(tecnico2);
        repoTecnico.actualizarTecnico(tecnico3);
        repoTecnico.actualizarTecnico(tecnico4);
        repoTecnico.actualizarTecnico(tecnico5);
        repoTecnico.actualizarTecnico(tecnico6);
        repoTecnico.actualizarTecnico(tecnico7);
        repoTecnico.actualizarTecnico(tecnico8);
        repoTecnico.actualizarTecnico(tecnico9);
        repoTecnico.actualizarTecnico(tecnico10);
        repoTecnico.actualizarTecnico(tecnico11);
        repoTecnico.actualizarTecnico(tecnico12);

        // INCIDENTES
        IncidenteRepositorio repoIncidente = new IncidenteRepositorio();

        Incidente incidente1 = new Incidente("incidente1", Collections.singletonList(problema1), servicio1, tecnico1, EstadoIncidente.Abierto, "02/11/23", "05/12/2023");
        Incidente incidente2 = new Incidente("incidente2", Collections.singletonList(problema2), servicio2, tecnico2, EstadoIncidente.En_Proceso, "04/11/23", "01/12/2023");
        Incidente incidente3 = new Incidente("incidente3", Collections.singletonList(problema3), servicio3, tecnico3, EstadoIncidente.Resuelto, "10/11/23", "28/11/2023");
        Incidente incidente4 = new Incidente("incidente4", Collections.singletonList(problema4), servicio4, tecnico4, EstadoIncidente.Abierto, "20/11/23", "22/11/2023");
        Incidente incidente5 = new Incidente("incidente5", Collections.singletonList(problema5), servicio5, tecnico5, EstadoIncidente.Resuelto, "01/11/23", "11/11/2023");
        Incidente incidente6 = new Incidente("incidente6", Collections.singletonList(problema6), servicio6, tecnico6, EstadoIncidente.Resuelto, "09/11/23", "15/11/2023");
        Incidente incidente7 = new Incidente("incidente7", Collections.singletonList(problema7), servicio7, tecnico7, EstadoIncidente.Resuelto, "02/11/23", "05/11/2023");
        Incidente incidente8 = new Incidente("incidente8", Collections.singletonList(problema8), servicio8, tecnico8, EstadoIncidente.En_Proceso, "08/11/23", "09/11/2023");
        Incidente incidente9 = new Incidente("incidente9", Collections.singletonList(problema9), servicio9, tecnico9, EstadoIncidente.Resuelto, "06/11/23", "07/11/2023");
        Incidente incidente10 = new Incidente("incidente10", Collections.singletonList(problema10), servicio10, tecnico10, EstadoIncidente.Abierto, "05/11/23", "06/11/2023");
        Incidente incidente11 = new Incidente("incidente11", Collections.singletonList(problema11), servicio11, tecnico11, EstadoIncidente.Resuelto, "04/11/23", "05/11/2023");
        Incidente incidente12 = new Incidente("incidente12", Collections.singletonList(problema12), servicio12, tecnico12, EstadoIncidente.Resuelto, "02/11/23", "03/11/2023");

        repoIncidente.guardarIncidente(incidente1);
        repoIncidente.guardarIncidente(incidente2);
        repoIncidente.guardarIncidente(incidente3);
        repoIncidente.guardarIncidente(incidente4);
        repoIncidente.guardarIncidente(incidente5);
        repoIncidente.guardarIncidente(incidente6);
        repoIncidente.guardarIncidente(incidente7);
        repoIncidente.guardarIncidente(incidente8);
        repoIncidente.guardarIncidente(incidente9);
        repoIncidente.guardarIncidente(incidente10);
        repoIncidente.guardarIncidente(incidente11);
        repoIncidente.guardarIncidente(incidente12);

        Incidente.agregarIncidente(incidente1);
        Incidente.agregarIncidente(incidente2);
        Incidente.agregarIncidente(incidente3);
        Incidente.agregarIncidente(incidente4);
        Incidente.agregarIncidente(incidente5);
        Incidente.agregarIncidente(incidente6);
        Incidente.agregarIncidente(incidente7);
        Incidente.agregarIncidente(incidente8);
        Incidente.agregarIncidente(incidente9);
        Incidente.agregarIncidente(incidente10);
        Incidente.agregarIncidente(incidente11);
        Incidente.agregarIncidente(incidente12);

        repoIncidente.actualizarIncidente(incidente1);
        repoIncidente.actualizarIncidente(incidente2);
        repoIncidente.actualizarIncidente(incidente3);
        repoIncidente.actualizarIncidente(incidente4);
        repoIncidente.actualizarIncidente(incidente5);
        repoIncidente.actualizarIncidente(incidente6);
        repoIncidente.actualizarIncidente(incidente7);
        repoIncidente.actualizarIncidente(incidente8);
        repoIncidente.actualizarIncidente(incidente9);
        repoIncidente.actualizarIncidente(incidente10);
        repoIncidente.actualizarIncidente(incidente11);
        repoIncidente.actualizarIncidente(incidente12);

    }

}