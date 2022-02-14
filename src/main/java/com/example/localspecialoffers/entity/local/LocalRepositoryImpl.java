package com.example.localspecialoffers.entity.local;

import com.example.localspecialoffers.entity.specialOffer.SpecialOffer;
import com.example.localspecialoffers.entity.specialOffer.SpecialOfferService;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

@Repository
@AllArgsConstructor
public class LocalRepositoryImpl implements LocalRepository {

    private final JdbcTemplate jdbc;
    private final SpecialOfferService specialOfferService;

    @Override
    public List<Local> findAll() {
        //Locals
        List<Local> locals = jdbc.query("select * from Local_Entity",
                (rs, rowNum) -> new Local(Long.valueOf(rs.getString("id")), rs.getString("name")));
        //Special offers
        for (Local local : locals){
            local.setSpecialOffers(specialOfferService.getSpecialOffersForLocal(local));
        }
        return locals;
    }


    @Override
    public Local save(Local local) {
        Long id = saveLocal(local);
        local.setId(id);
        for (SpecialOffer specialOffer : local.getSpecialOffers())
            specialOfferService.save(id, specialOffer);
        return local;
    }

    private Long saveLocal(Local local){
        PreparedStatementCreatorFactory preparedStatementCreatorFactory = new PreparedStatementCreatorFactory(
                "insert into Local_Entity (name) values (?)",
                Types.VARCHAR);
        preparedStatementCreatorFactory.setReturnGeneratedKeys(true); //TO RETURN A NEW KEY

        PreparedStatementCreator psc = preparedStatementCreatorFactory
                .newPreparedStatementCreator(
                        List.of(local.getName())
                );

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(psc, keyHolder);
        return keyHolder.getKey().longValue();
    }
}
