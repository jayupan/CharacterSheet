/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.CharacterSheet.dao;

import com.mthree.CharacterSheet.dto.CharacterClass;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Josef
 */
@Repository
public class ClassDaoDB implements ClassDao{
    @Autowired
    JdbcTemplate jdbc;
    
    @Override
    public CharacterClass getClassById(int id)
    {
         try {
            final String GET_CLASS_BY_ID = "SELECT * FROM Class WHERE class_id = ?";
            return jdbc.queryForObject(GET_CLASS_BY_ID, new ClassMapper(), id);
            
        } catch (DataAccessException ex)
        {
            return null;
        }
    }
    
    @Override
    public List<CharacterClass> getAllClassesBase()
    {
        final String GET_ALL_CLASS = "SELECT * FROM Class";
        return jdbc.query(GET_ALL_CLASS, new ClassMapper());
    }
    
    @Override
    public CharacterClass addClassBase(CharacterClass cla)
    {
        return  new CharacterClass();
    }
    
    @Override
    public void updateLocation(CharacterClass cla)
    {
        
    }
    
    @Override
    public void deleteLocationById(int id)
    {
        
    }
    
    public static final class ClassMapper implements RowMapper<CharacterClass>
    {
        @Override
        public CharacterClass mapRow(ResultSet rs, int index) throws SQLException 
        {
            CharacterClass cla = new CharacterClass();
            cla.setId(rs.getInt("loc_id"));
            cla.setName(rs.getString("name"));
            return cla;
        }
    }
}
