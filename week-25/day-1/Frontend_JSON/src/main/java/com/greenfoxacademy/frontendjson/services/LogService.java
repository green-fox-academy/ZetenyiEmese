package com.greenfoxacademy.frontendjson.services;

import com.greenfoxacademy.frontendjson.models.Log;
import com.greenfoxacademy.frontendjson.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LogService {

  private LogRepository logRepository;

  @Autowired
  public LogService(LogRepository logRepository) {
    this.logRepository = logRepository;
  }

  public void addLog(Log log){
    logRepository.save(log);
  }

  public ArrayList<Log> findAllLogs(){
    ArrayList<Log> logs = new ArrayList<>();
    logRepository.findAll().forEach(logs::add);
    return logs;
  }

}
