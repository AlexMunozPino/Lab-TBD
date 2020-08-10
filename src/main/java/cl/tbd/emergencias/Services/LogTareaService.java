package cl.tbd.emergencias.Services;

import java.util.List;

import cl.tbd.emergencias.Models.LogTarea;

public interface LogTareaService {

    List<LogTarea> getAll();

    LogTarea getOneById(Integer id);

    boolean insertRandomWithCurrentDate();
}