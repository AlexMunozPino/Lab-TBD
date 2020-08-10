package cl.tbd.emergencias.Services;

import java.util.List;

import cl.tbd.emergencias.Models.LogTarea;
import cl.tbd.emergencias.Repositories.LogTareaRepository;
import org.springframework.beans.factory.annotation.Autowired;


public class LogTareaServiceImpl implements LogTareaService{

    @Autowired
    private LogTareaRepository logTareaRepository;

    @Override
    public List<LogTarea> getAll() {
        return logTareaRepository.getAll();
    }

    @Override
    public LogTarea getOneById(Integer id){
        return logTareaRepository.getOneById(id);
    }

    @Override
    public boolean insertRandomWithCurrentDate() { return logTareaRepository.insertRandomWithCurrentDate(); }
}