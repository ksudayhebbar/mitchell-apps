package com.mitchell.examples.dao.repository;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mitchell.examples.entity.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, String>
{

    public List<Claim> findByLossDate(Date date);
}
