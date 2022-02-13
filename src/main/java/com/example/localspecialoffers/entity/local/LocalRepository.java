package com.example.localspecialoffers.entity.local;

import java.util.List;

public interface LocalRepository {
    List<Local> findAll();

    Local save(Local local);
}
