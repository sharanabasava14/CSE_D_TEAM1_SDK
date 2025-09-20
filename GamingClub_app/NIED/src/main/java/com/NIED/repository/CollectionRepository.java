package com.NIED.repository;

import com.NIED.model.Collection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface CollectionRepository extends MongoRepository<Collection, String> {
    
    // Custom query to find a document where the date is within the given day
    @Query("{ 'date' : { $gte: ?0, $lt: ?1 } }")
    Optional<Collection> findByDate(Date startOfDay, Date endOfDay);
}