package com.example.localspecialoffers.entity.local;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LocalServiceImpl implements LocalService {

    private final LocalRepository localRepository;

    @Override
    public List<Local> findAll() {
        return localRepository.findAll();
    }

    @Override
    public Local save(Local local) {
        return localRepository.save(local);
    }
}
