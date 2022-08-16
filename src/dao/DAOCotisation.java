/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.ArrayList;
import transfertObject.*;

/**
 *
 * @author MediaMonster
 */
public interface DAOCotisation {
    
    ArrayList selectCotisation ();
    
    boolean deleteCotisation (int idCoti);
    
    boolean updateCotisation (Cotisation coti);
    
    boolean insertCotisation (Cotisation coti);
    
}
