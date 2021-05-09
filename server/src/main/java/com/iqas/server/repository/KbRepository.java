package com.iqas.server.repository;

import com.iqas.server.model.KbModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface KbRepository  extends MongoRepository<KbModel,Integer> {

    @Query(value = "{'kbId': ?0 }")
    KbModel findBykbId(Integer kbId);

}
