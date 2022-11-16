/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.CharacterSheet.dao;

import com.mthree.CharacterSheet.dto.CharacterClass;
import java.util.List;

/**
 *
 * @author Josef
 */
public interface ClassDao {
    CharacterClass getClassById(int id);
    List<CharacterClass> getAllClassesBase();
    CharacterClass addClassBase(CharacterClass cla);
    void updateLocation(CharacterClass cla);
    void deleteLocationById(int id);
}
