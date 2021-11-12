package com.example.starwars.service;

import java.util.List;

import com.example.starwars.model.MissionModel;
import com.example.starwars.repository.MissionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MissionService {

    @Autowired
    private final MissionRepository missionRepository;

    public MissionService(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    public MissionModel addMission(MissionModel missionModel) {
        return this.missionRepository.save(missionModel);
    }

    public List<MissionModel> listAll() {
        return this.missionRepository.findAll();
    }

    public MissionModel searchById(Long id) {
        return this.missionRepository.findById(id).get();
    }

    public MissionModel updateMission(MissionModel missionModel) {
        return this.missionRepository.save(missionModel);
    }

    public void deleteMission(MissionModel missionModel) {
        this.missionRepository.delete(missionModel);
    }

}
