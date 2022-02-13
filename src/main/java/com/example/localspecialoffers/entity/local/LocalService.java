package com.example.localspecialoffers.entity.local;

import java.util.List;

public interface LocalService {
    List<Local> findAll();

    Local save(Local local);

}
