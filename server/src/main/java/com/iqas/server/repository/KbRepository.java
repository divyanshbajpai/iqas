package com.iqas.server.repository;

import com.iqas.server.model.KbModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface KbRepository  extends MongoRepository<KbModel,String> {

}
