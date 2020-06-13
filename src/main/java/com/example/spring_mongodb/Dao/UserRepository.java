package com.example.spring_mongodb.Dao;

import com.example.spring_mongodb.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends MongoRepository<User,Integer> {


    @Query(value = "{ 'nicNo' : ?0 }", fields="{ 'firstName' : 1,'lastName' : 1,'nicNo' : 1 ,'organization' : 1 ,'roleType' : 1}")
    User findroleBynic(@Param("nicNo") String nicNo);

    @Query(value = "{ $and: [ { 'organization' : ?0 }, { 'nicNo' :?1 }]}", fields="{ 'firstName' : 1,'lastName' : 1,'nicNo' : 1 }")
    List<User> findroleByorganizationroletype(@Param("organization") String organization, @Param("nicNo") String nicNo);
}
