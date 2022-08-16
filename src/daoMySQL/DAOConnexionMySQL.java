/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoMySQL;

import dao.Connexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author MediaMonster
 */
public class DAOConnexionMySQL  implements Connexion
{
    private Connection conn;  //objet de connexion à la BDD
    private Statement stat;   //objet permettant d'effectuer des requêtes simples
    private boolean connected;//variable permettant de savoir si on est connecté à une BDD

    private static DAOConnexionMySQL uniqueInstance = new DAOConnexionMySQL();

    /* Constructeur : ouvre la connexion */
    private DAOConnexionMySQL()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            }
        catch (ClassNotFoundException classe)
            {
            System.out.println(classe.toString());
            }
        connected=false;

        String url = "jdbc:mysql://localhost/dragonsBleus"; //en local
        //String url = "jdbc:mysql://192.168.22.111/grosappareils"; //A  l'école
        try{
            /* setup the properties: si les accents ne sont pas Unicode ds la BDD
            java.util.Properties prop = new java.util.Properties();
            prop.put("charSet", "ISO-8859-15");
            prop.put("user", username);
            prop.put("password", password);*/

            // Connect to the database
            conn=DriverManager.getConnection(url, "root",""); //en local
            //conn=DriverManager.getConnection(url, "PDSIG","PDSIG"); // A  l'école

            stat=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            //on peut parcourir le résultat dans les 2 sens, insensible aux chgmts d'autrui
            //on peut modifier ce résultat pour ensuite reporter ces modifs ds la table (updateRow)
            conn.setAutoCommit(false);
            connected=true;
	}
        catch (SQLException e){
            System.out.println(e.toString());
        }
    }

   /* ferme la connexion. */
    @Override
   public void close()
    {
	try {
            conn.close();
            connected=false;
            }
        catch (SQLException e){
            System.out.println(e.toString());
            }
    }

    /* Pattern Singleton */
    public static DAOConnexionMySQL getInstance()
    {
        return uniqueInstance;
    }

    /*Cette fct retourne l'état de l'objet: connecté/déconnecté */
    public boolean isConnected()
    {
	return connected;
    }


    /*Cette fct retourne le résultat de la requête demandée par l'utilisateur. */
    public ResultSet selectQuery(String query)
    {
        ResultSet m_rs=null;
	if(connected)
            try {
               	m_rs=stat.executeQuery(query);
		}
            catch (SQLException e){
		System.out.println(e.toString());
                System.out.println("Requete: " + query);
		}
	else
            System.out.println("Objet non connecte! Echec fct.");
	return m_rs;
    }

    /*Cette fct permet d'exécuter une requête d'action. */
    public boolean actionQuery(String query)
    {
	boolean b=false;
	try {
            stat.executeUpdate(query);
            b=true;
            conn.commit();  // force à exécuter la requête sur la BDD
            }
        catch (SQLException e){
            System.out.println(e.toString());
            System.out.println("Requete :" + query);
            }
	return b;
    }
}
