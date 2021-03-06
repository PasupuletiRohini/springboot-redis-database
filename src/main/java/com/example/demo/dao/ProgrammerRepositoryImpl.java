package com.example.demo.dao;

import com.example.demo.model.Programmer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.TimeUnit;
@Repository
public class ProgrammerRepositoryImpl implements ProgrammerRepository{
    public static final String REDIS_LIST_KEY = "ProgrammerList";

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    @Qualifier("listOperations")
    private ListOperations<String, Programmer> ListOps;

    @Override
    public void setProgrammerAsString(String idKey, String programmer) {
        // opsForValue is used for String data type
        redisTemplate.opsForValue().set(idKey, programmer);
        //redisTemplate.expire(idKey, 10, TimeUnit.SECONDS);
    }

    @Override
    public String getProgrammerAsString(String idKey) {
        return (String) redisTemplate.opsForValue().get(idKey);
    }

    //// ********** List *************
    @Override
    public void AddToProgrammersList(Programmer programmer) {
        ListOps.leftPush(REDIS_LIST_KEY, programmer);
    }

    @Override
    public List<Programmer> getProgrammersListMembers() {
        return ListOps.range(REDIS_LIST_KEY, 0, -1);
    }

    @Override
    public Long getProgrammersListCount() {
        return ListOps.size(REDIS_LIST_KEY);
    }
}
