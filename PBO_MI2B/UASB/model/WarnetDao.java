/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UASB.model;

import UASB.model.Warnet;
import java.util.List;

/**
 *
 * @author satri
 */
public interface WarnetDao {
    void save (Warnet warnet);
    void update (int index, Warnet warnet);
    void delete (int index);
    Warnet getWarnet(int index);
    List<Warnet> getAllWarnet();
}
