package com.example.localspecialoffers.entity.specialOffer;

import com.example.localspecialoffers.entity.local.Local;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

@Repository
@AllArgsConstructor
public class SpecialOfferRepositoryImpl implements SpecialOfferRepository {

    private final JdbcTemplate jdbc;

    @Override
    public SpecialOffer save(Long localId, SpecialOffer specialOffer) {
        Long id = saveSpecialOffer(specialOffer, localId);
        specialOffer.setId(id);
        return specialOffer;
    }

    private Long saveSpecialOffer(SpecialOffer specialOffer, Long localId) {
        PreparedStatementCreatorFactory preparedStatementCreatorFactory = new PreparedStatementCreatorFactory(
                "insert into Special_Offer (name, description, local_id) values (?, ?, ?)",
                Types.VARCHAR, Types.VARCHAR, Types.BIGINT);
        preparedStatementCreatorFactory.setReturnGeneratedKeys(true); //TO RETURN A NEW KEY

        PreparedStatementCreator psc = preparedStatementCreatorFactory
                .newPreparedStatementCreator(
                        List.of(specialOffer.getName(), specialOffer.getDescription(), localId)
                );

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(psc, keyHolder);
        return keyHolder.getKey().longValue();
    }

    @Override
    public SpecialOffer findById(Long id) {
        return jdbc.query("select * from Special_Offer where id = " + id,
                (ResultSetExtractor<SpecialOffer>) rs -> new SpecialOffer(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("description")));
    }

    @Override
    public List<SpecialOffer> findByLocalId(Local local) {
        List<SpecialOffer> specialOffers = jdbc.query("select * from Special_Offer where local_id = " + local.getId(),
                (rs, rowNum) -> new SpecialOffer(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("description"))
        );
        return specialOffers;
    }
}
