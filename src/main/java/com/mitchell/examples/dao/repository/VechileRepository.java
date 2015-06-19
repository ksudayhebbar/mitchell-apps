package com.mitchell.examples.dao.repository;

import java.util.Date;

import com.mitchell.examples.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VechileRepository extends JpaRepository<Vehicle, String>
{
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Vehicle V SET V.exteriorColor = :exteriorColor ,V.vin = :vin, V.licPlateExpDate = :licPlateExpDate WHERE V.claimNumber = :claimNumber ")
    public void update(@Param("exteriorColor") String exteriorColor, @Param("vin") String vin,
            @Param("licPlateExpDate") Date licPlateExpDate, @Param("claimNumber") String claimNumber);
}